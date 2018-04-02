package neusoft.joint.repository.impl;

import neusoft.joint.busi.S90001.data.S90001BusiReqDTO;
import neusoft.joint.busi.S90002.data.S90002BusiReqDTO;
import neusoft.joint.busi.S90003.data.S90003BusiReqDTO;
import neusoft.joint.comp.JointRestComp;
import neusoft.joint.option.CenterUrlOption;
import neusoft.joint.repository.IJointRemoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by leon on 2017/6/20.
 */

@Repository("JointRemoteRepoImpl")
public class JointRemoteRepoImpl implements IJointRemoteRepo {

    @Autowired
    private CenterUrlOption centerUrlOption;

    @Autowired
    private JointRestComp jointRestComp;

    @Override
    public Object busiS90001(S90001BusiReqDTO input) throws Exception {
        return jointRestComp.get(centerUrlOption.getS90001(), input, Map.class);
    }

    @Override
    public Object busiS90002(S90002BusiReqDTO input) throws Exception {
        return jointRestComp.get(centerUrlOption.getS90002(), input, Map.class);
    }

    @Override
    public Object busiS90003(S90003BusiReqDTO input) throws Exception {
        return jointRestComp.get(centerUrlOption.getS90003(), input, Map.class);
    }
}
