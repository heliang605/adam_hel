package com.adam_hel.test;

import com.adam_hel.dao.UserDao;
import com.adam_hel.dao.impl.UserDaoImpl;
import com.adam_hel.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName:UserDaoTest
 * Package:com.adam_hel.test
 * Description:UserDao测试类
 *
 * @Date:2020/9/23 21:23
 * @Author:adam_hel@163.com
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {


        if (userDao.queryUserByUsername("admin") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","admin") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"hehehe","123456","admin111@163.com")));
    }
}