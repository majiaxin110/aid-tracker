package org.hackathon.aidtracker.auth.constant;

public enum WxUrl {
    //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    JS_CODE_2_SESSION("https://api.weixin.qq.com/sns/jscode2session?appid="+SysConstant.wxAppIdKey+
            "&secret="+SysConstant.wxSecKeyKey+"&js_code="+SysConstant.wxJSCodeKey+"&grant_type=authorization_code"),
    GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token");
    private String url;
    WxUrl(String url){
        this.url=url;
    }
    public String get() {
        return url;
    }
}
