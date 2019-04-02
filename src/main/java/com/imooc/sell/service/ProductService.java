package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 产品服务接口
 *
 * @author 李天峒
 * @date 2018-12
 */
@Component
public interface ProductService {

    /**
     * 查询一件商品
     *
     * @param productId 商品id
     * @return ProductInfo 商品详情
     */
    ProductInfo findOne(String productId);

    /**
     * 查询在架商品信息
     *
     * @return 返回在架商品信息
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品
     *
     * @param pageable 分页参数设置
     * @return 商品分页显示详情
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品信息
     *
     * @param productInfo 商品详细信息
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
