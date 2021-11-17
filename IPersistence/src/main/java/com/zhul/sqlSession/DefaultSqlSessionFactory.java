package com.zhul.sqlSession;

import com.zhul.pojo.Configuration;

/**
 * @author juanwang
 * @create 2021/11/15 22:10
 */
public class DefaultSqlSessionFactory implements SqlSessFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
