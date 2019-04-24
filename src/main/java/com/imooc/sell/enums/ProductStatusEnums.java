package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnums {
    /*商品在架*/
    UP(0, "在架"),
    /*商品下架*/
    DOWN(1, "下架");

    private Integer code;

    private String meassge;

    ProductStatusEnums(Integer code, String meassge) {
        this.code = code;
        this.meassge = meassge;
    }
}
