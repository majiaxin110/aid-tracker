package org.hackathon.aidtracker.constant;

public class SysConst {

    public static final String OPEN_ID_AUTH_PATH="/api-user-auth";

    public static final String PASSWORD_AUTH_PATH="/api-user-auth-pass";

    public static final String LOGIN_SUCCESS_PATH="/supervision";
    public static final String TOKEN_HEADER = "accessToken";
    public static final String BASE_TOKEN_HEADER="baseToken";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_CLAIMS = "Permission";
    public static final String TOKEN_TYPE = "JWT";
    public static final String JWT_SECRET_KEY = "khdfFDF#98%&HsK'/|uD3!)&+_weHJ23ersd%^^!(@&(!*asdq124;2qer97HIUHLKSN'/PYNdU*&93";
    public static final long EXPIRATION_REMEMBER = 1000*60*60*24*14L;


    public static final String AppId="wx2794378e18ee1fb5";
    public static final String AppSecret="8fb4ae14d80d2d76c44696ebadb2c971";
    public static final String wxAppIdKey="APPID";
    public static final String wxSecKeyKey="SECRET";
    public static final String wxJSCodeKey="JSCODE";
    public static final String WX_AUTH_PARAM_KEY="authCode";
    public static final String phantomPass="fake";
    public static final String FILL_USER_PATH="/api-user-fill";
    public  enum LoginType{
        firstLogin,notFirstLogin
    }
    public static String[] SWAGGER_RESOURCE={"/api/doc","/frame","/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/**"};

    public static String[] TEST_RESOURCE={"/api-donate-getDemandList","/api-donate-getDemandListDetail","/api-donate-subDonSup","/api-donate-saveDraft"};

}
