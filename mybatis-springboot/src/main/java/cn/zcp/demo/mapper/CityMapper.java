package cn.zcp.demo.mapper;

import cn.zcp.demo.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-19 11:11
 * @describe mybatis-demo <描述>
 */
@Mapper
public interface CityMapper {

    @Select("SELECT * FROM CITY WHERE state = #{state}")
    City findByState(@Param("state") String state);
}
