package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李天峒
 */
@Component
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /**
     * fetch order detail by order id
     *
     * @param orderId order id
     * @return List<OrderDetail>
     */
    List<OrderDetail> findByOrderId(String orderId);
}
