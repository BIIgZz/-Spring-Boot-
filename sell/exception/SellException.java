package com.zzh.sell.exception;

import com.zzh.sell.enums.ResultEnum;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 20:17 2020/3/9
 * @Modified By:
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException() {
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException( Integer code,String message ) {
        super(message);
        this.code = code;
    }
}
