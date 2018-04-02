package neusoft.joint.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import neusoft.ihrss.cloud.nt.exception.BusiException;

/**
 * Created by leon on 2017/6/26.
 */
public class ConvertToJsonString {

    public static String convertToJson(Object o) throws BusiException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusiException("DTO to Json chu xian yi chang");
        }
    }

}
