package study.project.dao;

import study.project.domain.User;

import java.util.List;

/**
 * Created by canglang on 2017/12/10.
 */
public interface IUserDao {
    /**
     * 接口代理开发需要满足的开发规范：
     * 1、mapper.xml的namespace必须是接口的全类路径名
     * 2、mapper.xml中使用的标签的id（Mappedstatement的id）必须和接口的的方法名相同
     * 3、mapper.xml的parameterType必须和接口参数类型一致
     * 4、mapper.xml的resultType必须和接口的返回值类型一致
     * 5、mybatis整合spring后 mapper.xml的命名规则是名字必须和接口的名字相同，并且要再同一个目录下
     */
    //查询所有
    List<User> findAll();

    //根据idea查询user
    User findUserById(Integer id);
}
