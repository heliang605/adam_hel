package com.adam_hel.dao;

import com.adam_hel.pojo.Order;
import com.adam_hel.pojo.User;

/**
 * ClassName:OrderDao
 * Package:com.adam_hel.dao
 * Description:
 *
 * @Date:2020/9/30 14:08
 * @Author:adam_hel@163.com
 */
public interface OrderDao {


    //保存订单
    public int saveOrder(Order order);
   /* //查询全部订单
    public int queryOrder();
    //修改订单状态
    public Order changeOrderStatus(orderId, status);
    //根据用户编号查询订单信息
    public Integer queryOrderByUserId(userId);*/

}
