package org.hackathon.aidtracker.util;
public class R<T> {

    private int code;
    private Status status;
    private String message;
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
    private R() {}
    public static<T> R<T> success(T data) {
        R<T> r=new R<>();
        r.code= Status.success.val();
        r.status= Status.success;
        r.data=data;
        return r;
    }
    public static R success() {
        return build(Status.success,null);
    }
    public static R success(String message) {
        return build(Status.success,message);
    }
    public static R error(String message) {
        return build(Status.error,message);
    }
    public static R exception(String message) {
        return build(Status.exception,message);
    }
    public static R unauthorized(String message) {
        return build(Status.unauthorized,message);
    }
    public static<T> R<T> unauthorized(T o) {
        R<T> r=new R<>();
        r.code= Status.success.val();
        r.status= Status.success;
        r.data=o;
        return r;
    }
    public static R unauthorized() {
        return build(Status.unauthorized,null);
    }

    public static R forbidden(String message) {
      return build(Status.forbidden,message);
    }
    public static R forbidden() {
        return build(Status.forbidden,null);
    }

    private static R build(Status status,String message){
        R r=new R<>();
        r.status= status;
        r.code= status.val();
        r.message=message;
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
