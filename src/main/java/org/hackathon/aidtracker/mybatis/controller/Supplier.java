package org.hackathon.aidtracker.mybatis.controller;

import org.hackathon.aidtracker.mybatis.been.DemanBeenDetail;
import org.hackathon.aidtracker.mybatis.been.DemandBeen;
import org.hackathon.aidtracker.mybatis.been.DonateSuppliesStatusBeen;
import org.hackathon.aidtracker.mybatis.been.ReqBeen;
import org.hackathon.aidtracker.mybatis.service.SupplierService;
import org.hackathon.aidtracker.mybatis.util.PageHelper;
import org.hackathon.aidtracker.mybatis.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 功能描述: 捐赠方相关API
 *
 * @auther: 许小狼
 * @date: 2020/3/7 12:14 下午
 */
@Controller
@Validated
public class Supplier {
    @Autowired
    SupplierService supplierService;

    //获取需求列表
    @RequestMapping("/at/getDemandList")
    @ResponseBody
    public Object quarryDemandList(ReqBeen reqBeen) {
        if(reqBeen.getIndex() == 0 && reqBeen.getPagSize() == 0){
            return ResponseUtil.responVo(false,"页码信息请求出错，请联系管理员或请重试!",null,null,null);
        }

        try{
            int index = reqBeen.getIndex();
            int pagSize = reqBeen.getPagSize();
            int totalRows = supplierService.quarryDemandtotalRows();
            int maxPage = totalRows / pagSize + 1;

            List<DemandBeen> demandList = supplierService.quarryDemandList(PageHelper.pages(index,pagSize,totalRows));
            return ResponseUtil.responVo(true,"请求成功",demandList,"maxPage",maxPage);
        } catch (Exception e){
            return ResponseUtil.responVo(false,"请求出错，请联系管理员!",null,null,null);
        }
    }


    //获取需求列表详情页
    @RequestMapping("/at/getDemandListDetail")
    @ResponseBody
    public Object quarryDemandListDetail(ReqBeen reqBeen){

        if(reqBeen.getDemandId() == null){
            return ResponseUtil.responVo(false,"获取需求ID错误，请联系管理员或请重试!",null,null,null);
        }

        try {
            DemanBeenDetail demanDetail = supplierService.quarryDemanDetail(reqBeen.getDemandId());

            return ResponseUtil.responVo(true,"请求成功",demanDetail,null,null);
        } catch (Exception e){
            return ResponseUtil.responVo(false,"请求出错，请联系管理员!",null,null,null);
        }

    }

    //提交捐赠物资表
    @RequestMapping("/at/subDonSup")
    @ResponseBody
    public Object subDonateSupplies(DonateSuppliesStatusBeen donSupStat){
        List<String>  donaterInfo= new ArrayList();
        if (donSupStat.getDonaterWxId() == null) {
            donaterInfo.add("WxId");
        }
        if (donSupStat.getDonaterQqId() == null) {
            donaterInfo.add("QqId");
        }
        if (donSupStat.getDonaterPhone() == null) {
            donaterInfo.add("Phone");
        }
        if (donSupStat.getDonaterEmail() == null) {
            donaterInfo.add("Email");
        }

        if (donSupStat.getDonateResName() == null) {
            return ResponseUtil.responVo(false,"请输入物资种类!",null,null,null);
        } else if (donSupStat.getDonateResType() == null) {
            return ResponseUtil.responVo(false,"请输入物资规格!",null,null,null);
        } else if (donSupStat.getDonateResManufacturer() == null) {
            return ResponseUtil.responVo(false,"请输入生产厂家!",null,null,null);
        } else if (donSupStat.getDonateResNum() == null) {
            return ResponseUtil.responVo(false,"请输入物资数量!",null,null,null);
        } else if (donSupStat.getDonateResStatus() == null) {
            return ResponseUtil.responVo(false,"请选择物资状态!",null,null,null);
        } else if (donSupStat.getDonateResShipMth() == null) {
            return ResponseUtil.responVo(false,"请选择物流方式!",null,null,null);
        } else if (donSupStat.getDonateResPro() == null || donSupStat.getDonateResCity() == null) {
            return ResponseUtil.responVo(false,"请选择发货地!",null,null,null);
        } else if (donSupStat.getDonaterName() == null) {
            return ResponseUtil.responVo(false,"请输入姓名!",null,null,null);
        } else if (donSupStat.getDemandId() == null) {
            return ResponseUtil.responVo(false,"获取需求ID错误，请联系管理员或请重试!",null,null,null);
        } else if (donaterInfo.size() == 4) {
            return ResponseUtil.responVo(false,"请至少选择一项联系方式输入!",null,null,null);
        }



        try {
            int i = supplierService.subDonateSupplies(donSupStat);
            if (i == 1){
                return ResponseUtil.responVo(true,"提交成功!",null,null,null);
            } else if (i == 2){
                return ResponseUtil.responVo(false,"提交出错，请联系管理员!",null,null,null);
            } else if(i == 3){
                return ResponseUtil.responVo(false,"更新剩余数量错误，请联系管理员!",null,null,null);
            } else if(i == 4){
                return ResponseUtil.responVo(false,"捐赠数量超过可捐赠数量，请修改物资数量!",null,null,null);
            } else {
                return ResponseUtil.responVo(false,"提交出错，请联系管理员!",null,null,null);
            }
        } catch (Exception e){
            return ResponseUtil.responVo(false,"提交出错，请联系管理员!",null,null,null);
        }
    }



}
