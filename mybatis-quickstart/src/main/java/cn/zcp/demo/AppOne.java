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

        //源码分析：创建会话工厂,读取配置文件，映射文件，放入configuration类中，mapper文件中的sql存入mappedStatements<K,V>中，
        //Key为命名空间.id  及  id，会同时存储两份
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //源码分析：
        //1、通过工厂得到sqlSession对象(其中有创建一个executor,如果有设置启用二级缓存（默认启用）则使用CachingExecutor包装，)
        //2、查看是否有使用插件，如果有的话，循环插件对Executor生成代理对象,为了调用plug中intercept方法
        SqlSession sqlSession = sessionFactory.openSession();
        //通过sqlsession操作数据库
        /**
         *  1、第一个参数：映射文件中statement的id，等于namespace+"."+satement的id
         *  2、第二个参数：指定和映射文件中所匹配的paramenterType类型的对象
         */
        //源码分析：
        //1、通过statement的id来查找相应的SQL,判断是否启用二级缓存，没有的话进行查询是否存在一级缓存[PerpetualCache.cache(Map)]中是否有，没有的话就直接查询数据库
        User user = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user);
        //验证1级缓存
        user = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user);
        sqlSession.close();


        sqlSession = sessionFactory.openSession();
        //使用自定义TypeHandler
        sqlSession.insert("user.insertUser",user);
        //使用默认,会清空一级和二级缓存
        sqlSession.insert("user.insertUser1",user);

        //会清除一级缓存：clearLocalCache();
        sqlSession.commit();

    }
}
