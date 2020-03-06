package org.hackathon.aidtracker.auth.constant;

public enum WxUrl {
    JS_CODE_2_SESSION("https://api.weixin.qq.com/sns/jscode2session"),
    GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token");
    private String url;
    WxUrl(String url){
        this.url=url;
    }
    public String get() {
        return url;
    }
}
