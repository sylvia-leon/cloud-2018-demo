package neusoft.joint.busi.p10000;

import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.user.entity.JointUserEntity;
import neusoft.joint.user.repo.JointUserDao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.sql.Sql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Types;

/**
 * 3.10获取人员状态
 * @author Administrator
 *
 */
@Component
public class CallTXQueryMethod {
	
	private final static Logger logger = LoggerFactory.getLogger(CallTXQueryMethod.class);
	
	@Autowired
	private JointUserDao jointDao;
	
	/**
	 * 可以加经办人统筹区
	 * @param idtype
	 * @param idno
	 * @param name
	 * @param aaa027 经办人统筹区
	 * @return
	 * @throws TracedException
	 */
	public  Record method(String idtype,String idno,String name,String aaa027) throws TracedException {
		
		try {
			Sql sql = Sqls.fetchEntity("CALL TXQUERY(@AAC058,@AAE135,@AAC003,@AAA027,@OUT_PRM_V_AAC003,@OUT_PRM_V_AAC001,@OUT_PRM_V_AAC084,@OUT_PRM_APPCODE,@OUT_PRM_ERRMSG)");
			sql.setEntity(jointDao.getDao().getEntity(JointUserEntity.class));
	        sql.params().set("AAC058", idtype);
	        sql.params().set("AAE135", idno);
	        sql.params().set("AAC003", name);
	        sql.params().set("AAA027", aaa027);//经办人统筹区
	        sql.params().set("OUT_PRM_V_AAC003", Types.VARCHAR);
	        sql.params().set("OUT_PRM_V_AAC001", Types.VARCHAR);
	        sql.params().set("OUT_PRM_V_AAC084", Types.VARCHAR);
	        sql.params().set("OUT_PRM_APPCODE", Types.INTEGER);
	        sql.params().set("OUT_PRM_ERRMSG", Types.VARCHAR);
	        jointDao.getDao().execute(sql);
	        Record re = sql.getOutParams();
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("存储过程异常",e);
			throw new TracedException(555,"存储过程异常","存储过程异常");
		}

	}
	
	/**
	 * 对市民使用
	 * @param idtype
	 * @param idno
	 * @param name
	 * @return
	 * @throws TracedException 
	 */
	
	public Record method(String idtype,String idno,String name) throws TracedException {
		return method(idtype, idno, name,"");
	}
}
