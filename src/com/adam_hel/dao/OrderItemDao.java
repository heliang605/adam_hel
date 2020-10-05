package com.adam_hel.dao;

import com.adam_hel.pojo.OrderItem;

/**
 * ClassName:OrderItemDao
 * Package:com.adam_hel.dao
 * Description:
 *
 * @Date:2020/9/30 14:09
 * @Author:adam_hel@163.com
 */
public interface OrderItemDao {
    //保存订单项
    public int saveOrderItem(OrderItem orderItem);
   /* //根据订单号查询订单信息
    public Integer queryOrderItemsByOrderId(orderId);*/
}
