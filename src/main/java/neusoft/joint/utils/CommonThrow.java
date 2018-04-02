package neusoft.joint.utils;

import ivy.var.common.CVar;
import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.joint.busi.common.ResultDTO;
import org.springframework.stereotype.Component;

/**
 * Created by leon on 2017/10/16.
 */
@Component
public class CommonThrow {

    public void commonThrow(ResultDTO resultDTO) throws BusiException{

        if(resultDTO.getResCode().equals(CVar.FAILED)){
            switch(resultDTO.getErrorCode()) {
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                case 2006:
                case 2007:
                    throw new BusiException(resultDTO.getErrorCode(), resultDTO.getResMsg(), resultDTO.getResMsg());
                default:
                    throw new BusiException(555, resultDTO.getResMsg(), resultDTO.getResMsg());
            }
        }
    }

}
