package org.hackathon.aidtracker.mybatis.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:分页工具
 *
 * @author 许小狼
 * @date 2020/3/7 4:36 下午
 */
public class PageHelper {

    public static Map<String, Object> pages(int index, int pageSize, int totalRows){
        if(index < 1){
            index = 1;
        } else if((index * pageSize - totalRows) > pageSize){
            index = totalRows / pageSize + 1;
        }

        int beginRow = (index - 1) * pageSize + 1;
        int endRow = index * pageSize;

        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("beginRow",beginRow);
        obj.put("endRow",endRow);

        return obj;
    }
}
