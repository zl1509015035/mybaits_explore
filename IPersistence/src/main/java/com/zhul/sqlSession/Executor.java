package com.zhul.sqlSession;

import com.zhul.pojo.Configuration;
import com.zhul.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhul
 * @create 2021/11/17 15:48
 */
public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws  Exception;
}
