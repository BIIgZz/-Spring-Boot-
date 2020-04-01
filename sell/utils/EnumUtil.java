package com.zzh.sell.utils;

import com.zzh.sell.enums.CodeEnum;



/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 14:36 2020/3/18
 * @Modified By:
 */
public class  EnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants() ){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;

    }
}
