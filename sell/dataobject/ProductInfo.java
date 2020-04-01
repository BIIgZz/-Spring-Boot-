package com.zzh.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class ProductInfo {

    @Id
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

    /**  状态0正常1下架*/
    private  Integer productStatus;

    /** 更新时间*/
    private Date updateTime;

    /** 创建时间*/
    private  Date createTime;
}
