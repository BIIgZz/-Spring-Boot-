package com.zzh.sell.service;

import com.zzh.sell.dto.OrderDTO;

/**
 * @Author: zhuZHUzhu
 * @Description:支付
 * @Date: Created in 20:53 2020/3/28
 * @Modified By:
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
