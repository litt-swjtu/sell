package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("10000");
        productInfo.setProductName("香飘飘");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("销售量可绕地球两圈");
        productInfo.setProductIcon("https://img1.360buyimg.com/n6/jfs/t17908/186/1340081212/153109/b24c42e7/5ac354a7Naba6b1cd.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());

    }

}