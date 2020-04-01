package com.zzh.sell.enums;

import lombok.Getter;

/**
 * @Author: zhuZHUzhu
 * @Description:支付状态枚举
 * @Date: Created in 16:22 2020/3/9
 * @Modified By:
 */

@Getter
public enum PayStatusEnum implements CodeEnum{

    SUCCESS(1,"支付成功"),
    WAIT(0,"待支付")
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
