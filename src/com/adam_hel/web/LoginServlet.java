package com.adam_hel.web;

import com.adam_hel.pojo.User;
import com.adam_hel.service.UserService;
import com.adam_hel.service.impl.UserServiceImpl;
import com.sun.source.util.DocSourcePositions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:LoginServlet
 * Package:com.adam_hel.web
 * Description:
 *
 * @Date:2020/9/24 11:24
 * @Author:adam_hel@163.com
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录失败
        if (loginUser == null) {
            //把错误信息和回显的表单项信息保存到Request域中
            req.setAttribute("msg","用户或密码错误");
            req.setAttribute("username",username);
            // 跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 登录成功跳到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}
