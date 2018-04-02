package neusoft.joint.busi.m20103;

import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.m20103.data.LevelDTO;
import neusoft.joint.busi.m20103.data.M20103ReqDTO;
import neusoft.joint.busi.m20103.data.M20103RespDTO;
import neusoft.joint.core.annotation.JointComponent;
import neusoft.joint.core.framework.IBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static neusoft.joint.busi.m20103.M20103Comp.SERVER_NAME;


/**
 * 城乡居民养老 缴费档次查询
 *
 * @author leon
 *
 */
@JointComponent(value = SERVER_NAME, reqClass = M20103ReqDTO.class, rspClass = M20103RespDTO.class)
@Component
public class M20103Comp implements IBusinessService<M20103ReqDTO> {

	public static final String SERVER_NAME = "m20103";
	private final static Logger logger = LoggerFactory.getLogger(M20103Comp.class);

	@Override
	public Object rhandle(M20103ReqDTO m20103ReqDTO) throws TracedException {

		logger.info("没有你的测试数据!");
		throw new BusiException(555, "没有你的测试数据！", "没有你的测试数据！");
	}

	@Override
	public Object testHandle(M20103ReqDTO m20103ReqDTO) throws TracedException {

		M20103RespDTO m20103RespDTO = new M20103RespDTO();

		LevelDTO levelDTO = new LevelDTO();
		levelDTO.setToPayLevel("111");
		levelDTO.setToPayLevelDes("一档");
		levelDTO.setToPayLevelAmt("0.01");

		LevelDTO levelDTO2 = new LevelDTO();
		levelDTO2.setToPayLevel("222");
		levelDTO2.setToPayLevelDes("二档");
		levelDTO2.setToPayLevelAmt("0.02");

		LevelDTO levelDTO3 = new LevelDTO();
		levelDTO3.setToPayLevel("333");
		levelDTO3.setToPayLevelDes("三档");
		levelDTO3.setToPayLevelAmt("0.03");

		List<LevelDTO> list = new ArrayList<>();
		list.add(levelDTO);
		list.add(levelDTO2);
		list.add(levelDTO3);

		m20103RespDTO.setFeeLevel(list);
		Map map = new HashMap();
		map.put("insuranceArea", "999999");
		map.put("personNo", "12312254588");
		m20103RespDTO.setOthers(map);
		m20103RespDTO.setResCode("SUCCESS");
		m20103RespDTO.setErrorCode(0);
		m20103RespDTO.setResMsg("查档成功!");
		return m20103RespDTO;
	}
}
