package neusoft.joint.user.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("JAAC058")
public class JAAC058Entity {
	@Column
	private String aac058;// 地方证件类型
	@Column
	@Name
	private String maac058;// 移动平台证件类型
	@Column
	private String note;// 说明
	public String getAac058() {
		return aac058;
	}
	public void setAac058(String aac058) {
		this.aac058 = aac058;
	}
	public String getMaac058() {
		return maac058;
	}
	public void setMaac058(String maac058) {
		this.maac058 = maac058;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
