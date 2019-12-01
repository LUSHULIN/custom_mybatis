package com.aia.mybatis.utils;

import com.aia.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于创建数据源的工具类
 */
public class DataSourceUtil {
    /**
     * 用户创建数据库连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg)  {
        try {
            Class.forName(cfg.getDriver());
           return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
