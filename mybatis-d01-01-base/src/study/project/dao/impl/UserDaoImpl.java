package study.project.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import study.project.dao.IUserDao;
import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public class UserDaoImpl implements IUserDao{

    //因为还未和spring整合，所以要使用自己的sessionFactory
    private SqlSessionFactory sessionFactory = null;

    public UserDaoImpl(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> users = sqlSession.selectList("base.findAll");
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        SqlSession sqlSession = sessionFactory.openSession();
        User user = sqlSession.selectOne("base.findUserById", id);
        return user;
    }
}
