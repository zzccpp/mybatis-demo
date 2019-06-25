package cn.zcp.demo.mapper;

import cn.zcp.demo.bean.User;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-06-24 23:43
 * @describe mybatis-demo <描述>
 */
public interface PersonMapper {

    User findPersonById(int id) throws Exception;
}
