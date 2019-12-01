package com.aia.test;

import com.aia.dao.IUserDao;
import com.aia.domain.User;
import com.aia.mybatis.io.Resources;
import com.aia.mybatis.sqlsession.SqlSession;
import com.aia.mybatis.sqlsession.SqlSessionFactory;
import com.aia.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.builder(in);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> list = userDao.findAll();
        for (User u:list) {
            System.out.println(u);
        }

    }
}
