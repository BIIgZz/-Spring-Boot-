package com.zzh.sell.enums;

import lombok.Getter;


/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 16:24 2020/3/9
 * @Modified By:
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消")
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }


}
