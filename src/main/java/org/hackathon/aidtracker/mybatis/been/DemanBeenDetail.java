package org.hackathon.aidtracker.mybatis.been;

/**
 * 功能描述:单一需求详情实体类
 *
 * @author 许小狼
 * @date 2020/3/7 3:50 下午
 */
public class DemanBeenDetail {
    private String demanId;         //捐赠需求ID
    private String title;           //标题
    private String orgType;         //机构类型
    private String createTime;      //创建时间
    private String organization;    //发起单位
    private String location;        //所在地区
    private String beneficiary;     //受益人群
    private String status;          //当前状态
    private String resourceName;    //物资名称
    private String resourceSpecs;   //物资型号
    private int totalNum;           //需要物资数量
    private int leftNum;            //剩余需求数量
    private String receiverName;    //接收人姓名
    private String phoneNum;        //联系方式-电话
    private String wxAccount;       //联系方式-微信
    private String qqAccount;       //联系方式-qq
    private String email;           //联系方式-邮箱
    private String detailAddress;   //联系方式-收货地址

    public String getDemanId() {
        return demanId;
    }

    public void setDemanId(String demanId) {
        this.demanId = demanId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
