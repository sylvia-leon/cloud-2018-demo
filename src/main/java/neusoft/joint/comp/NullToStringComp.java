package neusoft.joint.comp;

import org.springframework.stereotype.Component;

/**
 * Created by leon on 2017/9/14.
 */
@Component
public class NullToStringComp {

    public String nullToString(Object input){

        String result = null;
        if(input == null || input.equals("")){
            result = "";
        }else{
            result = input.toString();
        }
        return result;
    }

}
