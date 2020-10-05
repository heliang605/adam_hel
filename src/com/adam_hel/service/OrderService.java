package com.adam_hel.service;

import com.adam_hel.pojo.Cart;

/**
 * ClassName:OrderService
 * Package:com.adam_hel.service
 * Description:
 *
 * @Date:2020/9/30 14:08
 * @Author:adam_hel@163.com
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
