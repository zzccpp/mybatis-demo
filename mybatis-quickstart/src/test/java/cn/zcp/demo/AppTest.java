package cn.zcp.demo;

import static org.junit.Assert.assertTrue;

import cn.zcp.demo.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void findUserById() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        //通过sqlsession操作数据库
        /**
         *  1、第一个参数：映射文件中statement的id，等于namespace+"."+satement的id
         *  2、第二个参数：指定和映射文件中所匹配的paramenterType类型的对象
         */
        User user = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user);

        sqlSession.close();

    }
    @Test
    public void findUserByName() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        //通过sqlsession操作数据库
        /**
         *  1、第一个参数：映射文件中statement的id，等于namespace+"."+satement的id
         *  2、第二个参数：指定和映射文件中所匹配的paramenterType类型的对象
         */
        User user = sqlSession.selectOne("user.findUserByName", "cc");
        System.out.println(user);

        sqlSession.close();

    }
    @Test
    public void insertUser() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        //通过sqlsession操作数据库
        /**
         *  1、第一个参数：映射文件中statement的id，等于namespace+"."+satement的id
         *  2、第二个参数：指定和映射文件中所匹配的paramenterType类型的对象
         */
        User user = new User();
        user.setName("cccc");
        user.setAge(12);
        sqlSession.insert("user.insertUser", user);

        sqlSession.commit();
        sqlSession.close();

    }

}
