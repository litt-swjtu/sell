package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "123456";

    @Test
    public void savaTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("李天峒");
        orderMaster.setBuyerPhone("12212222323");
        orderMaster.setBuyerAddress("庄浪县");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(12));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {
        OrderMaster orderMaster = repository.findById("123456").get();
        orderMaster.setBuyerAddress("西安市");
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void selectTest() {
        OrderMaster orderMaster = repository.findById("123456").get();
        System.out.println(orderMaster.getBuyerName() + orderMaster.getBuyerPhone());
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(result.getTotalElements(), 0);
        System.out.println(result.getTotalElements());
    }
}