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
 * 源码分析:在创建sessionFactory的时候，处理mapper标签下的配置时，会去扫描定义包下的所有 接口,放入knownMappers(MAP)中,Key为Class
 *   并且会扫描同目录下的xml文件，org.apache.ibatis.builder.annotation.MapperAnnotationBuilder#loadXmlResource()，放入
 *   configuration中的StatementMap中.
 *
 *   sessionFactory.openSession();
 *   源码分析：
 *  1、通过工厂得到sqlSession对象(其中有创建一个executor,如果有设置启用二级缓存（默认启用）则使用CachingExecutor包装，)
 *  2、查看是否有使用插件，如果有的话，循环插件对Executor生成代理对象,为了调用plug中intercept方法
 *
 *   sqlSession.getMapper(UserMapper.class);
 *   1、创建Mapper代理对象
 *
 *   userMapper.findUserById(1);
 *   1、执行代理对象方法
 *   org.apache.ibatis.binding.MapperProxy#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
 *
 *   判断如果是object的方法是，执行执行，如果是Mapper接口中定义的方法时，
 *   org.apache.ibatis.binding.MapperMethod.SqlCommand#resolveMappedStatement()
 *   则使用mapperInterface.getName() + "." + methodName; 去Configuration中mappedStatements中去查找相应的SQL
 *
 *
 *
 *
 */
public class AppMapper {
    public static void main( String[] args ) throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();
        //源码：获取mybatis创建的mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        /*//只要定义包下的所有接口，都会去生成代理对象
        UserDao UserDao = sqlSession.getMapper(UserDao.class);
        System.out.println("对象:"+UserDao);*/

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
