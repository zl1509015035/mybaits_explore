package com.zhul.dao;

import com.zhul.io.Resources;
import com.zhul.pojo.User;
import com.zhul.sqlSession.SqlSessFactory;
import com.zhul.sqlSession.SqlSession;
import com.zhul.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author juanwang
 * @create 2021/11/21 22:49
 */
public class IUserDaoImpl implements IUserDao {
    @Override
    public List<User> findAll() throws Exception {
        //获取文件输入流
        InputStream resourceAsStream =
                Resources.getResourceAsStream("sqlMapConfig.xml");
        /**
         * dom4j解析 sqlMapper和每一个mapper
         * 构造Configuration(DataSource和mapperMap)
         * 创建SqlSessionFactory接口及实现类DefaultSqlSessionFactory
         * openSession():生产sqlSession
         */
        SqlSessFactory sqlSessFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessFactory.openSession();

        //调用
        List<User> list = sqlSession.selectList("user.selectList");
        list.forEach(System.out::println);
        return list;
    }

    @Override
    public User findByCondition(User user) throws Exception {
        //获取文件输入流
        InputStream resourceAsStream =
                Resources.getResourceAsStream("sqlMapConfig.xml");
        /**
         * dom4j解析 sqlMapper和每一个mapper
         * 构造Configuration(DataSource和mapperMap)
         * 创建SqlSessionFactory接口及实现类DefaultSqlSessionFactory
         * openSession():生产sqlSession
         */
        SqlSessFactory sqlSessFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessFactory.openSession();
        //调用
        User userResult = sqlSession.selectOne("user.selectOne", user);
        return userResult;
    }
}
