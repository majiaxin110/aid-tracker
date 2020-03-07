package org.hackathon.aidtracker.system.service;

import cn.hutool.json.JSONObject;
import org.hackathon.aidtracker.auth.util.Encrypt;
import org.hackathon.aidtracker.auth.util.WechatUtil;
import org.hackathon.aidtracker.system.controller.BaseController;
import org.hackathon.aidtracker.system.dao.SysUserRepo;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class SysUserService {

    private SysUserRepo sysUserRepo;
    private Logger logger = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    public SysUserService(SysUserRepo sysUserRepo){
        this.sysUserRepo=sysUserRepo;
    }
    public SysUser getSysUser(String openId){
        return sysUserRepo.getOne(openId);
    }
    public SysUser register(String baseToken,JSONObject jsonObject){
        try {
            String decode = Encrypt.ins().decode(baseToken);
            long before = new Date(Long.parseLong(decode)).getTime();
            long now = new Date().getTime();
            if(before>now){
                logger.info("invalid base token!");
                return null;
            }
        } catch (NumberFormatException e) {
            logger.info("illegal attempt access of register interface");
            e.printStackTrace();
            return null;
        }
        String authCode = jsonObject.getStr("authCode");
        String openId = WechatUtil.getOpenId(authCode);
        SysUser sysUser = jsonObject.getBean("userInfo", SysUser.class);
        sysUser.setOpenId(openId);
       return sysUserRepo.save(sysUser);
    }
}
