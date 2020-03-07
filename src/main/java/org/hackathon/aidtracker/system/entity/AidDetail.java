package org.hackathon.aidtracker.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "at_aid_detail")
public class AidDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "p_id")
    @OneToOne
    private Demand demand;

    //物资种类
    private String resourceName;

    //物资型号/品种要求
    private String resourceSpecs;



    //收货人姓名
    private String receiverName;

    //联系电话
    private String phoneNum;

    //wx
    private String wxAccount;

    private String qqAccount;

    private String email;

    //收货人省
    private String receiverProvince;

    //市
    private String receiverCity;

    //详细地址
    private String detailAddress;

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceSpecs() {
        return resourceSpecs;
    }

    public void setResourceSpecs(String resourceSpecs) {
        this.resourceSpecs = resourceSpecs;
    }



    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
