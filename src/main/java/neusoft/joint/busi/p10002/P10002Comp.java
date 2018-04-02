package neusoft.joint.busi.p10002;

import ivy.var.common.CVar;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.p10002.data.P10002ReqDTO;
import neusoft.joint.busi.p10002.data.P10002RespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import neusoft.joint.user.entity.JointUserEntity;
import neusoft.joint.user.init.JTransComp;
import neusoft.joint.user.repo.JointUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import telstar.core.tool.Str;

import java.util.Date;

@JointComponent(value = P10002Comp.SERVICE_NAME, reqClass = P10002ReqDTO.class, rspClass = P10002RespDTO.class)
@Component
public class P10002Comp implements IBusinessService<P10002ReqDTO>  {

	public static final String SERVICE_NAME="P10002";
	
	private final static Logger logger = LoggerFactory.getLogger(P10002Comp.class);
	
	@Autowired
	private JointUserDao jointDao;

    @Override
	public Object rhandle(P10002ReqDTO reqDTO) throws TracedException {
		P10002RespDTO respDTO=new P10002RespDTO();
        try {
        	if(Str.isEmpty(reqDTO.getName())) {
        		if(Str.isNotEmpty(reqDTO.getCname())) {
        			reqDTO.setName(reqDTO.getCname());
        		}else {
        			throw new TracedException(555,"","参数异常,未获取到姓名");
        		}
        	}
        	
        	if(Str.isEmpty(reqDTO.getMemberid())) {
        		if(Str.isNotEmpty(reqDTO.getPublicid())) {
        			reqDTO.setMemberid(reqDTO.getPublicid());
        		}else {
        			throw new TracedException(555,"","参数异常,未获取到publicid或memberid");
        		}
        	}
            logger.info("idno:{},idtype:{},name:{},cityid:{}",reqDTO.getIdno(), JTransComp.fetchAac058(reqDTO.getIdtype()), reqDTO.getName(), reqDTO.getCityid());
            JointUserEntity sp01= (JointUserEntity) jointDao.fetchUserNullableByIdno(reqDTO.getIdno(), JTransComp.fetchAac058(reqDTO.getIdtype()), reqDTO.getName(), reqDTO.getCityid());
            if (null != sp01) {
            	sp01.setMemberid(reqDTO.getMemberid());
                sp01.setAac001("");
                sp01.setName(reqDTO.getName());
                sp01.setIdtype(JTransComp.fetchAac058(reqDTO.getIdtype()));
                sp01.setIdno(reqDTO.getIdno());
                sp01.setCityid(reqDTO.getCityid());
                sp01.setEnable(reqDTO.isEnable());
                sp01.setLock(false);
                sp01.setModifydate(new Date());
                logger.info("before insert");
                logger.info(sp01.toString());
                jointDao.insertOrUpdate(sp01);
                logger.info("P10002 Success, Update, idno is: {},idtype is :{}, cname is: {}, aac001 is: {};", sp01.getIdno(),sp01.getIdtype(),
                        sp01.getName(), sp01.getAac001());
            } else {
            	sp01 = new JointUserEntity();
            	sp01.setMemberid(reqDTO.getMemberid());
                sp01.setAac001("");
                sp01.setName(reqDTO.getName());
                sp01.setIdtype(JTransComp.fetchAac058(reqDTO.getIdtype()));
                sp01.setIdno(reqDTO.getIdno());
                sp01.setCityid(reqDTO.getCityid());
                sp01.setEnable(reqDTO.isEnable());
                sp01.setLock(false);
                sp01.setCreatedate(new Date());
                sp01.setModifydate(new Date());
                logger.info("before update");
                logger.info(sp01.toString());
                jointDao.insertOrUpdate(sp01);
                logger.info("P10002 Success, Update, idno is: {}, cname is: {}, aac001 is: {};", sp01.getIdno(),
                        sp01.getName(), sp01.getAac001());
            }
            respDTO.setRes(CVar.OK);
            return respDTO;
        } catch (TracedException e) {
        	logger.error("Traced错误",e);
        	logger.error(e.getMessage());
        	throw e;
        } catch (Exception e) {
            logger.error("未知异常",e.getMessage());
            throw new TracedException(599,"P10000实名异常，未知异常","未知异常");
        }
	}

    @Override
    public Object testHandle(P10002ReqDTO p10002ReqDTO) throws TracedException {
        return null;
    }

}
