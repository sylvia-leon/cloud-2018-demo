package neusoft.joint.user.repo;

import neusoft.joint.user.entity.JointUserEntity;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by liuzuo on 2017/8/9.
 */
@Repository
public class JointUserDao implements IJointUserDao<JointUserEntity> {

    @Autowired
    private Dao dao;

    @Override
    public Dao getDao() {
        return dao;
    }

    @Override
    public Class<JointUserEntity> getJointUserEntityClass() {
        return JointUserEntity.class;
    }
}
