package study.project.dao;

import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public interface UserMapper {
    /**
     * 查询user表
     */
    List<User> findUser();
}
