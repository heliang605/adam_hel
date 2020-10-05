package com.adam_hel.test;

import com.adam_hel.dao.OrderItemDao;
import com.adam_hel.dao.impl.OrderItemDaoImpl;
import com.adam_hel.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName:OrderItemDaoTest
 * Package:com.adam_hel.test
 * Description:
 *
 * @Date:2020/9/30 15:09
 * @Author:adam_hel@163.com
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java 从入门到精通", 1,new BigDecimal(100),new BigDecimal(100),"1234567891"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript 从入门到精通", 2,new BigDecimal(100),new BigDecimal(200),"1234567891"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Netty 入门", 1,new BigDecimal(100),new BigDecimal(100),"1234567891"));
    }
}