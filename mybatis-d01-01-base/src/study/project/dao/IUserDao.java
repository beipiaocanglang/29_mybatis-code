package study.project.dao;

import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public interface IUserDao {

    //查询所有
    public List<User> findAll();

    //根据idea查询user
    public User findUserById(Integer id);
}
