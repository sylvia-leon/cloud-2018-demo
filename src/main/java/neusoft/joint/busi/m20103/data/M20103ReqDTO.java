package neusoft.joint.busi.m20103.data;

import neusoft.joint.core.dto.JointUserConextModel;

import java.util.Map;

/**
 * 锁单请求DTO
 *
 * @author liangliang@neusoft.com
 * @title
 * @date 2017年5月23日 下午1:58:11
 */

public class M20103ReqDTO extends JointUserConextModel {

    private String personNo; // 人员编号
    private String name; // 姓名
    private String idtype; // 缴费记录号类型
    private String idno; // 缴费记录号
    private String accessTerminal; // 接入终端(App/Web 204/205)
    // 附加参数
    private Map others;

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getIdtype() {
        return idtype;
    }

    @Override
    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    @Override
    public String getIdno() {
        return idno;
    }

    @Override
    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getAccessTerminal() {
        return accessTerminal;
    }

    public void setAccessTerminal(String accessTerminal) {
        this.accessTerminal = accessTerminal;
    }

    public Map getOthers() {
        return others;
    }

    public void setOthers(Map others) {
        this.others = others;
    }
}
