package com.adam_hel.dao.impl;

import com.adam_hel.dao.UserDao;
import com.adam_hel.pojo.User;

/**
 * ClassName:UserDaoImpl
 * Package:com.adam_hel.dao.impl
 * Description:UserDaoImpl实现类
 *
 * @Date:2020/9/23 21:16
 * @Author:adam_hel@163.com
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
    }
}
