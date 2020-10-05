package com.adam_hel.dao.impl;

import com.adam_hel.dao.OrderDao;
import com.adam_hel.pojo.Order;

/**
 * ClassName:OrderDaoImpl
 * Package:com.adam_hel.dao.impl
 * Description:
 *
 * @Date:2020/9/30 14:10
 * @Author:adam_hel@163.com
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
