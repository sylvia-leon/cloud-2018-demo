package neusoft.joint.busi.m20101;

import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.m20101.data.FeeM20101ReqDTO;
import neusoft.joint.busi.m20101.data.FeeM20101RespDTO;
import neusoft.joint.busi.m20101.data.InDTO;
import neusoft.joint.comp.RestComp;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * 缴费查询
 * 
 * @author leon
 *
 */
@JointComponent(value = M20101Comp.SERVICE_NAME, reqClass = FeeM20101ReqDTO.class, rspClass = FeeM20101RespDTO.class)
@Component
public class M20101Comp implements IBusinessService<FeeM20101ReqDTO> {

	public static final String SERVICE_NAME = "m20101";

	@Autowired
	private RestComp restComp;

	@Override
	public Object rhandle(FeeM20101ReqDTO input) throws BusiException {

		logger.info("没有你的测试数据!");
		throw new BusiException(555, "没有你的测试数据！", "没有你的测试数据！");
	}

	@Override
	public Object testHandle(FeeM20101ReqDTO feeM20101ReqDTO) throws TracedException {

		String url = "https://api.weixin.qq.com/cgi-bin/user/info";

		File file  = new File("D:\\in.txt");
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		String all = "";
		try {
			fileInputStream = new FileInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = bufferedReader.readLine()) != null){
				buffer.append(line);
			}
			all = buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] openIdList = all.split(",");
		StringBuilder stringBuilder = new StringBuilder();

		InDTO inDTO = new InDTO();

		for(String openId : openIdList){
			String nickName = null;
			inDTO.setOpenid(openId);
			try {
				nickName = restComp.get(url, inDTO, String.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			stringBuilder.append(openId).append(",").append(nickName);
		}

		String out = stringBuilder.toString();

		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(new File("D:\\out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fileOutputStream.write(out.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
