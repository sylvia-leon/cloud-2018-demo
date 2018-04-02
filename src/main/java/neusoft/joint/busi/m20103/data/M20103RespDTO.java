package neusoft.joint.busi.m20103.data;

import neusoft.joint.busi.common.ResultDTO;

import java.util.List;
import java.util.Map;

/**
 * 缴费核定返回DTO
 *
 * @author liangliang@neusoft.com
 * @title
 * @date 2017年5月23日 下午1:58:11
 */

public class M20103RespDTO extends ResultDTO {

    private List<LevelDTO> feeLevel;
    private Map<String, Object> others;

    public List<LevelDTO> getFeeLevel() {
        return feeLevel;
    }

    public void setFeeLevel(List<LevelDTO> feeLevel) {
        this.feeLevel = feeLevel;
    }

    public Map<String, Object> getOthers() {
        return others;
    }

    public void setOthers(Map<String, Object> others) {
        this.others = others;
    }
}
