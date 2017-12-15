package study.project.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.project.dao.UserMapper;
import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public class MybatisZhengHeSpring {
    /**
     * mybatis整合spring的第二种开发模式，接口代理开发开发
     */
    @Test
    public void test01(){
        //加载spring的配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");

        UserMapper userMapper = (UserMapper) app.getBean("userMapper");

        List<User> userAndOrders = userMapper.findUser();
        for (User user : userAndOrders) {
            System.out.println(user);
        }
    }
}
