package org.hackathon.aidtracker.system.service;

import org.hackathon.aidtracker.annotation.AtLog;
import org.hackathon.aidtracker.system.dao.*;
import org.hackathon.aidtracker.system.dto.DemandWithDetail;
import org.hackathon.aidtracker.system.entity.AidDetail;
import org.hackathon.aidtracker.system.entity.Demand;
import org.hackathon.aidtracker.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SupplierService {


    private AidDetailRepo aidDetailRepo;
    private DemandRepo demandRepo;
    private SupplyRepo supplyRepo;
    private SysUserRepo sysUserRepo;

    @Autowired
    public SupplierService(AidDetailRepo aidDetailRepo,DemandRepo demandRepo,
                           SupplyRepo supplyRepo,SysUserRepo sysUserRepo){
        this.aidDetailRepo=aidDetailRepo;
        this.demandRepo=demandRepo;
        this.supplyRepo=supplyRepo;
        this.sysUserRepo=sysUserRepo;
    }

    public Page<Demand> getDemandPage(int pageNum, int size){
        return demandRepo.findByStatusIsOrderByCreateTimeDesc(Demand.Status.demanding,PageHelper.build(pageNum,size));
    }
    public AidDetail getDemandDetail(Long demandId){
        return aidDetailRepo.findByDemand(new Demand(demandId));
    }
}
