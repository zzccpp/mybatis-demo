package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Hello world!
 *
 * 直接通过原始加载mybatis配置来直接调用
 *
 */
public class AppOne {
    public static void main( String[] args ) throws Exception{
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
        //验证1级缓存
        user = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }
}
