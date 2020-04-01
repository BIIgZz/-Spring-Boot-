package com.zzh.sell.controller;

import com.zzh.sell.enums.ResultEnum;
import com.zzh.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 2:30 2020/3/25
 * @Modified By:
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl")String returnUrl){
        //1.配置

        //2.调用
        String url = "http://hellosell.nat300.top/sell/wechat/userInfo";
        String redirect = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code，result={}",redirect);
        return "redirect:"+redirect;
    }

        @GetMapping("/userInfo")
        public String userInfo(@RequestParam("code") String code,
                                            @RequestParam("state") String returnUrl){
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
            try {
               wxMpOAuth2AccessToken =  wxMpService.oauth2getAccessToken(code);
            }catch (WxErrorException e){
                log.error("[微信网页授权]{}",e);
                throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
            }
            String openId = wxMpOAuth2AccessToken.getOpenId();
            return "redirect:"+returnUrl+"?openId="+openId;
        }
}
