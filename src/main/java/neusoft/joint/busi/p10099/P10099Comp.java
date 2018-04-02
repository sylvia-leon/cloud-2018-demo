package neusoft.joint.busi.p10099;


import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.p10099.data.P10099ReqDTO;
import neusoft.joint.busi.p10099.data.P10099RspDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import neusoft.joint.user.entity.SP99Entity;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JointComponent(value = P10099Comp.SERVICE_NAME, reqClass = P10099ReqDTO.class, rspClass = P10099RspDTO.class)
@Component
public class P10099Comp implements IBusinessService<P10099ReqDTO> {
	public static final String SERVICE_NAME = "P10099";
	
	private final static Logger logger = LoggerFactory.getLogger(P10099Comp.class);
	
	@Autowired
	private Dao dao;

	@Override
	public Object rhandle(P10099ReqDTO reqDTO) throws TracedException {

        try {
        	SP99Entity sp99Entity=dao.fetch(SP99Entity.class,
        			Cnd.where("aac058","=",reqDTO.getIdtype())
        			.and("aae135","=",reqDTO.getIdno())
        			.and("aab301","=",reqDTO.getCityid()));
        	if(!(null==sp99Entity||null==sp99Entity.getFace())) {
        		P10099RspDTO rspDTO=new P10099RspDTO();
        		rspDTO.setFace(sp99Entity.getFace());
        		rspDTO.setAac003(sp99Entity.getAac003());
        		return rspDTO;
        	}else {
        		logger.error("P10099 Error, no pic found, idno:{},idtype:{},name:{}",reqDTO.getIdno(),reqDTO.getIdtype(),reqDTO.getName());
            	throw new TracedException(555,"P10099未获取到照片","业务失败，未获取到照片！请联系当地社保机构");
        	}
        } catch (TracedException e) {
        	logger.error("P10099 Exception :" + e.getMessage());
        	throw e;
        } catch (Exception e) {
        	logger.error(SERVICE_NAME+" Error:"+ e);
        	throw new TracedException(599,"P10099获取持卡库照片失败，未知异常","获取照片失败，未知异常");
        }
	}

	@Override
	public Object testHandle(P10099ReqDTO arg0) throws TracedException {
		// TODO Auto-generated method stub
		return null;
	}
}
