package org.hackathon.aidtracker.system.controller;

import cn.hutool.json.JSONObject;
import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.hackathon.aidtracker.auth.util.JwtUtil;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.hackathon.aidtracker.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class BaseController {

    private SysUserService sysUserService;
    @Autowired
    public BaseController(SysUserService sysUserService)  {
        this.sysUserService=sysUserService;
    }

    @PostMapping(SysConstant.REGISTER_PATH)
    public SysUser register(HttpServletRequest request, @RequestBody JSONObject jsonObject, HttpServletResponse response){
        SysUser sysUser = sysUserService.register(request.getHeader(SysConstant.BASE_TOKEN_HEADER), jsonObject);
        if(Objects.nonNull(sysUser)){
            List<String> role=new ArrayList<>();
            role.add(sysUser.getRole().val());
            response.setHeader(SysConstant.TOKEN_HEADER, JwtUtil.createToken(sysUser.getOpenId(),role));
        }
        return sysUser;
    }
    @GetMapping("/test")
    public String test(){
        return "1231232";
    }
}
