package com.imooc.sell.repository;
import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    /*查询测试*/
    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    /*新增测试*/
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNull(result);               /*添加断言*/
//        Assert.assertNotEquals(null,result);
    }

    /*修改测试*/
    @Test
    public void updataTest(){
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryType(1);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn(){

        List<Integer> list = Arrays.asList(1,2);

        System.out.println(list);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }

}
