package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
/**数据库对象映射（dao层） 商品对象*/
public class ProductInfo {

    /**
     * 商品ID
     */
    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态，0正常1下架
     */
    private Integer productStatus;

    /**
     * 商品类目编号
     */
    private Integer categoryType;

}
