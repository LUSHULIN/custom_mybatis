package com.aia.mybatis.sqlsession;

import java.sql.SQLException;

/**
 * 自定义mybatis中和数据库交互的核心类
 * 里面可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao接口的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close() throws SQLException;
}
