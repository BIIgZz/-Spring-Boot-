package com.zzh.sell.utils;

import com.zzh.sell.VO.ResultVO;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 22:25 2020/3/7
 * @Modified By:
 */
public class ResultVOUtils {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public  static ResultVO error (Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}
