package org.hackathon.aidtracker.constant;

public enum WeChatUrl {
    //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    JS_CODE_2_SESSION("https://api.weixin.qq.com/sns/jscode2session?appid="+ SysConst.wxAppIdKey+
            "&secret="+ SysConst.wxSecKeyKey+"&js_code="+ SysConst.wxJSCodeKey+"&grant_type=authorization_code"),
    GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token");
    private String url;
    WeChatUrl(String url){
        this.url=url;
    }
    public String get() {
        return url;
    }
}
