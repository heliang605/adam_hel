package com.adam_hel.web;

import com.adam_hel.pojo.Cart;
import com.adam_hel.pojo.User;
import com.adam_hel.service.OrderService;
import com.adam_hel.service.impl.OrderServiceImpl;
import com.adam_hel.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:OrderServlet
 * Package:com.adam_hel.web
 * Description:
 *
 * @Date:2020/9/30 14:01
 * @Author:adam_hel@163.com
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

   //生成订单
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userId = loginUser.getId();
        //调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, userId);

        //req.setAttribute("orderId", orderId);
        //请求转发到/pages/cart/checkout.jsp
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
