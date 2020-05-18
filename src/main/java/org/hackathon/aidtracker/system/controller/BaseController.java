package org.hackathon.aidtracker.system.controller;

import org.apache.commons.fileupload.FileItemStream;
import org.hackathon.aidtracker.aop.annotation.ParamValidate;
import org.hackathon.aidtracker.constant.SysConst;
import org.hackathon.aidtracker.multipart.AsyncMultipartHttpServletRequest;
import org.hackathon.aidtracker.multipart.RawStreamHandler;
import org.hackathon.aidtracker.util.JwtUtil;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.hackathon.aidtracker.system.service.SysUserService;
import org.hackathon.aidtracker.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class BaseController {

    private SysUserService sysUserService;
    @Autowired
    public BaseController(SysUserService sysUserService)  {
        this.sysUserService=sysUserService;
    }

    @ParamValidate
    @PostMapping(SysConst.FILL_USER_PATH)
    public R<SysUser> fill(HttpServletRequest request, @Valid @RequestBody SysUser sysUser, HttpServletResponse response){
        if(Objects.isNull(sysUser)||Objects.isNull(sysUser.getId()))return null;
        String header = request.getHeader(SysConst.BASE_TOKEN_HEADER);
        if(StringUtils.isEmpty(header)) return R.forbidden("illegal access!");
        R<SysUser> r = sysUserService.fill(header, sysUser);
        if(Objects.nonNull(r.getData())){
            List<String> role=new ArrayList<>();
            role.add(sysUser.getRole().val());
            response.setHeader(SysConst.TOKEN_HEADER, JwtUtil.createToken(sysUser.getOpenId(),role));
        }
        return r;
    }



    @PostMapping("/ttt")
    public R ttt(AsyncMultipartHttpServletRequest request,MultipartFile mFile1,MultipartFile mFile2)throws Exception{
        RawStreamHandler rawStreamHandler = request.getRawStreamHandler();
        Map<String, FileItemStream> itemStreamMap = rawStreamHandler.getItemStreamMap();
        mFile1.transferTo(new File("E:\\out\\123\\ttt.txt"));
        return R.success();
    }

}
