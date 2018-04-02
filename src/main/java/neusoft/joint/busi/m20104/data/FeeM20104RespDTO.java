package neusoft.joint.busi.m20104.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import neusoft.joint.busi.common.ResultDTO;

import java.util.Map;

/**
 * Created by leon on 2017/9/13.
 */
public class FeeM20104RespDTO extends ResultDTO {

    private String personno; //人员编号(personNo)
    private String name; //姓名
    private String idtype; //身份类型
    private String insurancetype; //险种类型
    private String idno; //身份证号
    private String year; //残暴年度
    private String totalpay; //缴费金额(toPayAmt)
    private String approvedOrderId; //核定流水号
    private String insuranceArea; //参保地区
    private Map map; //附加参数

    @JsonProperty(value = "personNo")
    public String getPersonno() {
        return personno;
    }

    public void setPersonno(String personno) {
        this.personno = personno;
    }

    @JsonProperty(value = "toPayAmt")
    public String getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(String totalpay) {
        this.totalpay = totalpay;
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

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
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

    public String getInsuranceArea() {
        return insuranceArea;
    }

    public void setInsuranceArea(String insuranceArea) {
        this.insuranceArea = insuranceArea;
    }

    public String getApprovedOrderId() {
        return approvedOrderId;
    }

    public void setApprovedOrderId(String approvedOrderId) {
        this.approvedOrderId = approvedOrderId;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
