package org.hackathon.aidtracker.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hackathon.aidtracker.mybatis.been.DemanBeenDetail;
import org.hackathon.aidtracker.mybatis.been.DemandBeen;

import java.util.List;
import java.util.Map;

/**
 * 功能描述:捐赠方serviceMapper
 *
 * @author 许小狼
 * @date 2020/3/7 1:09 下午
 */
@Mapper
public interface SupplierMapper {
    //获取需求列表总数
    int quarryDemandtotalRows();

    //获取需求列表
    List<DemandBeen> quarryDemandList(Map<String, Object> pages);

    //获取需求列表详情页
    DemanBeenDetail quarryDemanDetail(String demandId);

    //提交捐赠物资表
    int subDonateSupplies(Map<String, Object> subDonSupMap);

    //更新剩余数量
    int upDateDemLeftNum(Map<String, Object> upDateDemLeftNumMap);

    //请求剩余需求数量
    int quarryLiftNum(Long demandId);
}
