package com.zzh.sell.controller;

import com.zzh.sell.dto.OrderDTO;
import com.zzh.sell.enums.ResultEnum;
import com.zzh.sell.exception.SellException;
import com.zzh.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: zhuZHUzhu
 * @Description:卖家端订单
 * @Date: Created in 17:03 2020/3/17
 * @Modified By:
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * @Description:订单列表
     * @param: page 第几页，从第一条开始
     * @param size 一页有多少条数据
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/list")
    public ModelAndView List(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest request = PageRequest.of(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);

        return  new ModelAndView("order/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId")String orderId,
                               Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e){

                log.error("【卖家端订单取消】 发生异常{}",e);

                map.put("msg",e.getMessage());
                map.put("url","/sell/seller/order/list");
                return new ModelAndView("common/error",map);
            }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
        }
    /*
     * @Description:订单详情
     * @param: [orderId, map]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e){

            log.error("【卖家端订单详情】 发生异常{}",e);

            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);

    }
    /*
     * @Description:完结订单
     * @param: [orderId, map]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId")String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e){

            log.error("【卖家端订单完结】 发生异常{}",e);

            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);

    }


    }
