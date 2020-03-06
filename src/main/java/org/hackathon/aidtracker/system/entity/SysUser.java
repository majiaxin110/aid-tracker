package org.hackathon.aidtracker.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "at_sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String openId;
    private String wxNickName;
    private Gender gender;
    private Role role;
    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private String orgName;
    private OrgType orgType;


    public static enum Gender{
        male(1),female(2),unknown(0);
        private Integer val;
        Gender(Integer val){
            this.val=val;
        }
        public Integer val() {
            return val;
        }
    }
    public static enum Role {
        supplier,demander,sys_keeper
    }
    public static enum OrgType{
        individual(1),school(2),enterprise(3),other_with_auth(4),
        other_without_auth(5),community(6),medical_institution(7);
        private Integer val;
        OrgType(Integer val){
            this.val=val;
        }
        public Integer val() {
            return val;
        }
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public OrgType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrgType orgType) {
        this.orgType = orgType;
    }
}
