package org.hackathon.aidtracker.util;

import cn.hutool.json.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommonUtil {
    public static void writeJSON(HttpServletResponse response,Object obj){
        try {
            response.setHeader("Content-Type", "application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSONUtil.toJsonStr(obj));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
