package neusoft.joint.busi.m20105;


import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.m20105.data.FeeM20105ReqDTO;
import neusoft.joint.busi.m20105.data.FeeM20105RespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 *
 * 缴费锁定（灵活就业）
 * Created by leon on 2017/9/6.
 */
@JointComponent(value = M30103Comp.SERVICE_NAME, reqClass = FeeM20105ReqDTO.class, rspClass = FeeM20105RespDTO.class)
@Component
public class M30103Comp implements IBusinessService<FeeM20105ReqDTO> {

    public static final String SERVICE_NAME = "m20105";

    @Override
    public Object rhandle(FeeM20105ReqDTO feeM20105ReqDTO) throws BusiException {

        logger.info("没有你的测试数据!");
        throw new BusiException(555, "没有你的测试数据！", "没有你的测试数据！");
    }

    @Override
    public Object testHandle(FeeM20105ReqDTO feeM20105ReqDTO) throws TracedException {

        FeeM20105RespDTO feeM20105RespDTO = new FeeM20105RespDTO();
        feeM20105RespDTO.setSerialno("mockDemo" + UUID.randomUUID().toString().replace("-", ""));
        feeM20105RespDTO.setExpireTime(new Date(new Date().getTime() + 60 * 60 * 1000));
        feeM20105RespDTO.setResCode("SUCCESS");
        feeM20105RespDTO.setErrorCode(0);
        feeM20105RespDTO.setResMsg("锁定成功!");

        return feeM20105RespDTO;
    }
}
