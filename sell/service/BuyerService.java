package com.zzh.sell.service;

import com.zzh.sell.dto.OrderDTO;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 19:34 2020/3/16
 * @Modified By:
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancel(String openid,String orderId);

}
