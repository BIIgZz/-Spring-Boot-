package com.zzh.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author: zhuZHUzhu
 * @Description:http请求返回的最外层对象
 * @Date: Created in 20:20 2020/3/7
 * @Modified By:
 */
@Data
public class ResultVO<T> {

    /** 错误码。*/
    private Integer code;

    /** 提示信息。*/
    private String msg ;

    /** 具体内容。*/
    private T data;

}
