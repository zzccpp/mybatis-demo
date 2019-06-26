package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.dao.UserDao;
import cn.zcp.demo.dao.impl.UserDaoImpl;
import cn.zcp.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Hello world!
 *
 * 通过Mapper代理对象来实现
 *
 */
public class AppMapper {
    public static void main( String[] args ) throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();
        //获取mybatis创建的mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);
        //sqlSession.commit(); 关闭缓存,或者update,delete,insert的时候就会清除
        //验证1级缓存
        user = userMapper.findUserById(1);
        System.out.println(user);

        //测试自定义插件MyPlugin
        user.setName("userUP");
        userMapper.updateUser(user);

    }
}
