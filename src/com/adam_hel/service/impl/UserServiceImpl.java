package com.adam_hel.service.impl;

import com.adam_hel.dao.UserDao;
import com.adam_hel.dao.impl.UserDaoImpl;
import com.adam_hel.pojo.User;
import com.adam_hel.service.UserService;

/**
 * ClassName:UserServiceImpl
 * Package:com.adam_hel.service.impl
 * Description:Service层
 * Service接口实现类
 * UserServiceImpl实现类
 * @Date:2020/9/24 9:37
 * @Author:adam_hel@163.com
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);


    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
       if (userDao.queryUserByUsername(username) == null){
           //等于null说明没查到，表示可用
           return false;
       }
       return true;
    }
}
