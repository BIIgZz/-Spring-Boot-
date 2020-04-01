package com.zzh.sell.service;

import com.zzh.sell.dataobject.OrderMaster;
import com.zzh.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 19:56 2020/3/9
 * @Modified By:
 */
public interface OrderService {

    /**创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /**查询单个订单*/
    OrderDTO findOne(String orderId);

    /**查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**查询所有订单列表*/
    Page<OrderDTO> findList( Pageable pageable);



    /**取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

}
