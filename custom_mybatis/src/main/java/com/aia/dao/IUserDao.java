package com.aia.dao;

import com.aia.domain.User;
import com.aia.mybatis.annotations.Select;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return list
     */
    @Select("select * from user")
    List<User> findAll();
}
