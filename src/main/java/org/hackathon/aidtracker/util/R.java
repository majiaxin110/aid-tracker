package org.hackathon.aidtracker.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;

public class R extends HashMap<String, Object> {

    private R() {
    }

    public static R ok(Object data) {
        R r;
        r = ok();
        r.put("data", data);
        return r;
    }

    public static R ok() {
        R r = new R();
        r.put("status", "SUCCESS");
        r.put("code", 200);
        r.put("message", "success");
        r.put("data", new String[]{});
        return r;
    }

    public static R error(String message) {
        if (StringUtils.isEmpty(message))
            message = "未知异常";
        R r = new R();
        r.put("status", "ERROR");
        r.put("code", 500);
        r.put("message", message);
        r.put("data", new String[]{});
        return r;
    }

    public static R error(int code, String message) {
        R r = new R();
        r.put("status", "ERROR");
        if (code == 0)
            r.put("code", 500);
        else
            r.put("code", code);
        if (StringUtils.isEmpty(message))
            r.put("message", "未知异常");
        else
            r.put("message", message);
        r.put("data", new String[]{});
        return r;

    }
}
