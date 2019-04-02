package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李天峒
 * 类目
 */
@Component
public interface CategoryService {

    /**
     * fetch one category
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 展示多条记录
     */
    List<ProductCategory> findAll();

    /**
     * 按照类型展示多条记录
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 新增记录
     */
    ProductCategory save(ProductCategory productCategory);
}
