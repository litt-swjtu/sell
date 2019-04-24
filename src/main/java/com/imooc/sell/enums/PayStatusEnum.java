package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    /**支付状态*/
    WAIT(0, "未支付"),
    SUCCESS(1, "支付完成");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
