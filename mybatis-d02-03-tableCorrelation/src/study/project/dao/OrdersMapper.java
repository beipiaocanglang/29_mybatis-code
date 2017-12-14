package study.project.dao;

import study.project.domain.Orders;
import study.project.domain.OrdersCustom;

import java.util.List;

/**
 * Created by canglang on 2017/12/12.
 */
public interface OrdersMapper {
    /**
     * 方法一接口：使用resultType关联映射
     * 查询订单关联查询用户，订单也用户是一对一关系
     */
    List<OrdersCustom> findOrdersAndUser();
    /**
     * 方法二接口：使用resultMap关联映射
     * 查询订单关联查询用户，订单也用户是一对一关系
     */
    List<Orders> findOrdersAndUserToMap();
}
