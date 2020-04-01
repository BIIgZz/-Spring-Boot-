package com.zzh.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 11:37 2020/3/16
 * @Modified By:
 */
@Data
public class OrderForm {
    /*
     * @Desc :买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /*
     * @Desc :手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /*
     * @Desc :买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /*
     * @Desc: 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /*
     * @Desc:购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}