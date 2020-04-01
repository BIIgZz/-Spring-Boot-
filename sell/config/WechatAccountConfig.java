package com.zzh.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 11:24 2020/3/25
 * @Modified By:
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /*
     * 商户号
     */
    private String mpAppId;

    //商户秘钥
    private String mpAppSecret;

    //商户证书路径
    private String mchId;

    private String mchkey;

    private String keyPath;

    private String notifyUrl;

}
