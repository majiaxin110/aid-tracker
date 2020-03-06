package org.hackathon.aidtracker.system.controller;

import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    @GetMapping(SysConstant.LOGIN_PATH)
    public String login(Model model) {
        return "base/login";
    }
    @GetMapping("/401")
    public String _401(Model model) {
        return "base/401";
    }

    @GetMapping(SysConstant.LOGIN_SUCCESS_PATH)
    public String supervision(Model model){
        return "system/supervision";
    }
    //@ResponseBody


}
