package com.adam_hel.service;

import com.adam_hel.pojo.User;

/**
 * ClassName:UserService
 * Package:com.adam_hel.service
 * Description:UserService接口
 *
 * @Date:2020/9/24 9:30
 * @Author:adam_hel@163.com
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);
    /**
     * 登录
     * @param user
     * @return 如果返回 null说明登录失败，返回有值是登录成功
     */
    public User login(User user);
    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回 true表示用户名已存在,返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
