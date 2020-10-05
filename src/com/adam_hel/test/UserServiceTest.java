package com.adam_hel.test;

import com.adam_hel.pojo.User;
import com.adam_hel.service.UserService;
import com.adam_hel.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName:UserServiceTest
 * Package:com.adam_hel.test
 * Description:UserService测试类
 *
 * @Date:2020/9/24 9:52
 * @Author:adam_hel@163.com
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"hehehehe","123456","hehehehe@163.com"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "hehe", "123456", null)) );
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("hehe")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }

    }

}