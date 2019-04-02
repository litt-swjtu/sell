package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnums {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String meassge;

    ProductStatusEnums(Integer code, String meassge) {
        this.code = code;
        this.meassge = meassge;
    }
}
