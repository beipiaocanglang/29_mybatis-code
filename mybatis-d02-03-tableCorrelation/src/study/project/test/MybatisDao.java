package study.project.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.project.dao.OrdersMapper;
import study.project.dao.UserMapper;
import study.project.domain.Orders;
import study.project.domain.OrdersCustom;
import study.project.domain.QueryVo;
import study.project.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by canglang on 2017/12/10.
 */
public class MybatisDao {
    SqlSessionFactory sessionFactory = null;
    /**
     * 提取公共代码
     */
    @Before
    public void beforeConfig() throws IOException {
        //1、加载sqlMapConfig.xml全局配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、获取工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 方式一：使用resultType关联映射
     * 查询订单关联查询用户，订单也用户是一对一关系
     * 返回值 List<User>
     */
    @Test
    public void test01(){
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        List<OrdersCustom> ordersAndUser = mapper.findOrdersAndUser();
        for (OrdersCustom ordersCustom : ordersAndUser) {
            System.out.println(ordersCustom);
        }
    }

    /**
     * 方式二：使用resultMap关联映射
     * 查询订单关联查询用户，订单也用户是一对一关系
     * 返回值 List<User>
     */
    @Test
    public void test02(){
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> ordersAndUser = mapper.findOrdersAndUserToMap();
        for (Orders orders : ordersAndUser) {
            System.out.println(orders);
        }
    }

    /**
     * 查询user表，关联订单表 用户和订单是一对多关系
     * 返回值 List<User>
     */
    @Test
    public void test03(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userAndOrders = mapper.findUserAndOrders();
        for (User user : userAndOrders) {
            System.out.println(user);
        }
    }
}
