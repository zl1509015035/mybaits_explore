package com.zhul.test;

import com.zhul.io.Resources;
import com.zhul.pojo.User;
import com.zhul.sqlSession.SqlSessFactory;
import com.zhul.sqlSession.SqlSession;
import com.zhul.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author juanwang
 * @create 2021/11/1 23:03
 */
public class IPersistenceTest {

    public void test() throws Exception{
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
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        User userResult = sqlSession.selectOne("user.selectOne", user);

    }
}
