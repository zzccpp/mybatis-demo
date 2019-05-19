package cn.zcp.demo.dao;

import cn.zcp.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-18 18:32
 * @describe mybatis-demo <描述>
 */
public interface UserDao {

    @Select("select * from t_user where id = #{id}")
    User getUser(@Param("id") int id);


    User findUserById(int id);

}
