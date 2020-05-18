package org.hackathon.aidtracker.aop.handler;


import org.hackathon.aidtracker.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R<Object> handleException(Exception e) {
        String errorMsg = "";
        if (e instanceof NullPointerException) {
            errorMsg = "参数空指针异常";
        } else if (e instanceof HttpMessageNotReadableException) {
            errorMsg = "请求参数匹配错误," + e.getLocalizedMessage();
        } else {
            errorMsg = e.getMessage();
        }
        logger.error(String.format("请求异常[%s]", e));
        return R.exception(errorMsg);
    }
}
//@NotNull(message = "用户名不能为空")
//private String name;
//
//@NotNull(message = "手机号不能为空")
//private String mobile;
//@Valid
//
//@ParamValidate
