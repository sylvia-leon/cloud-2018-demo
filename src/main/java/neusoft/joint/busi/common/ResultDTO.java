package neusoft.joint.busi.common;

import java.io.Serializable;

/**
 * Created by liuzuo on 16/5/7.
 */
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = 7044365116788341298L;
    private String resCode;
    private String resMsg;
    private int errorCode;

    public String getResCode() {
        return resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ResultDTO(){}

    public ResultDTO(String resCode, String resMsg, int errorCode){
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.errorCode = errorCode;
    }
}
