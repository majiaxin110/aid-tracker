package org.hackathon.aidtracker.system.common;

import org.hackathon.aidtracker.util.R;
import org.hibernate.sql.OracleJoinFragment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SysExceptionHandler {



    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R<Object> handle(Exception ex){
        return R.exception();
    }



    /// specific exceptions
//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public R<Object> handle(Exception ex){
//        return R.exception();
//    }

}

