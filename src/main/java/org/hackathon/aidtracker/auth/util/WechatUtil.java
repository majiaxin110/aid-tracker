package org.hackathon.aidtracker.auth.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.hackathon.aidtracker.auth.constant.WxUrl;
import org.hackathon.aidtracker.auth.dto.WxAuthRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class WechatUtil {
    private static RestTemplate restTemplate=new RestTemplateBuilder().build();
    private static Logger logger = LoggerFactory.getLogger(WechatUtil.class);

    public static String getOpenId(String authCode){

////        return "1213123123";
//        WxAuthRes authRes;
//        String url = WxUrl.JS_CODE_2_SESSION.get()
//                .replace(SysConstant.wxAppIdKey, SysConstant.AppId)
//                .replace(SysConstant.wxSecKeyKey, SysConstant.AppSecret)
//                .replace(SysConstant.wxJSCodeKey, authCode);
//
//
//        String str = restTemplate.getForObject(url, String.class);
//        JSONObject obj = JSONUtil.parseObj(str);
//        logger.info("js code "+authCode+"; response from wx server:"+ JSONUtil.toJsonStr(obj));
//        if(Objects.nonNull(obj)&&Objects.nonNull(obj.getStr("openid"))){
//            return obj.getStr("openid");
//        }

//        ResponseEntity<WxAuthRes> resObj = null;
//        try {
//            resObj = restTemplate.getForEntity(url, WxAuthRes.class);
//        } catch (RestClientException e) {
//            e.printStackTrace();
//
//
//        }
//
//        if(Objects.nonNull(resObj)&&HttpStatus.OK.equals(resObj.getStatusCode())){
//            authRes = resObj.getBody();
//            if(Objects.nonNull(authRes)&&Objects.nonNull(authRes.getErrcode())){
//                if(!Objects.equals( WxAuthRes.ResCode.success,authRes.getErrcode())){
//                    logger.error(authRes.getErrcode().getMsg());
//                }else {
//                    logger.info("get open id from wechat server: "+authRes.getOpenid());
//                    return authRes.getOpenid();
//                }
//            }else{
//                logger.error("empty response body: "+resObj.getStatusCodeValue());
//            }
//        }else{
//            logger.error("network connection to wechat server failed: "+resObj.getStatusCodeValue());
//        }
        return "1233111111";
    }
}
