package study.project.dao;

import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public interface UserMapper {
    /**
     * 查询user表，关联订单表 用户和订单是一对多关系
     */
    List<User> findUserAndOrders();
}
