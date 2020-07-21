package org.hackathon.aidtracker.system.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.hackathon.aidtracker.system.dto.DemandWithDetail;
import org.hackathon.aidtracker.system.entity.AidDetail;
import org.hackathon.aidtracker.system.entity.Demand;
import org.hackathon.aidtracker.system.service.SupplierService;
import org.hackathon.aidtracker.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "捐赠方controller")
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService=supplierService;
    }

    @ApiOperation("需求列表")
//    @ApiResponses({ @ApiResponse(code = CommonStatus.OK, message = "操作成功"),
//            @ApiResponse(code = CommonStatus.EXCEPTION, message = "服务器内部异常"),
//            @ApiResponse(code = CommonStatus.FORBIDDEN, message = "权限不足") })
//    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "信息id", required = true) })
    @GetMapping("/demand-page")
    public R<Page<Demand>> demandPage(int pageNum, int size){
        return R.success(supplierService.getDemandPage(pageNum,size));
    }

    @ApiOperation("需求详情")
    @GetMapping("/demand-detail")
    public R<AidDetail> demandDetail(Long demandId){
        return R.success(supplierService.getDemandDetail(demandId));
    }
//    @GetMapping("/test")
//    public void test( ){
//      supplierService.test();
//    }
}
