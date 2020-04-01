package com.zzh.sell.dataobject;

import com.zzh.sell.enums.OrderStatusEnum;
import com.zzh.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zhuZHUzhu
 * @Description:订单实体
 * @Date: Created in 16:07 2020/3/9
 * @Modified By:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {


    @Id
    private String orderId;

    /** 买家名称 */
    @Column(name="buyer_name")
    private String buyerName;

    /** 买家电话 */
    @Column(name="buyer_phone")
    private String buyerPhone;

    /** 买家收货地址 */
    @Column(name="buyer_address")
    private String buyerAddress;

    /** openid */
    @Column(name="buyer_openid")
    private  String buyerOpenid;

    /**订单总金额  */
    @Column(name="order_amount")
    private BigDecimal orderAmount;

    /** 订单状态 默认0新下单 1完结 2已取消 */
    @Column(name = "order_status")
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /** 支付状态 默认0未支付 1 已支付*/
    @Column(name = "pay_status")
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    @Column(name = "create_time")
    private Date createTime;

    /** 更新时间 */
    @Column(name = "update_time")
    private Date updateTime;

}
