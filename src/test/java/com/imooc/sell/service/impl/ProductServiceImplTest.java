package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("12345");
        Assert.assertEquals("12345", productInfo.getProductId());
        System.out.println(productInfo.getProductName());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
//        System.out.println(productInfoPage.getContent());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12351");
        productInfo.setProductName("荣耀10手机壳");
        productInfo.setProductPrice(new BigDecimal(35));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("荣耀10手机壳-大圣归来");
        productInfo.setProductIcon("http://img1.imgtn.bdimg.com/it/u=649351277,1446286628&fm=26&gp=0.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo productInfo1 = productService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }
}