package study.project.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.project.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public class MybatisTest {
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
     * mybatis的入门案例
     * 需求：查询所有
     * 参数：无
     * 返回值：List<User>
     */
    @Test
    public void test01() throws IOException {
        //3、生产session
        SqlSession sqlSession = sessionFactory.openSession();
        //4、调用sqlSession中的接口查询数据
        //如何定位一条sql呢？通过namespace.id
        List<User> userLists = sqlSession.selectList("base.findAll");
        for (User user : userLists) {
            System.out.println(user.toString());
        }
    }
    /**
     * 根据id查询User对象
     * 参数：id
     * 返回值：User对象
     */
    @Test
    public void test02() throws IOException {
        //3、生产session
        SqlSession sqlSession = sessionFactory.openSession();
        /**
         * 4、调用sqlSession中的接口查询数据
         * 如何定位一条sql呢？通过namespace.id
         * 参数1：唯一定位一条sql
         * 参数2：根据id查询，id
         */
        User user = sqlSession.selectOne("base.findUserById", 10);
        System.out.println(user.toString());
    }
    /**
     * 模糊查询，查询姓张的用户
     * 参数：String 张
     * 返回值：List<User>
     */
    @Test
    public void test03(){
        //3、生产session
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> users = sqlSession.selectList("base.findUserByUsername", "张");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
    /**
     * 保存user
     * 参数：User对象
     * 返回值：主键(主要用于级联操作)
     */
    @Test
    public void test04(){
        //3、生产session
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setUsername("yeying");
        user.setBirthday(new Date());
        user.setSex("nan");
        user.setAddress("beijing");

        int insert = sqlSession.insert("base.insertUser", user);
        sqlSession.commit();

        System.out.println(insert + "/主键：" + user.getId());
    }
    /**
     * 根据id删除
     * 参数：id
     * 返回值：无
     */
    @Test
    public void test05(){
        //3、生产session
        SqlSession sqlSession = sessionFactory.openSession();
        int delete = sqlSession.delete("base.deleteUserById", 233);
        sqlSession.commit();
    }

    /**
     * 根据id更新用户
     * 参数：id
     * 返回值：无
     */
    @Test
    public void test06(){
        //3、生产session
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setId(231);
        user.setUsername("yeying");
        user.setBirthday(new Date());
        user.setSex("nan");
        user.setAddress("beijing+shanghai");

        sqlSession.update("base.updateUserById", user);
        sqlSession.commit();
    }
}
