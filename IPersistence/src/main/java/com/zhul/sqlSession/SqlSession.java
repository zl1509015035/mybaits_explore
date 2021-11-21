package com.zhul.sqlSession;

import java.util.List;

/**
 * @author juanwang
 * @create 2021/11/15 22:31
 */
public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementid,Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementid,Object... params) throws Exception;
}
