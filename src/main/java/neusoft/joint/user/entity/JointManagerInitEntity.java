package neusoft.joint.user.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * 经办人员初始化信息
 * @author Frank
 *
 */
@Table("sp01_managerinit")
public class JointManagerInitEntity {
	@Column
	private Long id;//主键
	@Column
	private String idno;//证件号码
	@Column
	private String idtype;//证件类型
	@Column
	private String name;//姓名
	@Column
	private String aaa027;//经办人统筹区号
	@Column
	private String aaa027Desc;//统筹区号描述
	@Column
	private byte face;//人脸信息
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getAaa027() {
		return aaa027;
	}
	public void setAaa027(String aaa027) {
		this.aaa027 = aaa027;
	}
	public String getAaa027Desc() {
		return aaa027Desc;
	}
	public void setAaa027Desc(String aaa027Desc) {
		this.aaa027Desc = aaa027Desc;
	}
	public byte getFace() {
		return face;
	}
	public void setFace(byte face) {
		this.face = face;
	}
	
	
	
}
