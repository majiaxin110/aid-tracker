package org.hackathon.aidtracker.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "at_demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="组织名称/发起单位")
    private String organization;

    @ApiModelProperty(value="物资种类")
    private String resourceType;

    @ApiModelProperty(value="所在地区")
    private String location;

    @ApiModelProperty(value="受益方")
    private String beneficiary;

    @ApiModelProperty(value="所需物资总数")
    private int totalNum;

    @ApiModelProperty(value="现在物资缺口的数量")
    private int vacancyNum;

    @ApiModelProperty(value="物资数量单位")
    private String unit;

    @ApiModelProperty(value="需求状态;open:筹集中;closed:已满足;")
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sys_user_id")
    private SysUser requester;

    public  enum Status{
        demanding,satisfied
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
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

    public int getVacancyNum() {
        return vacancyNum;
    }

    public void setVacancyNum(int vacancyNum) {
        this.vacancyNum = vacancyNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
