package com.adam_hel.test;

import java.lang.reflect.Method;

/**
 * ClassName:UserServletTest
 * Package:com.adam_hel.test
 * Description:UserServlet测试类
 *
 * @Date:2020/9/25 14:23
 * @Author:adam_hel@163.com
 */
public class UserServletTest {
    public  void login(){
        System.out.println("login()方法被调用了");
    }

    public  void regist(){
        System.out.println("regist()方法被调用了");
    }

    public  void updateUser(){
        System.out.println("updateUser()方法被调用了");
    }

    public  void updateUserPassword(){
        System.out.println("updateUserPassword()方法被调用了");
    }

    public static void main(String[] args) {
        String action = "updateUserPassword";

        try {
            //获取action业务字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
