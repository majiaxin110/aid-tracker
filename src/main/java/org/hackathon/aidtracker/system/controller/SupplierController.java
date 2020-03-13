package org.hackathon.aidtracker.system.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.hackathon.aidtracker.system.service.SupplierService;
import org.hackathon.aidtracker.util.R;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation("")
    @GetMapping("/demand-page")
    public R demandPage(int pageNum,int size){
        return R.ok(supplierService.getDemandPage(pageNum,size));
    }


    @GetMapping("/demand-detail")
    public R demandDetail(Long demandId){
        return R.ok(supplierService.getDemandWithDetail(demandId));
    }
}
