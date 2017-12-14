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
     * 传递包装类对象
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
        user.setSex("nan");
        user.setUsername("yeying");
        vo.setUser(user);

        List<User> users = userDao.findUserList(vo);
        for (User use : users) {
            System.out.println(use);
        }
    }

    /**
     * 传递map类型
     * 查询性别为nan的姓张的用户
     * 参数包装类QueryVo
     * 返回值 List<User>
     */
    @Test
    public void test02(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put("sex", "nan");
        maps.put("username", "yeying");

        List<User> users = userDao.findUserMap(maps);
        for (User use : users) {
            System.out.println(use);
        }
    }

    /**
     * 传递包装类对象
     * 查询性别为nan的姓张的用户的总记录数
     * 参数包装类QueryVo
     * 返回值 List<User>
     */
    @Test
    public void test03(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setSex("nan");
        user.setUsername("yeying");
        vo.setUser(user);

        int count = userDao.findCountResultInt(vo);
        System.out.println("总计路数："+count);
    }

    /**
     * 使用别名查询所有username和address字段
     * 返回值 List<User>
     */
    @Test
    public void test04(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userByAlias = userDao.findUserByAlias();
        for (User userByAlia : userByAlias) {
            System.out.println(userByAlia);
        }
    }
}
