package neusoft.joint.option;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by leon on 2017/9/21.
 */
@Component
public class PostTargetAttributeOption {

    @Value("${http.targetAttribute.token}")
    private String token;
    @Value("${http.targetAttribute.toUser}")
    private String toUser;
    @Value("${http.targetAttribute.fromUser}")
    private String fromUser;

    private String business;
    @Value("${http.targetAttribute.nonce}")
    private String nonce;
    @Value("${http.targetAttribute.createTime}")
    private String createTime;
    @Value("${http.targetAttribute.msgType}")
    private String msgType;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
