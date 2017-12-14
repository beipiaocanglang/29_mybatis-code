package study.project.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import study.project.dao.UserMapper;
import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/13.
 */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    /**
     * 传统dao开发
     * 整合了spring就可以extends SqlSessionDaoSupport就相当于创建了一个工厂
     * @return
     */
    @Override
    public List<User> findUser() {

        List<User> list = this.getSqlSession().selectList("study.project.dao.UserMapper.findUser");

        return list;
    }
}
