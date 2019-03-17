package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信账号配置
 * @author 李天峒
 * @date 2019/3/11 22:25
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    /**
    * 商户号
    * */
    private String mchId;
    /**
     * 商户密钥
     * */
    private String mchKey;
    /**
     * 商户证书路径
     * */
    private String keyPath;
    /**
     * 微信支付一步通知地址
     * */
    private String notiyfUrl;

}
