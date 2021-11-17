package com.zhul.sqlSession;

import com.zhul.pojo.BoundSql;
import com.zhul.pojo.Configuration;
import com.zhul.pojo.MappedStatement;
import com.zhul.utils.GenericTokenParser;
import com.zhul.utils.ParameterMapping;
import com.zhul.utils.ParameterMappingTokenHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author zhul
 * @create 2021/11/17 15:50
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {
        //1.注册驱动，获取连接
        Connection connection = configuration.getDataSource().getConnection();

        //2.获取sql语句 select * from user where id = #{id} and username = #{username}
        //  转换sql语句 select * from user where id = ?  and username = ?,转换过程中，还需要对#{}里面的值进行解析存储
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);

        //3.获取预处理对象：preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());

        //4.设置参数
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            ParameterMapping parameterMapping = parameterMappingList.get(0);
            String content = parameterMapping.getContent();

            //反射

        }

        //5.执行sql

        //6.封装返回结果集
        return null;
    }

    /**
     * 完成对#{}的解析工作:1、将{}使用?进行代替 2、解析出#{}里面的值进行存储
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类：配合标记解析器对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        //解析出来的sql
        String parseSql = genericTokenParser.parse(sql);
        //#{}里面解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);

        return boundSql;
    }
}
