package neusoft.joint.busi.S90002;

import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.S90002.data.S90002BusiReqDTO;
import neusoft.joint.busi.S90002.data.S90002BusiRespDTO;
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
@JointComponent(value = S90002Comp.SERVICE_NAME, reqClass = S90002BusiReqDTO.class, rspClass = S90002BusiRespDTO.class)
@Component
public class S90002Comp implements IBusinessService<S90002BusiReqDTO> {

    public static final Logger logger = LoggerFactory.getLogger(S90002Comp.class);
    public static final String SERVICE_NAME = "S90002";
    @Autowired
    private JointRemoteRepoImpl jointRemoteRepo;

    @Override
    public Object rhandle(S90002BusiReqDTO s90002BusiReqDTO) throws TracedException {

        logger.info("请求参数：" + ConvertToJsonString.convertToJson(s90002BusiReqDTO));
        S90002BusiRespDTO s90002BusiRespDTO = new S90002BusiRespDTO();
        try {
            Map map = (Map) jointRemoteRepo.busiS90002(s90002BusiReqDTO);
            if(map != null){
                s90002BusiRespDTO.setRedirectUrl(map.get("url").toString());
            }
        } catch (Exception e) {
            logger.info("养老鉴权出现异常!");
            throw new TracedException(599, "养老鉴权出现异常!", "养老鉴权出现异常!");
        }
        return s90002BusiRespDTO;
    }

    @Override
    public Object testHandle(S90002BusiReqDTO s90002BusiReqDTO) throws TracedException {
        return null;
    }
}