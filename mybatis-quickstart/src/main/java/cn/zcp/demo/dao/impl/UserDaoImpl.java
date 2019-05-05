package cn.zcp.demo.dao.impl;

import cn.zcp.demo.bean.User;
import cn.zcp.demo.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-05 21:21
 * @describe mybatis-demo <描述>
 */
public class UserDaoImpl implements UserDao {

    //需要向dao实现类中注入SqlSessionFactory
    //这里通过够着方法
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("user.findUserById",id);
    }

    @Override
    public void insertUser(User user) throws Exception {

    }

    @Override
    public void deleteUser(int id) throws Exception {

    }
}
