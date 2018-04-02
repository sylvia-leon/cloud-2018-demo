package neusoft.joint.busi.m10101;


import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.m10101.data.FeeM10101ReqDTO;
import neusoft.joint.busi.m10101.data.FeeM10101RespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import org.springframework.stereotype.Component;

/**
 * 缴费通知
 * 
 * @author leon
 *
 */
@JointComponent(value = M10101Comp.SERVICE_NAME_CHENGXIANG, reqClass = FeeM10101ReqDTO.class, rspClass = FeeM10101RespDTO.class)
@Component
public class M10101Comp implements IBusinessService<FeeM10101ReqDTO> {

	public static final String SERVICE_NAME_CHENGXIANG = "m10101";

	@Override
	public Object rhandle(FeeM10101ReqDTO input) throws BusiException {

		logger.info("没有你的测试数据!");
		throw new BusiException(555, "没有你的测试数据！", "没有你的测试数据！");
	}

	@Override
	public Object testHandle(FeeM10101ReqDTO feeM10101ReqDTO) throws TracedException {

		throw new BusiException(2004, "mock到账直接走撤销！（测试999999）", "mock到账直接走撤销！（测试999999）");
	}
}
