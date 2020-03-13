package org.hackathon.aidtracker.system.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RouteController {

    @GetMapping("/api/doc")
    public void apiDoc(HttpServletResponse response) {
        try {
            response.sendRedirect("/swagger-ui.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @GetMapping("/403")
    public JSONObject _403() {
        return JSONUtil.createObj().putOpt("code",403).putOpt("msg","request forbidden!");
    }
    @ResponseBody
    @GetMapping("/401")
    public JSONObject _401() {
        return JSONUtil.createObj().putOpt("code",401).putOpt("msg","request forbidden!");
    }
}
