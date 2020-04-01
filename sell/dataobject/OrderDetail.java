package com.zzh.sell.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 16:55 2020/3/9
 * @Modified By:
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单id*/
    @Column(name ="order_id" )
    private String orderId;

    /** 产品id*/
    @Column(name ="product_id" )
    private String productId;

    /** 产品名称*/
    @Column(name = "product_name" )
    private String productName;

    /** 产品价格*/
    @Column(name = "product_price" )
    private BigDecimal productPrice;


    /** 产品数量*/
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /** 小图 */
    @Column(name = "product_icon" )
    private String productIcon;

}
