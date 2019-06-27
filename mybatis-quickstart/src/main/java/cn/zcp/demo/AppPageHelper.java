package cn.zcp.demo;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-06-27 13:58
 * @describe mybatis-demo
 *
 * 使用插件PageHelper
 *
 */
public class AppPageHelper {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();
        //获取mybatis创建的mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //使用PageHelper分页
        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(2, 10);
        List<User> list = userMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);

        System.out.println("-------查询记录-------");
        page.getList().forEach(System.out::println);

        System.out.println("总条数："+page.getTotal()+",当前页："+page.getPageNum()+"/"+page.getPages()+",每页数量："+page.getPageSize()+",当前页数量："+page.getSize());
        System.out.println(page);

        /**
         * 4. 什么时候会导致不安全的分页？
         * PageHelper 方法使用了静态的 ThreadLocal 参数，分页参数和线程是绑定的。
         *
         * 只要你可以保证在 PageHelper 方法调用后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象。
         * 如果代码在进入 Executor 前发生异常，就会导致线程不可用，这属于人为的 Bug（例如接口方法和 XML 中的不匹配，导致找不到 MappedStatement 时）， 这种情况由于线程不可用，也不会导致 ThreadLocal 参数被错误的使用。
         */
    }
}
