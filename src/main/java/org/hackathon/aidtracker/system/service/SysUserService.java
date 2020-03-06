package org.hackathon.aidtracker.system.service;

import org.hackathon.aidtracker.system.dao.SysUserRepo;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    private SysUserRepo sysUserRepo;

    @Autowired
    public SysUserService(SysUserRepo sysUserRepo){
        this.sysUserRepo=sysUserRepo;
    }
    public SysUser getSysUser(String openId){
        return sysUserRepo.getOne(openId);
    }
}
