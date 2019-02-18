package com.imooc.sell.dataobject;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
/**数据库对象映射（dao层） 商品对象*/
public class ProductInfo {

    /**商品ID*/
    @Id
    private String productId;

    /**商品名称*/
    private String productName;

    /**商品价格*/
    private BigDecimal productPrice;

    /**商品库存*/
    private Integer productStock;

    /**商品描述*/
    private String productDescription;

    /**小图*/
    private String productIcon;

    /**商品状态，0正常1下架*/
    private Integer productStatus;

    /**商品类目编号*/
    private Integer categoryType;


    /*********
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductInfo{");
        sb.append("productId='").append(productId).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productStock=").append(productStock);
        sb.append(", productDescription='").append(productDescription).append('\'');
        sb.append(", productIcon='").append(productIcon).append('\'');
        sb.append(", productStatus=").append(productStatus);
        sb.append(", categoryType=").append(categoryType);
        sb.append('}');
        return sb.toString();
    }
    ***********/
}
