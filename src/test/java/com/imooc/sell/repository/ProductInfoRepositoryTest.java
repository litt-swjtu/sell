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
        productInfo.setProductId("12345");
        productInfo.setProductName("特仑苏");
        productInfo.setProductPrice(new BigDecimal(6.5));
        productInfo.setProductStock(110);
        productInfo.setProductDescription("不是所有牛奶都叫特仑苏");
        productInfo.setProductIcon("https://paimgcdn.baidu.com/8F7476E9286F3452?src=http%3A%2F%2Fms.bdimg.com%2Fdsp-image%2F1863859364.jpg&rz=urar_2_968_600&v=0");
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