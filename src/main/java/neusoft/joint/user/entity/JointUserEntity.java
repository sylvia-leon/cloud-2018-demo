package neusoft.joint.user.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by liuzuo on 2017/8/9.
 */
@Table("sp01_new")
public class JointUserEntity implements IJointUserEntity {
	@Name
    @Column
    private String memberid;
    @Column
    private String aac001;
    @Column
    private String idno;
    @Column
    private String idtype;
    @Column
    private String name;
    @Column
    private String cityid;
    @Column
    private long imglength;
    @Column
    private String imgmd5;
    @Column
    private boolean enable;
    @Column("lock_")
    private boolean lock;
    @Column
    private Date createdate;
    @Column
    private Date modifydate;

    @Override
    public String getMemberid() {
        return memberid;
    }

    @Override
    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    @Override
    public String getAac001() {
        return aac001;
    }

    @Override
    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    @Override
    public String getIdno() {
        return idno;
    }

    @Override
    public void setIdno(String idno) {
        this.idno = idno;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCityid() {
        return cityid;
    }

    @Override
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @Override
    public long getImglength() {
        return imglength;
    }

    @Override
    public void setImglength(long imglength) {
        this.imglength = imglength;
    }

    @Override
    public String getImgmd5() {
        return imgmd5;
    }

    @Override
    public void setImgmd5(String imgmd5) {
        this.imgmd5 = imgmd5;
    }

    @Override
    public boolean isEnable() {
        return enable;
    }

    @Override
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean isLock() {
        return lock;
    }

    @Override
    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public Date getCreatedate() {
        return createdate;
    }

    @Override
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public Date getModifydate() {
        return modifydate;
    }

    @Override
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

	@Override
	public String toString() {
		return "JointUserEntity [memberid=" + memberid + ", aac001=" + aac001 + ", idno=" + idno + ", idtype=" + idtype
				+ ", name=" + name + ", cityid=" + cityid + ", imglength=" + imglength + ", imgmd5=" + imgmd5
				+ ", enable=" + enable + ", lock=" + lock + ", createdate=" + createdate + ", modifydate=" + modifydate
				+ "]";
	}
    
    

}
