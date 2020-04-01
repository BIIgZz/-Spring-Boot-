package com.zzh.sell.converter;

import com.zzh.sell.dataobject.OrderMaster;
import com.zzh.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 17:20 2020/3/13
 * @Modified By:
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters){
       return orderMasters.stream().map(e->
                convert(e)
                ).collect(Collectors.toList());

    }
}
