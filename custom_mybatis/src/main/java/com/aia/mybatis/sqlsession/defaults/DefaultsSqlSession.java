package com.aia.mybatis.sqlsession.defaults;

import com.aia.mybatis.cfg.Configuration;
import com.aia.mybatis.sqlsession.SqlSession;
import com.aia.mybatis.sqlsession.proxy.MapperProxy;
import com.aia.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口实现
 */
public class DefaultsSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultsSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao接口的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 释放资源
     */
    public void close()  {
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
