package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.dao.UserDao;
import cn.zcp.demo.dao.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Hello world!
 *
 * 通过dao,来实现
 *
 */
public class AppTwo {
    public static void main( String[] args ) throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        UserDao userDao = new UserDaoImpl(sessionFactory);
        User user = userDao.findUserById(1);

        System.out.println(user);
    }
}
