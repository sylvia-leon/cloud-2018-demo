package neusoft.joint.user.repo;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import neusoft.joint.user.entity.JointManagerEntity;

/**
 * 
 * @author Frank 2017-9-22
 * 
 *  */

@Repository
public class JointManagerDao implements IJointUserDao<JointManagerEntity> {
    @Autowired
    private Dao dao;

    @Override
    public Dao getDao() {
        return dao;
    }

    @Override
    public Class<JointManagerEntity> getJointUserEntityClass() {
        return JointManagerEntity.class;
    }
}
