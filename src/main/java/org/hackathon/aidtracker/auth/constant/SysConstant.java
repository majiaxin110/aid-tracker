package org.hackathon.aidtracker.auth.constant;

public class SysConstant {

    public static final String AUTH_PATH="/custodian-auth";
    public static final String LOGIN_PATH="/custodian/login";
    public static final String LOGIN_SUCCESS_PATH="/supervision";
    public static final String LOGOUT_PATH="/custodian-logout";
    public static final String KEEPER_PREFIX="custodian-";
    public static final String CALLER_PREFIX="invoker-";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_CLAIMS = "Permission";
    public static final String TOKEN_TYPE = "JWT";
    public static final String JWT_SECRET_KEY = "khdfFDF#98%&HsK'/|uD3!)&+_weHJ23ersd%^^!(@&(!*asdq124;2qer97HIUHLKSN'/PYNdU*&93";
    public static final long EXPIRATION = 1000*60*60L;
    public static final long EXPIRATION_REMEMBER = 1000*60*60*24*2L;

    public static final String AUTH_PREFIX="GRANT_";

    public static String[] STATIC_RESOURCE={"/asset/**","/img/**","/reference/**"};
    public static final String LOGIN_SUCCESS_REDIRECT="/";
}
