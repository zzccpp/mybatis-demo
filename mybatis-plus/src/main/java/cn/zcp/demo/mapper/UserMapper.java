package cn.zcp.demo.mapper;

import cn.zcp.demo.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-06-26 16:33
 * @describe mybatis-demo <描述>
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
