package neusoft.joint.utils;

import org.apache.log4j.Logger;


/**
 * 所有的状态类枚举以后都添加都此枚举类里
 * @title	
 * @author laingliang@neusoft.com
 * @date 2017年5月23日 上午9:53:13 
 */

public class EnumUtils {
    private static Logger logger = Logger.getLogger(EnumUtils.class);

    /**
     * 根据code得到枚举
     * @title 
     * @date 2016年5月17日 上午10:38:37 
     * @author qinsong
     * @param values
     * @param code
     * @return
     */
    protected static DicEnumInterface parse(DicEnumInterface[] values,int code){
        for(DicEnumInterface cur:values){
            if(cur.getCode() == code){
                return cur;
            }
        }
        return null;
    }
    
    /**
     * 缴费业务交易码
     * @title	
     * @author qinsong
     * @date 2016年12月27日 上午9:54:36
     */
    public static enum ProvidentFundBusiCode implements DicEnumInterface {
    	/**
    	 * 业务交易码	功能简介
    		1013	欠费查询
            1013	缴费核定
    		1015	缴费结果通知
    	 * */

        arrearsInfo(1013, "1013"),
        paymentInfo(1013, "1013"),
        notifyInfo(1015, "1015");

        private final int code;
        private final String name;

		ProvidentFundBusiCode(int code,String name){
            this.code = code;
            this.name = name;
        }
        
        public int getCode() {
            return code;
        }
        
        public String getName() {
            return name;
        }
        
        public static ProvidentFundBusiCode parse(int code){
            return (ProvidentFundBusiCode) EnumUtils.parse(ProvidentFundBusiCode.values(), code);
        }
    }

}