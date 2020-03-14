package org.hackathon.aidtracker.util;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

public class R<T> {

    @ApiModelProperty
    private int code;
    private Status status;
    private String message;
    private T data;

    enum Status{
        success,unauthorized,forbidden,notFound,exception,error
    }

    private R() {

    }

    public static<T> R<T> success(T data,String... message) {
        R<T> r=new R<>();
        r.code=200;
        r.status=Status.success;
        r.data=data;
        r.message=StringUtils.arrayToCommaDelimitedString(message);
        return r;
    }

    public static<T> R<T> success(String... message) {
        R<T> r=new R<>();
        r.code=200;
        r.status=Status.success;
        r.message=StringUtils.arrayToCommaDelimitedString(message);
        return r;
    }

    public static<T> R<T> error(String message) {
        if(StringUtils.isEmpty(message)) message = "unknown error";
        R<T> r=new R<>();
        r.status=Status.error;
        r.message=message;
        r.code=500;
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
        r.code=500;
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
        r.code=401;
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
        r.code=401;
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
        r.code=403;
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
