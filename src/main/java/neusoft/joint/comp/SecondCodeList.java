package neusoft.joint.comp;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 二级码转换
 * Created by leon on 2017/9/14.
 */

@Component
public class SecondCodeList {

    public static final String PERSONNELCATEGORIES = "PERSONNELCATEGORIES";
    public static final String REGIONTYPE = "REGIONTYPE";
    public static final String DISABLEDMARK = "DISABLEDMARK";
    public static final String PAYTYPE = "PAYTYPE";
    private static final HashMap<String, HashMap<String, String>> All_map = new HashMap();
    private static final HashMap<String, String> PERSONNELCATEGORIES_MAP = new HashMap();
    private static final HashMap<String, String> REGIONTYPE_MAP = new HashMap();
    private static final HashMap<String, String> DISABLEDMARK_MAP = new HashMap();
    private static final HashMap<String, String> PAYTYPE_MAP = new HashMap();

    static{
        PERSONNELCATEGORIES_MAP.put("11","在职");
        PERSONNELCATEGORIES_MAP.put("12","在职长期驻外");
        PERSONNELCATEGORIES_MAP.put("13","在职农民工");
        PERSONNELCATEGORIES_MAP.put("21","退休");
        PERSONNELCATEGORIES_MAP.put("22","退休异地安置");
        PERSONNELCATEGORIES_MAP.put("23","建国前参加革命军队的老战士");
        PERSONNELCATEGORIES_MAP.put("24","军队师职转业干部");
        PERSONNELCATEGORIES_MAP.put("25","抗美援朝期间参加革命军队的复转军人");
        PERSONNELCATEGORIES_MAP.put("26","军队团职以下转业干部");
        PERSONNELCATEGORIES_MAP.put("31","离休");
        PERSONNELCATEGORIES_MAP.put("32","老红军");
        PERSONNELCATEGORIES_MAP.put("33","二等乙级伤残军人");
        PERSONNELCATEGORIES_MAP.put("34","特殊全免人员");
        PERSONNELCATEGORIES_MAP.put("91","其他人员");
        PERSONNELCATEGORIES_MAP.put("41","未成年人");
        PERSONNELCATEGORIES_MAP.put("42","中小学生");
        PERSONNELCATEGORIES_MAP.put("43","成年人");
        PERSONNELCATEGORIES_MAP.put("44","老年人");
        PERSONNELCATEGORIES_MAP.put("45","大学生");

        REGIONTYPE_MAP.put("1","城镇（非农业户口）");
        REGIONTYPE_MAP.put("2","农村（农业户口）");
        REGIONTYPE_MAP.put("3","其他");

        DISABLEDMARK_MAP.put("1","重残");
        DISABLEDMARK_MAP.put("0","非重残");

        PAYTYPE_MAP.put("1","现金");
        PAYTYPE_MAP.put("2","小票");
        PAYTYPE_MAP.put("3","POS机");
        PAYTYPE_MAP.put("4","APP");

        All_map.put(PERSONNELCATEGORIES, PERSONNELCATEGORIES_MAP);
        All_map.put(REGIONTYPE, REGIONTYPE_MAP);
        All_map.put(DISABLEDMARK, DISABLEDMARK_MAP);
        All_map.put(PAYTYPE, PAYTYPE_MAP);
    }

    /**
     * key转value
     * @param type
     * @param key
     * @return
     * @throws Exception
     */
    public String key2Value(String type, String key) throws Exception{

        String value = "";
        switch (type){
            case PERSONNELCATEGORIES:
                value = All_map.get(PERSONNELCATEGORIES).get(key);
                break;
            case REGIONTYPE:
                value = All_map.get(REGIONTYPE).get(key);
                break;
            case DISABLEDMARK:
                value = All_map.get(DISABLEDMARK).get(key);
                break;
            case PAYTYPE:
                value = All_map.get(PAYTYPE).get(key);
                break;
        }
        return value;
    }

    /**
     * value转key
     * @param type
     * @param value
     * @return
     * @throws Exception
     */
    public String value2key(String type, String value) throws Exception{

        String key = "";
        for(String getKey : All_map.get(type).keySet()){
           if(All_map.get(type).get(getKey).equals(value)){
                key = getKey;
           }
        }
        return key;
    }

}
