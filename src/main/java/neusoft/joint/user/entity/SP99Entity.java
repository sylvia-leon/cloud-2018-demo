package neusoft.joint.user.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

@Table("SP99")
public class SP99Entity {
	@Column
	private String aac001;//个人编号
	@Column
	private String aac003;//姓名
	@Column
	private String aac135;//身份证号
	@Column
	private String aac058;//证件类型
	@Column
	private String aab301;//参保地编码
	@Column
	private byte[] face;//人脸
	@Column
	private String aac084;//养老退休状态
	@Column
	private String sac122;//养老认证状态
	public String getAac001() {
		return aac001;
	}
	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}
	public String getAac003() {
		return aac003;
	}
	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
	public String getAac135() {
		return aac135;
	}
	public void setAac135(String aac135) {
		this.aac135 = aac135;
	}
	public String getAac058() {
		return aac058;
	}
	public void setAac058(String aac058) {
		this.aac058 = aac058;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	public byte[] getFace() {
		return face;
	}
	public void setFace(byte[] face) {
		this.face = face;
	}
	public String getAac084() {
		return aac084;
	}
	public void setAac084(String aac084) {
		this.aac084 = aac084;
	}
	public String getSac122() {
		return sac122;
	}
	public void setSac122(String sac122) {
		this.sac122 = sac122;
	}
	
	
}
