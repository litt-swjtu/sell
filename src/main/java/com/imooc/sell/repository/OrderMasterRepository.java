package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author 李天峒
 */
@Component
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * fetch Order Master by openid
     *
     * @param buyerOpenid 买家的微信号码
     * @param pageable    页码
     * @return Page<OrderMaster></>
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
