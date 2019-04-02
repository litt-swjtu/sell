package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public interface BuyerService {
    /**
     * 查询单个订单
     */
    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
