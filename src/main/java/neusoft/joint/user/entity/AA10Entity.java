package neusoft.joint.user.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

@Table("AA10_TABLE")
public class AA10Entity {
	@Column
	private Integer id;
	@Column
	private String aaa100;//二级代码编号
	@Column
	private String aaa101;//二级代码名称
	@Column
	private String aaa102;//二级代码key
	@Column
	private String aaa103;//二级代码value
	@Column
	private boolean choose;//是否可被更改
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAaa100() {
		return aaa100;
	}
	public void setAaa100(String aaa100) {
		this.aaa100 = aaa100;
	}
	public String getAaa102() {
		return aaa102;
	}
	public void setAaa102(String aaa102) {
		this.aaa102 = aaa102;
	}
	public String getAaa101() {
		return aaa101;
	}
	public void setAaa101(String aaa101) {
		this.aaa101 = aaa101;
	}
	public String getAaa103() {
		return aaa103;
	}
	public void setAaa103(String aaa103) {
		this.aaa103 = aaa103;
	}
	public boolean isChoose() {
		return choose;
	}
	public void setChoose(boolean choose) {
		this.choose = choose;
	}
	
	
}
