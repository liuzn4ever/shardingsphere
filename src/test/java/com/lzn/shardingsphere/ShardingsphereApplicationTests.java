package com.lzn.shardingsphere;

import com.lzn.shardingsphere.model.Order;
import com.lzn.shardingsphere.model.OrderExample;
import com.lzn.shardingsphere.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Resource
    IOrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void TestInsertOrder(){
        Order order = new Order();
        order.setMemberId(126L);
        order.setCreateTime(new Date());
        order.setOrderSn("1000102");
        order.setStatus(1);
        orderService.createOrder(order);
    }


    @Test
    void TestListOrder(){
        OrderExample orderExample = new OrderExample();
        List<Order> orderList= orderService.listOrder(orderExample);
        for (Order o:orderList){
            System.out.println(o.toString());
        }

    }
    @Test
    void TestListOrder2(){
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andMemberIdEqualTo(123L);
        List<Order> orderList= orderService.listOrder(orderExample);
        for (Order o:orderList){
            System.out.println(o.toString());
        }

    }



}
