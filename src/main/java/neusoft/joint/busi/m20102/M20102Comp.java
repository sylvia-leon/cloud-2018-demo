package neusoft.joint.busi.m20102;

import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.m20102.data.FeeM20102ReqDTO;
import neusoft.joint.busi.m20102.data.FeeM20102RespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 缴费锁定
 *
 * @author leon
 *
 */
@JointComponent(value = M20102Comp.SERVICE_NAME, reqClass = FeeM20102ReqDTO.class, rspClass = FeeM20102RespDTO.class)
@Component
public class M20102Comp implements IBusinessService<FeeM20102ReqDTO> {

	public static final String SERVICE_NAME = "m20102";

	@Override
	public Object rhandle(FeeM20102ReqDTO input) throws BusiException {

		logger.info("没有你的测试数据!");
		throw new BusiException(555, "没有你的测试数据！", "没有你的测试数据！");
	}

	@Override
	public Object testHandle(FeeM20102ReqDTO feeM20102ReqDTO) throws TracedException {

		FeeM20102RespDTO feeM20102RespDTO = new FeeM20102RespDTO();
		feeM20102RespDTO.setApprovedno("mockDemo" + UUID.randomUUID().toString().replace("-", ""));
		feeM20102RespDTO.setExpireTime(new Date(new Date().getTime() + 60 * 60 * 1000));
		feeM20102RespDTO.setResCode("SUCCESS");
		feeM20102RespDTO.setErrorCode(0);
		feeM20102RespDTO.setResMsg("锁定成功!");

		return feeM20102RespDTO;
	}

}
