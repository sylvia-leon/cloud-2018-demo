package neusoft.joint.busi.m20104;

import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.m20104.data.FeeM20104ReqDTO;
import neusoft.joint.busi.m20104.data.FeeM20104RespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import org.springframework.stereotype.Component;

/**
 *
 * 缴费查询（灵活就业）
 * Created by leon on 2017/9/6.
 */
@JointComponent(value = M30102Comp.SERVICE_NAME, reqClass = FeeM20104ReqDTO.class, rspClass = FeeM20104RespDTO.class)
@Component
public class M30102Comp implements IBusinessService<FeeM20104ReqDTO> {

    public static final String SERVICE_NAME = "m20104";

    @Override
    public Object rhandle(FeeM20104ReqDTO input) throws BusiException {

        logger.info("没有你的测试数据!");
        throw new BusiException(555, "没有你的测试数据！", "没有你的测试数据！");
    }

    @Override
    public Object testHandle(FeeM20104ReqDTO feeM20104ReqDTO) throws TracedException {

        String insurancetype = "";
        if(feeM20104ReqDTO.getOthers() != null &&
           feeM20104ReqDTO.getOthers().get("insurancetype") != null &&
           !feeM20104ReqDTO.getOthers().get("insurancetype").equals("")){
            insurancetype = feeM20104ReqDTO.getOthers().get("insurancetype").toString();
        }

        FeeM20104RespDTO feeM20104RespDTO = new FeeM20104RespDTO();
        feeM20104RespDTO.setIdno(feeM20104ReqDTO.getIdno());
        feeM20104RespDTO.setName(feeM20104ReqDTO.getName());
        feeM20104RespDTO.setInsuranceArea("999999");
        feeM20104RespDTO.setInsurancetype(insurancetype.equals("01") ? "灵活就业医疗保险" : "灵活就业养老保险");
        feeM20104RespDTO.setTotalpay("0.05");
        feeM20104RespDTO.setResCode("SUCCESS");
        feeM20104RespDTO.setErrorCode(0);
        feeM20104RespDTO.setResMsg("查询成功!");

        return feeM20104RespDTO;
    }
}
