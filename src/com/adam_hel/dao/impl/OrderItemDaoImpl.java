package com.adam_hel.dao.impl;

import com.adam_hel.dao.OrderItemDao;
import com.adam_hel.pojo.OrderItem;

/**
 * ClassName:OrderItemDaoImpl
 * Package:com.adam_hel.dao.impl
 * Description:
 *
 * @Date:2020/9/30 14:10
 * @Author:adam_hel@163.com
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
