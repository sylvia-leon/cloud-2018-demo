package neusoft.joint.user.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import neusoft.joint.user.entity.AA10Entity;
import neusoft.joint.user.entity.JAAC058Entity;
import neusoft.joint.user.repo.JointUserDao;
@Component
public class JTransComp implements InitializingBean  {

    @Autowired
    private JointUserDao jointDao;
 
    public static Map<String, String> jaac058Map;// 证件类型
    
	private final static Logger logger = LoggerFactory.getLogger(JTransComp.class);
	
	
	private static Map<String, Map<String,String>> secondKeyMap;//key为二级代码名称字段，value中存此二级代码名称对应的code，value值
	
	
    
    public static Map<String, Map<String, String>> getSecondKeyMap() {
		return secondKeyMap;
	}

	@Override
    public void afterPropertiesSet() throws Exception {
        jaac058Map = new HashMap<String, String>();
        List<JAAC058Entity> jaac058Entities = (List<JAAC058Entity>) jointDao.getDao().query(JAAC058Entity.class, null);
        for (JAAC058Entity item : jaac058Entities) {
            jaac058Map.put(item.getMaac058(), item.getAac058());
        }
        logger.info("init JAAC058 into memory");
        
        
        List<AA10Entity> aa10EntitieList=jointDao.getDao().query(AA10Entity.class,null);
        if(null!=aa10EntitieList) {
        	secondKeyMap=new HashMap<>();
        	for(AA10Entity aEntity:aa10EntitieList) {
        		String secondKeyName=aEntity.getAaa100();
        		if(null == secondKeyMap.get(secondKeyName)) {//没有二级代码则新建二级代码对应的map
        			secondKeyMap.put(secondKeyName, new HashMap<>());
        			logger.info("init 二级代码转换"+secondKeyName);
        		}
        	}
        	
        	for(AA10Entity aEntity:aa10EntitieList) {
        		String secondKeyName=aEntity.getAaa100();
        		String secondCode=aEntity.getAaa102();//二级代码
        		String secondValue=aEntity.getAaa103();//二级代码名称
        		//将二级代码下的key与value初始化进去
        		secondKeyMap.get(secondKeyName).put(secondCode, secondValue);
        	}
        }
        
    }
 
    public static String fetchAac058(String mjaac058) {
        return jaac058Map.get(mjaac058);
    }
    /**
     * 返回二级代码对应值
     * @param secondKey
     * @param SecondCode
     * @return
     */
    public static String fetchSecondCodeTrans(String secondKey,String secondCode) {
    	Map<String,String> secondMap=secondKeyMap.get(secondKey);
    	if(null==secondMap) {
    		return "二级代码未定义";
    	}else {
    		return fetchSecondValue(secondMap, secondCode);
    	}
    }
    /**
     * 转换key value 
     * @param map
     * @param secondCode
     * @return
     */
    private static String fetchSecondValue(Map<String,String> map,String secondCode) {
    	String secondValue=map.get(secondCode);
    	if(null==secondValue) {
    		return "未定义";
    	}else {
    		return secondValue;
    	}
    }

}
