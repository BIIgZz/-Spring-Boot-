package com.zzh.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zzh.sell.dataobject.OrderDetail;
import com.zzh.sell.enums.OrderStatusEnum;
import com.zzh.sell.enums.PayStatusEnum;
import com.zzh.sell.utils.EnumUtil;
import com.zzh.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 20:02 2020/3/9
 * @Modified By:
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {


    @Column(name = "orderId")
    private String orderId;

    /** 买家名称 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家收货地址 */
    private String buyerAddress;

    /** openid */
    private  String buyerOpenid;

    /**订单总金额  */
    private BigDecimal orderAmount;

    /** 订单状态 默认0新下单 1完结 2已取消 */
    private Integer orderStatus;

    /** 支付状态 默认0未支付 1 已支付*/
    private Integer payStatus ;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList ;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return  EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
