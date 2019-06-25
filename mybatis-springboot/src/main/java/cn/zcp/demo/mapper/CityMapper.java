package cn.zcp.demo.mapper;

import cn.zcp.demo.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-19 11:11
 * @describe mybatis-demo <描述>
 */
@Mapper //把CityMapper放入Spring管理
public interface CityMapper {

    @Select("SELECT * FROM t_city WHERE state = #{state}")
    List<City> findByState(@Param("state") String state);

    City findCityById(int id);

    //void findCityById(String name,int x);

    //void insertCity(City city);
}
