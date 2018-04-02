package neusoft.joint.busi.m20105.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import neusoft.joint.busi.common.ResultDTO;

import java.util.Date;

/**
 * Created by leon on 2017/9/13.
 */
public class FeeM20105RespDTO extends ResultDTO {

    private String serialno; //核定流水号(approvedOrderId)
    private Date expireTime;

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @JsonProperty(value = "paymentapprovedOrderId")
    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }
}
