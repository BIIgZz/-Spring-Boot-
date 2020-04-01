package com.zzh.sell.controller;

import com.zzh.sell.dto.OrderDTO;
import com.zzh.sell.enums.ResultEnum;
import com.zzh.sell.exception.SellException;
import com.zzh.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 20:48 2020/3/28
 * @Modified By:
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public  void create(@RequestParam("orderId") String orderId,
                        @RequestParam("returnUrl") String returnUrl){
        //1.查询订单
       OrderDTO orderDTO= orderService.findOne(orderId);
        if (orderDTO ==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

    }

}
