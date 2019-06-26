package cn.zcp.demo.typehandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-06-26 11:30
 * @describe mybatis-demo
 *
 * 自定义(String)类型处理器
 *
 * 使用步骤：
 * 1、定义完成,编写继承BaseTypeHandler接口
 * 2、添加至mybatis-config.xml配置中
 * 3、SQL中指定values(#{name,typeHandler=cn.zcp.demo.typehandle.MyTypeHandle},#{age})
 *
 */
public class MyTypeHandle extends BaseTypeHandler<String>{

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

        //设置参数为默认加上ZcpTypeHandler后缀
        preparedStatement.setString(i,s+"ZcpTypeHandler");
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
