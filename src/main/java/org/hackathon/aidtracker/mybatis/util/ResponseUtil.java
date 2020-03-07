package org.hackathon.aidtracker.mybatis.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 功能描述: 返回参数封装
 *
 * @auther: 许小狼
 * @date: 2020/3/7 12:38 下午
 */
public class ResponseUtil {

    //自定义返回信息
    public static Object responVo(boolean errStatus,String errMsg,Object data,String otherKey,Object value){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("errStatus",errStatus);
        obj.put("errMsg",errMsg);
        if(data != null){
            obj.put("data",data);
        }
        if(otherKey != null){
            if(value != null){
                obj.put(otherKey,value);
            }
        }
        return obj;
    }
}
