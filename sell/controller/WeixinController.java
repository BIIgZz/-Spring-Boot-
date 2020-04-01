package com.zzh.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 1:54 2020/3/25
 * @Modified By:
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("计入auth方法..");
        log.info("code={}",code);
       String url =  "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd20009b0aee3e067&secret=1162be9ed4f075f944cf0a8e21308fb4&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
       String result = restTemplate.getForObject(url,String.class);
       log.info("respone={}",result);
    }
}
