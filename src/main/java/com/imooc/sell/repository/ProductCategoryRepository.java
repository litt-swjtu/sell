package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author 李天峒
 */
@Component
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * fetch product Category by categoryTypeList
     *
     * @param categoryTypeList
     * @return List<ProductCategory> 返回商品的类目
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
