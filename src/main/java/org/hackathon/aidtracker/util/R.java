package org.hackathon.aidtracker.util;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

public class R<T> {

    @ApiModelProperty(value = "统一返回状态code")
    private int code;
    @ApiModelProperty(value = "统一返回状态枚举")
    private Status status;
    @ApiModelProperty(value = "统一返回结果信息")
    private String message;
    @ApiModelProperty(value = "数据结果包")
    private T data;

    enum Status{
        success(1000),unauthorized(1001),forbidden(1002),exception(1003),error(1004);
        private int code;
        Status(int code){
            this.code=code;
        }
        int val(){
            return code;
        }
    }

    private R() {

    }

    public static<T> R<T> success(T data,String... message) {
        R<T> r=new R<>();
        r.code=Status.success.val();
        r.status=Status.success;
        r.data=data;
        r.message=StringUtils.arrayToCommaDelimitedString(message);
        return r;
    }

    public static<T> R<T> success(String... message) {
        R<T> r=new R<>();
        r.code=Status.success.val();
        r.status=Status.success;
        r.message=StringUtils.arrayToCommaDelimitedString(message);
        return r;
    }

    public static<T> R<T> error(String message) {
        if(StringUtils.isEmpty(message)) message = "unknown error";
        R<T> r=new R<>();
        r.status=Status.error;
        r.message=message;
        r.code=Status.error.val();
        return r;
    }

    public static<T> R<T> exception(String... message) {
        String msg;
        if(message.length==0){
            msg="unknown exception!";
        }else{
            msg=StringUtils.arrayToCommaDelimitedString(message);
        }        R<T> r=new R<>();
        r.status=Status.exception;
        r.message=msg;
        r.code=Status.exception.val();
        return r;
    }



    public static<T> R<T> unauthorized(String... message) {
        String msg;
        if(message.length==0){
            msg="no permission!";
        }else{
            msg=StringUtils.arrayToCommaDelimitedString(message);
        }
        R<T> r=new R<>();
        r.status=Status.unauthorized;
        r.message=msg;
        r.code=Status.unauthorized.val();
        return r;
    }

    public static<T> R<T> unauthorized(T data,String... message) {
        String msg;
        if(message.length==0){
            msg="complete user info!";
        }else{
            msg=StringUtils.arrayToCommaDelimitedString(message);
        }
        R<T> r=new R<>();
        r.status=Status.unauthorized;
        r.message=msg;
        r.code=Status.unauthorized.val();
        r.data=data;
        return r;
    }
    public static<T> R<T> forbidden(String... message) {
        String msg;
        if(message.length==0){
            msg="request forbidden!";
        }else{
            msg=StringUtils.arrayToCommaDelimitedString(message);
        }
        R<T> r=new R<>();
        r.status=Status.forbidden;
        r.message=msg;
        r.code=Status.forbidden.val();
        return r;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
