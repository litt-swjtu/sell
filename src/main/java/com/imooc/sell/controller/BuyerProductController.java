package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultUtilsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.com.BeanClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李天峒
 * 买家商品
* */
@RestController                       //返回Json格式
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO List(){

        //1、查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //保存所有的上架上架商品信息

        //2、查询类目（一次性查询）
        //传统方法（一个一个循环遍历赋值）
        /*List<Integer> categoryTypeList = new ArrayList<>();
        for(ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        /*精简方法(lombda表达式) */
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){
            //定义一个类目下属的结构对象（productVO）
            ProductVO productVO = new ProductVO();
            //赋值类目类型编号
            productVO.setCategoryType(productCategory.getCategoryType());
            //赋值类目类型名称
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    //定义一个商品下属的结构对象（ProductInfoVO）
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    /*普通方式
                    productInfoVO.setProductName(productInfo.getProductName());                  //赋值商品名称
                    productInfoVO.setProductPrice(productInfo.getProductPrice());                //赋值商品价格
                    productInfoVO.setProductDescription(productInfo.getProductDescription());    //赋值商品描述
                    productInfoVO.setProductIcon(productInfo.getProductIcon());                  //赋值商品图片
                    */

                    //特殊方式  Java8语法
                    //一次性直接赋值
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    //将商品信息添加到list中保存
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            //将类目信息添加到list中保存
            productVOList.add(productVO);
        }
        return ResultUtilsVO.success(productVOList);
    }
}
