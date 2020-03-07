package org.hackathon.aidtracker.mybatis.been;

/**
 * 功能描述:需求列表实体类
 *
 * @author 许小狼
 * @date 2020/3/7 2:09 下午
 */
public class DemandBeen {
    private String demanId;         //需求ID
    private String sysUserId;       //用户ID
    private String title;           //标题
    private String createTime;      //创建时间
    private String organization;    //发起单位
    private String location;        //所在地区
    private String totalInfo;       //需求总量信息
    private String status;          //状态

    public String getDemanId() {
        return demanId;
    }

    public void setDemanId(String demanId) {
        this.demanId = demanId;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTotalInfo() {
        return totalInfo;
    }

    public void setTotalInfo(String totalInfo) {
        this.totalInfo = totalInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
