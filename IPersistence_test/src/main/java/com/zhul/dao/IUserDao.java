package com.zhul.dao;

import com.zhul.pojo.User;

import java.util.List;

/**
 * @author juanwang
 * @create 2021/11/21 22:47
 */
public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws Exception;

    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;
}
