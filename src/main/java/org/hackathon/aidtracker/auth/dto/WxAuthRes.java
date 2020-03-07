package org.hackathon.aidtracker.auth.dto;

public class WxAuthRes {
    //openid	string	用户唯一标识
    //session_key	string	会话密钥
    //unionid	string	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
    //errcode	number	错误码
    //errmsg	string	错误信息
    private String openid;
    private String session_key;
    private String unionid;
    private ResCode errcode;
    private String errmsg;

    public static enum  ResCode{
        busy(-1,"wechat server is busy!retry later"),success(0,"ok"),
        codeInvalid(40029,"invalid jsCode"),frequencyLimit(45011,"frequency exceeded");
        private Integer val;
        private String msg;
        ResCode(Integer val,String msg){
            this.val=val;
        }
        public Integer getVal() {
            return val;
        }

        public String getMsg() {
            return msg;
        }
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public ResCode getErrcode() {
        return errcode;
    }

    public void setErrcode(ResCode errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
