package com.aia.mybatis.sqlsession.defaults;

import com.aia.mybatis.cfg.Configuration;
import com.aia.mybatis.sqlsession.SqlSession;
import com.aia.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的数据库操作对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultsSqlSession(cfg);
    }
}
