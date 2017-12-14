package study.project.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.project.dao.UserMapper;
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
     * 传递包装类对象 测试if和where标签的使用
     * 查询性别为nan的姓张的用户
     * 参数包装类QueryVo
     * 返回值 List<User>
     */
    @Test
    public void test01(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setSex("");
        user.setUsername("yeying");
        vo.setUser(user);

        List<User> users = userDao.findUserList(vo);
        for (User use : users) {
            System.out.println(use);
        }
    }
    /**
     * 查询id=10, or id=230, or id=231的用户
     * 参数包装类QueryVo
     * 返回值 List<User>
     */
    @Test
    public void test02(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(230);
        ids.add(231);
        vo.setIds(ids);

        List<User> users = userDao.findUserByOR(vo);
        for (User use : users) {
            System.out.println(use);
        }
    }

    /**
     * 查询id in(10,230,231)的用户
     * select * from user WHERE id in ( ? , ? , ? )
     * 参数包装类QueryVo
     * 返回值 List<User>
     */
    @Test
    public void test03(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(230);
        ids.add(231);
        vo.setIds(ids);

        List<User> users = userDao.findUserByIN(vo);
        for (User use : users) {
            System.out.println(use);
        }
    }
}
