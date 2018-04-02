package neusoft.joint.busi.p10099.data;

import java.io.Serializable;

public class P10099RspDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2743717963237239583L;

	
    private byte[] face;//人脸信息
    
    private String aac003;//姓名

    public byte[] getFace() {
        return face;
    }

    public void setFace(byte[] face) {
        this.face = face;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

	@Override
	public String toString() {
		return "P10099ResponseDTO [face=" + ( null != face ? face.length : "null" ) + ", aac003=" + aac003 + "]";
	}
}
