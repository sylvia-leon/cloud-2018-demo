package neusoft.joint.busi.m20105.data;

import neusoft.joint.core.dto.JointUserConextModel;

import java.util.Map;

/**
 * Created by leon on 2017/9/13.
 */
public class FeeM20105ReqDTO extends JointUserConextModel {

    private String personNo; // 人员编号
    private String name; // 姓名
    private String idtype; // 缴费记录号类型
    private String idno; // 缴费记录号
    private String paymentapprovedOrderId; //缴费核定流水号
    private String accessTerminal; // 接入终端(App/Web 204/205)
    private String channelId; // 渠道id
    private String channels = "1"; // 缴费平台
    private String lockType; //锁类型
    // 附加参数
    private Map others;

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getPaymentapprovedOrderId() {
        return paymentapprovedOrderId;
    }

    public void setPaymentapprovedOrderId(String paymentapprovedOrderId) {
        this.paymentapprovedOrderId = paymentapprovedOrderId;
    }

    public String getAccessTerminal() {
        return accessTerminal;
    }

    public void setAccessTerminal(String accessTerminal) {
        this.accessTerminal = accessTerminal;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

    public Map getOthers() {
        return others;
    }

    public void setOthers(Map others) {
        this.others = others;
    }
}
