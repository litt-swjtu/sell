package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 李天峒
 * 订单和单件商品的转换类
 */
@Data
/*@JsonSerialize include = JsonSerialize.Inclusion.NON_NULL
@JsonInclude(JsonInclude.Include.NON_NULL)*/    /*非空的字段不返回  采用了配置文件的方法*/
public class OrderDTO {

    /**
     * 订单ID.
     */
    private String orderId;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信ID
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态（默认0新下单）
     */
    private Integer orderStatus;
    /**
     * 支付状态(默认0未支付)
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**
     * 订单对应的商品对象
     */
    List<OrderDetail> orderDetailList;

}
