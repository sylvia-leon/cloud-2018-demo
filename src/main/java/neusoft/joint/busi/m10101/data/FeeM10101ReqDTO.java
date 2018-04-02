package neusoft.joint.busi.m10101.data;

import neusoft.joint.core.dto.JointUserConextModel;

import java.util.Date;
import java.util.Map;

/**
 * 缴费通知请求DTO
 *
 * @author leon
 */

public class FeeM10101ReqDTO extends JointUserConextModel {

    private String personNo; // 人员编号
    private String name; // 姓名
    private String idtype; // 缴费记录号类型
    private String idno; // 缴费记录号
    private String paymentapprovedOrderId; //缴费核定流水号
    private String payStatus; //支付状态
    private Date payTime; //支付成功时间
    private String channels = "1"; //缴费平台
    private String channelId; //支付渠道
    private String accessTerminal; // 接入终端
    private String topayAmt; //金额
    private String channelOrderId; // 渠道单号
    // 附加参数
    private Map restMap;

    public String getPersonNo() {
        return personNo;
    }

    public String getName() {
        return name;
    }

    public String getIdtype() {
        return idtype;
    }

    public String getIdno() {
        return idno;
    }

    public String getPaymentapprovedOrderId() {
        return paymentapprovedOrderId;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public String getChannels() {
        return channels;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getAccessTerminal() {
        return accessTerminal;
    }

    public String getTopayAmt() {
        return topayAmt;
    }

    public String getChannelOrderId() {
        return channelOrderId;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public void setPaymentapprovedOrderId(String paymentapprovedOrderId) {
        this.paymentapprovedOrderId = paymentapprovedOrderId;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setAccessTerminal(String accessTerminal) {
        this.accessTerminal = accessTerminal;
    }

    public void setTopayAmt(String topayAmt) {
        this.topayAmt = topayAmt;
    }

    public void setChannelOrderId(String channelOrderId) {
        this.channelOrderId = channelOrderId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Map getRestMap() {
        return restMap;
    }

    public void setRestMap(Map restMap) {
        this.restMap = restMap;
    }
}
