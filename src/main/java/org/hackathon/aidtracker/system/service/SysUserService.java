package org.hackathon.aidtracker.system.service;

import org.hackathon.aidtracker.util.Encrypt;
import org.hackathon.aidtracker.system.dao.SysUserRepo;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.hackathon.aidtracker.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SysUserService {

    private SysUserRepo sysUserRepo;
    private Logger logger = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    public SysUserService(SysUserRepo sysUserRepo){
        this.sysUserRepo=sysUserRepo;
    }
    public R<SysUser> fill(String baseToken, SysUser sysUser){
        try {
            String decode = Encrypt.INS.decode(baseToken);
            long before = new Date(Long.parseLong(decode)).getTime();
            long now = System.currentTimeMillis();
            if(before>now){
                logger.info("invalid base token!");
                return R.forbidden("invalid base token!");
            }
        } catch (NumberFormatException e) {
            logger.info("illegal access!");
            e.printStackTrace();
            return R.forbidden("illegal access!");
        }
        Optional<SysUser> byId = sysUserRepo.findById(sysUser.getId());
        if(byId.isPresent()){
            SysUser user = byId.get();
            sysUser.setNickname(user.getNickname());
            sysUser.setAvatarUrl(user.getAvatarUrl());
            sysUser.setOpenId(user.getOpenId());
            return R.success(sysUserRepo.save(sysUser));
        }
        return R.exception("invalid user id!");
    }

    public SysUser findByOpenId(String openId){
        return sysUserRepo.findByOpenId(openId);
    }
    public SysUser save(SysUser sysUser){
        return sysUserRepo.save(sysUser);
    }
}
