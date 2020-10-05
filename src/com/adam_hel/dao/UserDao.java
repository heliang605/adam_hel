package com.adam_hel.dao;

import com.adam_hel.pojo.User;

/**
 * ClassName:UserDao
 * Package:com.adam_hel.dao.impl
 * Description:UserDaoImpl接口
 *
 * @Date:2020/9/23 21:07
 * @Author:adam_hel@163.com
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null,说明没有这个用户。
     */
    public User queryUserByUsername(String username);
    /**
     * 根据 用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null,说明用户名或密码错误.
     */
    public User queryUserByUsernameAndPassword(String username,String password);
    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败,其他是sql语句影响的行数
     */
    public int saveUser(User user);
}

