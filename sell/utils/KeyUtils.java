package com.zzh.sell.utils;

import java.util.Random;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 20:30 2020/3/9
 * @Modified By:
 */
public class KeyUtils {
    /**
     *
     * @Description:
     * 生成唯一的主键
     * 格式：时间+随机数
     * @auther: zhuZHUzhu
     * @date: 20:31 2020/3/9
     * @param: []
     * @return: java.lang.String
     *
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000)+10000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
