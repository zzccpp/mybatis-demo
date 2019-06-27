package cn.zcp.demo.mapper;

import cn.zcp.demo.bean.User;

import java.util.List;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-04 22:39
 * @describe mybatis-demo Mapper接口,相当于Dao接口
 *
 * 编写mapper接口需要遵循一些开发规范,mybatis可以自动生成mapper接口实现类的代理对象。
 *
 * 开发规范:
 * 1、在mapper.xml中namespace要等于mapper接口地址
 *
 * 2、mapper.java接口中方法名与xml中statement的id一致
 *
 * 3、mapper.java接口中方法输入参数与xml中statement的parameterType指定类型一致
 *
 * 4、mapper.java接口中方法输入参数与xml中statement的resultType指定类型一致
 *
 */
public interface UserMapper {

    /**
     * 根据ID查询一个用户
     * @param id
     * @return
     * @throws Exception
     */
    User findUserById(int id) throws Exception;

    /**
     * 添加一个用户
     * @param user
     * @throws Exception
     */
    void insertUser(User user) throws Exception;

    /**
     * 根据Id删除一个用户
     * @param id
     * @throws Exception
     */
    void deleteUserById(int id) throws Exception;

    /**
     * 更新用户
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;


    /**
     * 按分页查找
     * @return
     * @throws Exception
     */
    List<User> selectAll() throws Exception;


}
