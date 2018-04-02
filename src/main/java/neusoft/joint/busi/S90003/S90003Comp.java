package neusoft.joint.busi.S90003;

import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.S90003.data.S90003BusiReqDTO;
import neusoft.joint.busi.S90003.data.S90003BusiRespDTO;
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
@JointComponent(value = S90003Comp.SERVICE_NAME, reqClass = S90003BusiReqDTO.class, rspClass = S90003BusiRespDTO.class)
@Component
public class S90003Comp implements IBusinessService<S90003BusiReqDTO> {

    public static final Logger logger = LoggerFactory.getLogger(S90003Comp.class);
    public static final String SERVICE_NAME = "S90003";
    @Autowired
    private JointRemoteRepoImpl jointRemoteRepo;

    @Override
    public Object rhandle(S90003BusiReqDTO s90003BusiReqDTO) throws TracedException {

        logger.info("请求参数：" + ConvertToJsonString.convertToJson(s90003BusiReqDTO));
        S90003BusiRespDTO s90003BusiRespDTO = new S90003BusiRespDTO();
        try {
            Map map = (Map) jointRemoteRepo.busiS90003(s90003BusiReqDTO);
            if(map != null){
                s90003BusiRespDTO.setRedirectUrl(map.get("url").toString());
            }
        } catch (Exception e) {
            logger.info("缴费历史鉴权出现异常!");
            throw new TracedException(599, "缴费历史鉴权出现异常!", "缴费历史鉴权出现异常!");
        }
        return s90003BusiRespDTO;
    }

    @Override
    public Object testHandle(S90003BusiReqDTO s90003BusiReqDTO) throws TracedException {
        return null;
    }
}