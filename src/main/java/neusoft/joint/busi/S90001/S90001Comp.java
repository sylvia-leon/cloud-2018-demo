package neusoft.joint.busi.S90001;

import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.S90001.data.S90001BusiReqDTO;
import neusoft.joint.busi.S90001.data.S90001BusiRespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import neusoft.joint.repository.impl.JointRemoteRepoImpl;
import neusoft.joint.utils.ConvertToJsonString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by leon on 2017/8/30.
 */
@JointComponent(value = S90001Comp.SERVICE_NAME, reqClass = S90001BusiReqDTO.class, rspClass = S90001BusiRespDTO.class)
@Component
public class S90001Comp implements IBusinessService<S90001BusiReqDTO> {

    public static final Logger logger = LoggerFactory.getLogger(S90001Comp.class);
    public static final String SERVICE_NAME = "S90001";
    @Autowired
    private JointRemoteRepoImpl jointRemoteRepo;

    @Override
    public Object rhandle(S90001BusiReqDTO s90001BusiReqDTO) throws TracedException {

        logger.info("请求参数：" + ConvertToJsonString.convertToJson(s90001BusiReqDTO));
        S90001BusiRespDTO s90001BusiRespDTO = new S90001BusiRespDTO();
        try {
            Map map = (Map) jointRemoteRepo.busiS90001(s90001BusiReqDTO);
            if(map != null){
                s90001BusiRespDTO.setRedirectUrl(map.get("url").toString());
            }
        } catch (Exception e) {
            logger.info("医保鉴权出现异常!");
            throw new TracedException(599, "医保鉴权出现异常!", "医保鉴权出现异常!");
        }
        return s90001BusiRespDTO;
    }

    @Override
    public Object testHandle(S90001BusiReqDTO s90001BusiReqDTO) throws TracedException {
        return null;
    }
}