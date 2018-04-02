package neusoft.joint.busi.m20104.data;

import neusoft.joint.core.dto.JointUserConextModel;

import java.util.Map;

/**
 * Created by leon on 2017/9/13.
 */
public class FeeM20104ReqDTO extends JointUserConextModel {

    private String memberid; // 移动端id
    private String region; // 行政区划
    private String name; // 姓名
    private String idtype; // 缴费记录号类型
    private String idno; // 缴费记录号
    private String year; // 年度
    private String insurancetype;// 险种
    private Map others; // 附加参数

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
    }

    public Map getOthers() {
        return others;
    }

    public void setOthers(Map others) {
        this.others = others;
    }
}
