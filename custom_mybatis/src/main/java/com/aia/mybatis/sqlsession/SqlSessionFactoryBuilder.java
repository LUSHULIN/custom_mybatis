package com.aia.mybatis.sqlsession;

import com.aia.mybatis.cfg.Configuration;
import com.aia.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.aia.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建sqlsession对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory builder(InputStream inputStream) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(cfg);
    }
  }
