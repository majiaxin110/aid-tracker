package org.hackathon.aidtracker.mybatis.service;

import org.hackathon.aidtracker.mybatis.been.DemanBeenDetail;
import org.hackathon.aidtracker.mybatis.been.DemandBeen;
import org.hackathon.aidtracker.mybatis.been.DonateSuppliesStatusBeen;

import java.util.List;
import java.util.Map;

/**
 * 功能描述:捐赠方service接口层
 *
 * @author 许小狼
 * @date 2020/3/7 1:05 下午
 */
public interface SupplierService {
    //获取需求列表总数
    int quarryDemandtotalRows();

    //获取需求列表
    List<DemandBeen> quarryDemandList(Map<String, Object> pages);

    //获取需求列表详情页
    DemanBeenDetail quarryDemanDetail(String demandId);

    //提交捐赠物资表
    int subDonateSupplies(DonateSuppliesStatusBeen donateSuppliesStatusBeen);
}
