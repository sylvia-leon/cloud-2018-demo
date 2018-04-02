package neusoft.joint.user.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

@Table("sp01_manager")
public class JointManagerEntity extends JointUserEntity {
	@Column
	private String aaa027;//经办人统筹区

	public String getAaa027() {
		return aaa027;
	}

	public void setAaa027(String aaa027) {
		this.aaa027 = aaa027;
	}
	
	
}
