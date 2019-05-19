package cn.zcp.demo.mapper;

import cn.zcp.demo.model.TCity;
import cn.zcp.demo.model.TCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCityMapper {
    long countByExample(TCityExample example);

    int deleteByExample(TCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCity record);

    int insertSelective(TCity record);

    List<TCity> selectByExample(TCityExample example);

    TCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCity record, @Param("example") TCityExample example);

    int updateByExample(@Param("record") TCity record, @Param("example") TCityExample example);

    int updateByPrimaryKeySelective(TCity record);

    int updateByPrimaryKey(TCity record);
}