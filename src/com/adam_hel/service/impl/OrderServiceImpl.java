package com.adam_hel.service.impl;

import com.adam_hel.dao.BookDao;
import com.adam_hel.dao.OrderDao;
import com.adam_hel.dao.OrderItemDao;
import com.adam_hel.dao.impl.BookDaoImpl;
import com.adam_hel.dao.impl.OrderDaoImpl;
import com.adam_hel.dao.impl.OrderItemDaoImpl;
import com.adam_hel.pojo.*;
import com.adam_hel.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * ClassName:OrderServiceImpl
 * Package:com.adam_hel.service.impl
 * Description:
 *
 * @Date:2020/9/30 14:05
 * @Author:adam_hel@163.com
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        // 保存订单
        orderDao.saveOrder(order);

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount() );
            book.setStock( book.getStock() - cartItem.getCount() );
            bookDao.updateBook(book);

        }
        // 清空购物车
        cart.clear();

        return orderId;
    }
}
