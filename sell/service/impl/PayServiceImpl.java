package com.zzh.sell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.zzh.sell.dto.OrderDTO;
import com.zzh.sell.service.PayService;
import com.zzh.sell.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 20:54 2020/3/28
 * @Modified By:
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {
    private static  final String ORDER_NAME = "微信订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public void create(OrderDTO orderDTO) {


        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(Double.valueOf(orderDTO.getOrderAmount().toString()));
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(PayServiceImpl.ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】request={}", JsonUtil.toJson(payRequest));

       PayResponse payResponse =  bestPayService.pay(payRequest);
       log.info("【微信支付】 respone = {}",JsonUtil.toJson(payResponse));
    }
}
