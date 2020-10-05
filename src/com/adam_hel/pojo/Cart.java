package com.adam_hel.pojo;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.*;

/**
 * ClassName:Cart
 * Package:com.adam_hel.pojo
 * Description:购物车对象
 *
 * @Date:2020/9/30 9:37
 * @Author:adam_hel@163.com
 */
public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;
    //key是商品编号,value是商品信息
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    //添加商品项
    public void addItem(CartItem cartItem) {
        // 先查看购物车中是否已经添加过此商品，如果已添加则数量累加总金额更新，如果没有添加过直接放到集合中
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
        //没添加过此商品
            items.put(cartItem.getId(), cartItem);
        } else {
        //已经添加过
            item.setCount( item.getCount() + 1 ); //数量累加
            item.setTotalPrice( item.getPrice().multiply(new BigDecimal( item.getCount() )) ); //更新总金额
        }
    }

    //删除商品项
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    // 清空购物车
    public void clear() {
        items.clear();
    }
    //修改商品数量
    public void updateCount(Integer id,Integer count) {
        // 先查看购物车中是否有此商品。如果有，修改商品数量更新总金额。
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);// 修改商品数量
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new
                    BigDecimal( cartItem.getCount() )) ); // 更新总金额
        }
    }




    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Cart() {
    }



    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" +getTotalPrice()+
                ", items=" + items +
                '}';
    }
}
