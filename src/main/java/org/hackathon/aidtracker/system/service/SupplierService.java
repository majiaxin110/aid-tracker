package org.hackathon.aidtracker.system.service;

import org.hackathon.aidtracker.system.dao.*;
import org.hackathon.aidtracker.system.dto.DemandWithDetail;
import org.hackathon.aidtracker.system.entity.Demand;
import org.hackathon.aidtracker.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {


    private AidDetailRepo aidDetailRepo;
    private DemandRepo demandRepo;
    private SupplyRepo supplyRepo;
    private LogisticsRepo logisticsRepo;
    private SysUserRepo sysUserRepo;

    @Autowired
    public SupplierService(AidDetailRepo aidDetailRepo,DemandRepo demandRepo,
                           SupplyRepo supplyRepo,LogisticsRepo logisticsRepo,SysUserRepo sysUserRepo){
        this.aidDetailRepo=aidDetailRepo;
        this.demandRepo=demandRepo;
        this.logisticsRepo=logisticsRepo;
        this.supplyRepo=supplyRepo;
        this.sysUserRepo=sysUserRepo;
    }

    public Page<Demand> getDemandList(int pageNum, int size){
        return demandRepo.findAll(PageHelper.build(pageNum,size));
    }

    public DemandWithDetail getDemandWithDetail(Long demandId){
        Demand demand = demandRepo.getOne(demandId);
        return new DemandWithDetail(demand,aidDetailRepo.findByDemand(demand));
    }


}
