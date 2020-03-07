package org.hackathon.aidtracker.system.entity;

import javax.persistence.*;

/**
 * 功能描述:
 *
 * @author 许小狼
 * @date 2020/3/7 6:50 下午
 */
@Entity
@Table(name = "at_Don_Sup_Stat")
public class DonateSuppliesStatus {

    //捐赠物资表ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donSupStaId;
    //物资种类
    private String donateResName;
    //物资规格
    private String donateResType;
    //生产厂家
    private String donateResManufacturer;
    //数量
    private String donateResNum;
    //物资状态
    private String donateResStatus;
    //物流方式
    private String donateResShipMth;
    //发货省
    private String donateResPro;
    //发货市
    private String donateResCity;
    //姓名
    private String donaterName;
    //微信
    private String donaterWxId;
    //QQ
    private String donaterQqId;
    //电话
    private String donaterPhone;
    //邮箱
    private String donaterEmail;
    //备注
    private String donaterNote;
    //捐赠需求ID
    private Long DemandId;
    //捐赠物资表状态
    private int donateSupSta;
    //用户ID
    private int userId;

    public Long getDonSupStaId() {
        return donSupStaId;
    }

    public void setDonSupStaId(Long donSupStaId) {
        this.donSupStaId = donSupStaId;
    }

    public String getDonateResName() {
        return donateResName;
    }

    public void setDonateResName(String donateResName) {
        this.donateResName = donateResName;
    }

    public String getDonateResType() {
        return donateResType;
    }

    public void setDonateResType(String donateResType) {
        this.donateResType = donateResType;
    }

    public String getDonateResManufacturer() {
        return donateResManufacturer;
    }

    public void setDonateResManufacturer(String donateResManufacturer) {
        this.donateResManufacturer = donateResManufacturer;
    }

    public String getDonateResNum() {
        return donateResNum;
    }

    public void setDonateResNum(String donateResNum) {
        this.donateResNum = donateResNum;
    }

    public String getDonateResStatus() {
        return donateResStatus;
    }

    public void setDonateResStatus(String donateResStatus) {
        this.donateResStatus = donateResStatus;
    }

    public String getDonateResShipMth() {
        return donateResShipMth;
    }

    public void setDonateResShipMth(String donateResShipMth) {
        this.donateResShipMth = donateResShipMth;
    }

    public String getDonateResPro() {
        return donateResPro;
    }

    public void setDonateResPro(String donateResPro) {
        this.donateResPro = donateResPro;
    }

    public String getDonateResCity() {
        return donateResCity;
    }

    public void setDonateResCity(String donateResCity) {
        this.donateResCity = donateResCity;
    }

    public String getDonaterName() {
        return donaterName;
    }

    public void setDonaterName(String donaterName) {
        this.donaterName = donaterName;
    }

    public String getDonaterWxId() {
        return donaterWxId;
    }

    public void setDonaterWxId(String donaterWxId) {
        this.donaterWxId = donaterWxId;
    }

    public String getDonaterQqId() {
        return donaterQqId;
    }

    public void setDonaterQqId(String donaterQqId) {
        this.donaterQqId = donaterQqId;
    }

    public String getDonaterPhone() {
        return donaterPhone;
    }

    public void setDonaterPhone(String donaterPhone) {
        this.donaterPhone = donaterPhone;
    }

    public String getDonaterEmail() {
        return donaterEmail;
    }

    public void setDonaterEmail(String donaterEmail) {
        this.donaterEmail = donaterEmail;
    }

    public String getDonaterNote() {
        return donaterNote;
    }

    public void setDonaterNote(String donaterNote) {
        this.donaterNote = donaterNote;
    }

    public Long getDemandId() {
        return DemandId;
    }

    public void setDemandId(Long demandId) {
        DemandId = demandId;
    }

    public int getDonateSupSta() {
        return donateSupSta;
    }

    public void setDonateSupSta(int donateSupSta) {
        this.donateSupSta = donateSupSta;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
