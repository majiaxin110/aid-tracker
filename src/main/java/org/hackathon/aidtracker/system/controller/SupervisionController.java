package org.hackathon.aidtracker.system.controller;

import cn.hutool.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-sv")
public class SupervisionController {
    @RequestMapping("/auth-test")
    @PreAuthorize("hasAnyRole('ROLE_DEV','ROLE_PM','ROLE_ADMIN')")
    public JSONObject authTest(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.append("test","12124");
        return jsonObject;
    }

}
