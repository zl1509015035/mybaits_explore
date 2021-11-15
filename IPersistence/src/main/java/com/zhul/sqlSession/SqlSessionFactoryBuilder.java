package com.zhul.sqlSession;

import com.zhul.config.XMLConfigBuilder.XMLConfigBuilder;
import com.zhul.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author juanwang
 * @create 2021/11/15 21:25
 */
public class SqlSessionFactoryBuilder {

    public SqlSessFactory build(InputStream in) throws DocumentException, PropertyVetoException {
        //第一：使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);
        //第二：创建sqlSessionFactory对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }
}
