package study.project.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.project.dao.IUserDao;
import study.project.dao.impl.UserDaoImpl;
import study.project.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
     * 普通dao开发
     */
    @Test
    public void puTongDao(){
        IUserDao userDao = new UserDaoImpl(sessionFactory);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("-----------------------------------");
        User user = userDao.findUserById(231);
        System.out.println(user);
    }
}
