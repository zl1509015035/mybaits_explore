package com.zhul.io;

import java.io.InputStream;

/**
 * @author juanwang
 * @create 2021/11/1 23:01
 */
public class Resources {
    //根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourceAsStream(String path){
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
