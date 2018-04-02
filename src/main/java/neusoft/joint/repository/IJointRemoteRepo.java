package neusoft.joint.repository;

import neusoft.joint.busi.S90001.data.S90001BusiReqDTO;
import neusoft.joint.busi.S90002.data.S90002BusiReqDTO;
import neusoft.joint.busi.S90003.data.S90003BusiReqDTO;

/**
 * Created by leon on 2017/6/20.
 */
public interface IJointRemoteRepo {

    Object busiS90001(S90001BusiReqDTO input) throws Exception;

    Object busiS90002(S90002BusiReqDTO input) throws Exception;

    Object busiS90003(S90003BusiReqDTO input) throws Exception;

}
