package org.hackathon.aidtracker.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "at_supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sys_user_id")
    private SysUser supplier;

    //物资种类
    private String supplyName;

    //物资规格
    private String supplySpecs;

    //生产厂家
    private String manufacturer;

    //数量
    private int count;
    //单位
    private String unit;

    //物资发货前状态
    private StateBeforeSend stateBeforeSend;

    //物流方式
    private Way2Pickup pickupWay;

    //发货省
    private String departureProvince;

    //发货市
    private String departureCity;

    //详细地址
    private String detailAddress;

    //发货人
    private String consignorName;

    private String phoneNum;

    private String wxAccount;

    private String qqAccount;

    private String email;

    //备注
    private String memo;

    private Status status;

    //创建时间
    private Date createTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "demand_id")
    private Demand demand;

    //草稿|对接中|准备发货|运输中|完成|拒绝
    public static enum Status{
        draft,connecting,ready2Send,transporting,complete,refused
    }
    //现货|物资筹集中
    public static enum StateBeforeSend{
        inStock,waiting;
    }
    //送货上门|自取
    public static enum Way2Pickup{
        delivery,selfTaking
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SysUser getSupplier() {
        return supplier;
    }

    public void setSupplier(SysUser supplier) {
        this.supplier = supplier;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getSupplySpecs() {
        return supplySpecs;
    }

    public void setSupplySpecs(String supplySpecs) {
        this.supplySpecs = supplySpecs;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public StateBeforeSend getStateBeforeSend() {
        return stateBeforeSend;
    }

    public void setStateBeforeSend(StateBeforeSend stateBeforeSend) {
        this.stateBeforeSend = stateBeforeSend;
    }

    public Way2Pickup getPickupWay() {
        return pickupWay;
    }

    public void setPickupWay(Way2Pickup pickupWay) {
        this.pickupWay = pickupWay;
    }

    public String getDepartureProvince() {
        return departureProvince;
    }

    public void setDepartureProvince(String departureProvince) {
        this.departureProvince = departureProvince;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }
}
