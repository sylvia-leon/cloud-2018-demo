package neusoft.joint.busi.m20102.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import neusoft.joint.busi.common.ResultDTO;

import java.util.Date;

/**
 * Created by leon on 2017/9/11.
 */
public class FeeM20102RespDTO extends ResultDTO {

    private String approvedno; //核定流水号(paymentapprovedOrderId)
    private Date expireTime;

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @JsonProperty(value = "paymentapprovedOrderId")
    public String getApprovedno() {
        return approvedno;
    }

    public void setApprovedno(String approvedno) {
        this.approvedno = approvedno;
    }
}
