package org.hackathon.aidtracker.mybatis.been;

/**
 * 功能描述:
 *
 * @author 许小狼
 * @date 2020/3/7 7:45 下午
 */
public class ReqBeen {
    private int index;          //当前页
    private int pageSize;        //每页条数
    private String demandId;    //需求ID

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }
}
