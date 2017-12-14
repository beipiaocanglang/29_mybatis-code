package study.project.dao;

import study.project.domain.QueryVo;
import study.project.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by canglang on 2017/12/10.
 */
public interface UserMapper {
    /**
     * 接口代理开发需要满足的开发规范：
     * 1、mapper.xml的namespace必须是接口的全类路径名
     * 2、mapper.xml中使用的标签的id（Mappedstatement的id）必须和接口的的方法名相同
     * 3、mapper.xml的parameterType必须和接口参数类型一致
     * 4、mapper.xml的resultType必须和接口的返回值类型一致
     * 5、mybatis整合spring后 mapper.xml的命名规则是名字必须和接口的名字相同，并且要再同一个目录下
     */
    /**
     * 查询性别为nan的姓张的用户
     * 传递的是包装类对象
     */
    List<User> findUserList(QueryVo vo);

    /**
     * 查询id=10, or id=230, or id=231的用户
     */
    List<User> findUserByOR(QueryVo vo);

    /**
     * 查询id in(10,230,231)的用户
     */
    List<User> findUserByIN(QueryVo vo);
}
