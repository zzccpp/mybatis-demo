package cn.zcp.demo.dao;

import cn.zcp.demo.bean.User;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-05 21:18
 * @describe mybatis-demo <描述>
 */
public interface UserDao {

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
    void deleteUser(int id) throws Exception;

}
