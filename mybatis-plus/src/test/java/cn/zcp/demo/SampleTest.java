package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-06-26 16:34
 * @describe mybatis-demo <描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        //userList.forEach(System.out::println);

        userList.forEach(T->System.out.println(T));//类似(T)->{System.out.println(T))

        //userList.forEach(System.out::println);

        /**
         * 解析上面语句
         * * “函数式接口 变量名 = 类实例::方法名” 的方式对该方法进行引用
         * 1、通过::可以调用某一个方法，根据这个方法是否有参数而返回对应的函数式接口对象(可自定义)
         *
         * 总结：通俗理解,用System.out::println方法的实现来代表Consumer接口中accept方法的实现
         */
        //以下两个赋值雷同
        Consumer<String> doA = new SampleTest()::doA;
        Consumer<String> doAA = (T)-> System.out.println(T);

        Runnable testSelect = new SampleTest()::testSelect;
        testSelect = ()-> System.out.println();

        BiConsumer<String, Integer> stringIntegerBiConsumer = new SampleTest()::doA;
        //new SampleTest()::doB; //jdk为定义接收三个参数的函数接口，需要自己定义
    }

    private void doA(String a){

    }
    private void doA(String a,int b){

    }
    private void doB(String a,int b,String c){

    }
}