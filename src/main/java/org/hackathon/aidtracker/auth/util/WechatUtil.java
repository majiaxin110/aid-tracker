package org.hackathon.aidtracker.auth.util;

import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.hackathon.aidtracker.auth.constant.WxUrl;
import org.hackathon.aidtracker.auth.dto.WxAuthRes;
import org.hackathon.aidtracker.auth.security.AuthenticationProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class WechatUtil {
    private static RestTemplate restTemplate;
    private static Logger logger = LoggerFactory.getLogger(WechatUtil.class);
    public WechatUtil(){
        restTemplate=new RestTemplateBuilder().build();
    }
    public static String getOpenId(String authCode){

        WxAuthRes authRes;
        String url = WxUrl.JS_CODE_2_SESSION.get()
                .replace(SysConstant.wxAppIdKey, SysConstant.AppId)
                .replace(SysConstant.wxSecKeyKey, SysConstant.AppSecret)
                .replace(SysConstant.wxJSCodeKey, authCode);
        ResponseEntity<WxAuthRes> resObj = restTemplate.getForEntity(url, WxAuthRes.class);

        if(HttpStatus.OK.equals(resObj.getStatusCode())){
            authRes = resObj.getBody();
            if(Objects.nonNull(authRes)&&Objects.nonNull(authRes.getErrcode())){
                if(!Objects.equals( WxAuthRes.ResCode.success,authRes.getErrcode())){
                    logger.error(authRes.getErrcode().getMsg());
                }else {
                    logger.info("get open id from wechat server: "+authRes.getOpenid());
                    return authRes.getOpenid();
                }
            }else{
                logger.error("empty response body: "+resObj.getStatusCodeValue());
            }
        }else{
            logger.error("network connection to wechat server failed: "+resObj.getStatusCodeValue());
        }
        return null;
    }
}
