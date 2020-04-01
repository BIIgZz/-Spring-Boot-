package com.zzh.sell.dto;

import lombok.Data;

/**
 * @Author: zhuZHUzhu
 * @Description:购物车
 * @Date: Created in 20:43 2020/3/9
 * @Modified By:
 */
@Data
public class CartDTO {
    /**商品id*/
    private String productId;

    /*数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
