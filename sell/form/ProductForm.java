package com.zzh.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 14:15 2020/4/20
 * @Modified By:
 */
@Data
public class ProductForm {

    private String productId;

    /** 名字。 */
    private String productName;

    /** 单价。 */
    private BigDecimal productPrice;

    /** 库存 。*/
    private Integer productStock;

    /** 商品描述*/
    private String productDescription;

    /** 图片*/
    private String productIcon;

    /** 小图*/
    private  Integer categoryType;
}
