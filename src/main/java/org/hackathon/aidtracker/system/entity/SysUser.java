package org.hackathon.aidtracker.system.entity;

import org.hackathon.aidtracker.auth.dto.BaseUser;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "at_sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ops!")
    private Long id;
    private String openId;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private String orgName;
    @Enumerated(EnumType.STRING)
    private OrgType orgType;
    private String supplierLocation;    //捐赠方所在地
    private String demanderDefaultAddress;    //接收方默认收货地址


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierLocation() {
        return supplierLocation;
    }

    public void setSupplierLocation(String supplierLocation) {
        this.supplierLocation = supplierLocation;
    }

    public String getDemanderDefaultAddress() {
        return demanderDefaultAddress;
    }

    public void setDemanderDefaultAddress(String demanderDefaultAddress) {
        this.demanderDefaultAddress = demanderDefaultAddress;
    }

    public static enum Gender{
        unknown(0), male(1),female(2);
        private Integer val;
        Gender(Integer val){
            this.val=val;
        }
        public Integer val() {
            return val;
        }
    }
    public static enum Role {
        supplier("supplier"),demander("demander"),sys_keeper("sys_keeper");
        private String val;
        Role(String val){
            this.val=val;
        }
        public String val() {
            return val;
        }
    }
    public static enum OrgType{
        individual(1),school(2),enterprise(3),other_with_auth(4),
        other_without_auth(5),community(6),medical_institution(7),other_institution(8);
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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


    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SysUser sysUser = (SysUser) o;
//        return Objects.equal(id, sysUser.id) &&
//                Objects.equal(openId, sysUser.openId) &&
//                Objects.equal(nickname, sysUser.nickname) &&
//                gender == sysUser.gender &&
//                role == sysUser.role &&
//                Objects.equal(avatarUrl, sysUser.avatarUrl) &&
//                Objects.equal(country, sysUser.country) &&
//                Objects.equal(province, sysUser.province) &&
//                Objects.equal(city, sysUser.city) &&
//                Objects.equal(orgName, sysUser.orgName) &&
//                orgType == sysUser.orgType &&
//                Objects.equal(supplierLocation, sysUser.supplierLocation) &&
//                Objects.equal(demanderDefaultAddress, sysUser.demanderDefaultAddress);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id, openId, nickname, gender, role, avatarUrl, country, province, city, orgName, orgType, supplierLocation, demanderDefaultAddress);
//    }


    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SysUser sysUser = (SysUser) o;
//        return id.equals(sysUser.id) &&
//                Objects.equals(openId, sysUser.openId) &&
//                Objects.equals(nickname, sysUser.nickname) &&
//                gender == sysUser.gender &&
//                role == sysUser.role &&
//                Objects.equals(avatarUrl, sysUser.avatarUrl) &&
//                Objects.equals(country, sysUser.country) &&
//                Objects.equals(province, sysUser.province) &&
//                Objects.equals(city, sysUser.city) &&
//                Objects.equals(orgName, sysUser.orgName) &&
//                orgType == sysUser.orgType &&
//                Objects.equals(supplierLocation, sysUser.supplierLocation) &&
//                Objects.equals(demanderDefaultAddress, sysUser.demanderDefaultAddress);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, openId, nickname, gender, role, avatarUrl, country, province, city, orgName, orgType, supplierLocation, demanderDefaultAddress);
//    }
}
