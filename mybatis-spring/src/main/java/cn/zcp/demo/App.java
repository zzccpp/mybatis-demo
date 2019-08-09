package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.dao.UserDao;
import cn.zcp.demo.mapper.User1Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 官网地址：http://www.mybatis.org/spring/
 *
 * 源码分析:
 *  1、通过bean标签
 *  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
 *         <property name="dataSource" ref="dataSource"/>
 *  </bean>
 *  初始化一个SqlSessionFactoryBean,创建对象getObject()中初始化了一个buildSqlSessionFactory[this.sqlSessionFactoryBuilder.build(targetConfiguration);],但里面的Configuration对象为参数未默认值,看是否配置了
 *
 *  2、通过bean标签
 *  <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
 *         <property name="basePackage" value="cn.zcp.demo"/>
 *         <property name="sqlSessionFactoryBeanName"  value="sqlSessionFactory"/>
 *  </bean>
 *  调用MapperScannerConfigurer中postProcessBeanDefinitionRegistry[扫描指定包,并且对包下的所有接口,创建一个beanDefinitions],
 *  且处理【ClassPathMapperScanner继承ClassPathBeanDefinitionScanner,
 *  覆盖doScan方法】，doScan中调用processBeanDefinitions(beanDefinitions);
 *  方法把beanDefinitions中className设置为MapperFactoryBean(实现FactoryBean)类型
 *
 *  MapperFactoryBean继承SqlSessionDaoSupport继承DaoSupport实现InitializingBean
 *  在初始化bean后，会调用checkDaoConfig方法，
 *  会执行configuration.addMapper(this.mapperInterface);往configuration中添加Mapper接口信息及mapper对应的xml文件
 *
 *
 *  3、获取具体Mapper对象的时候，当执行User1Mapper userMapper = (User1Mapper) ac.getBean("user1Mapper");时,Spring去getBean的时候
 *  会调用MapperFactoryBean中的getObject()方法，执行getSqlSession().getMapper(this.mapperInterface);方法创建Mapper代理对象
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {


        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/application.xml");

        //1、使用注解SQL
        /*UserDao userDao = (UserDao) ac.getBean("userDao");
        User user = userDao.getUser(1);
        System.out.println("使用注解:"+user);*/

        //2、使用xml配置SQL、需要知道xml地址
        /*SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        user = sqlSessionFactory.openSession().selectOne("user.findUserById", 1);
        System.out.println("使用xml:"+user);*/

        String[] beans = ac.getBeanDefinitionNames();
        for(String name :beans)
            System.out.println(name);

        User1Mapper userMapper = (User1Mapper) ac.getBean("user1Mapper");
        User user = userMapper.findUserById(1);
        //第二次直接从缓存中拿对象
        //userMapper = (User1Mapper) ac.getBean("user1Mapper");
        System.out.println("使用Mapper:"+user);


    }
}
