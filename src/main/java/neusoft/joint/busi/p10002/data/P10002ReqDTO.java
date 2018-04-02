package neusoft.joint.busi.p10002.data;

import neusoft.joint.core.dto.JointUserConextModel;

import java.io.Serializable;

public class P10002ReqDTO extends JointUserConextModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048636618129884720L;

	private boolean enable;// 是否可用

	private String cname;//姓名
	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
