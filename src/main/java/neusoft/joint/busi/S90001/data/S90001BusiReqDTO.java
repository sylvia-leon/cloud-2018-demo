package neusoft.joint.busi.S90001.data;

import neusoft.joint.core.dto.JointUserConextModel;

/**
 * Created by leon on 2017/8/24.
 */
public class S90001BusiReqDTO extends JointUserConextModel {

    private String busicode;
    private String idno;
    private String idtype;
    private String name;

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
