package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import org.springframework.stereotype.Service;

/**
 * @author 李天峒
 * @date 2019/3/11 23:18
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
