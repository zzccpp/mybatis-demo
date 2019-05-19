package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.dao.UserDao;
import cn.zcp.demo.mapper.User1Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 官网地址：http://www.mybatis.org/spring/
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
        System.out.println("使用Mapper:"+user);


    }
}
