package org.hackathon.aidtracker.system.dao;

import org.hackathon.aidtracker.system.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepo extends JpaRepository<SysUser, Long> {
    SysUser findByOpenId(String openId);
    boolean existsByOpenId(String openId);
}
