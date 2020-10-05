package com.adam_hel.test;

import com.adam_hel.dao.OrderDao;
import com.adam_hel.dao.impl.OrderDaoImpl;
import com.adam_hel.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * ClassName:OrderDaoTest
 * Package:com.adam_hel.test
 * Description:
 *
 * @Date:2020/9/30 15:07
 * @Author:adam_hel@163.com
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567892",new Date(),new BigDecimal(100),0, 1));
    }
}