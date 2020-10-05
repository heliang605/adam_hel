package com.adam_hel.test;

import com.adam_hel.pojo.Cart;
import com.adam_hel.pojo.CartItem;
import com.adam_hel.service.OrderService;
import com.adam_hel.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName:OrderServiceTest
 * Package:com.adam_hel.test
 * Description:
 *
 * @Date:2020/9/30 16:03
 * @Author:adam_hel@163.com
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println( "订单号是：" + orderService.createOrder(cart, 1) );
    }
}