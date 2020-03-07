package org.hackathon.aidtracker.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "at_demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //标题
    private String title;

    //创建时间
    private Date createTime;

    //组织名称
    private String organization;

    //地址
    private String location;

    //受益方
    private String beneficiary;

    //总数
    private int totalNum;

    //还差多少可以满足
    private int leftNum;
    //状态
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sys_user_id")
    private SysUser requester;

    public static enum Status{
        open,closed
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SysUser getRequester() {
        return requester;
    }

    public void setRequester(SysUser requester) {
        this.requester = requester;
    }
}
