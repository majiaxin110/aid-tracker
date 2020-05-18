package org.hackathon.aidtracker.system.service;

import org.hackathon.aidtracker.aop.annotation.AtLog;
import org.hackathon.aidtracker.mybatis.controller.Supplier;
import org.hackathon.aidtracker.system.dao.*;
import org.hackathon.aidtracker.system.entity.AidDetail;
import org.hackathon.aidtracker.system.entity.Demand;
import org.hackathon.aidtracker.system.entity.Supply;
import org.hackathon.aidtracker.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@AtLog("bbbb")
@Service
public class SupplierService {


    private AidDetailRepo aidDetailRepo;
    private DemandRepo demandRepo;
    private SupplyRepo supplyRepo;
    private LogisticsRepo logisticsRepo;
    private SysUserRepo sysUserRepo;
    private EntityManager entityManager;

    @Autowired
    public SupplierService(AidDetailRepo aidDetailRepo,DemandRepo demandRepo,
                           SupplyRepo supplyRepo,LogisticsRepo logisticsRepo,SysUserRepo sysUserRepo,EntityManager entityManager){
        this.aidDetailRepo=aidDetailRepo;
        this.demandRepo=demandRepo;
        this.logisticsRepo=logisticsRepo;
        this.supplyRepo=supplyRepo;
        this.sysUserRepo=sysUserRepo;
        this.entityManager=entityManager;
    }

    public Page<Demand> getDemandPage(int pageNum, int size){
        return demandRepo.findByStatusIsOrderByCreateTimeDesc(Demand.Status.demanding,PageHelper.build(pageNum,size));
    }
    public AidDetail getDemandDetail(Long demandId){
        return aidDetailRepo.findByDemand(new Demand(demandId));
    }


    public void test(){

        TypedQuery<Supply> query = entityManager.createQuery("", Supply.class);
        TypedQuery<Supply> ss = query.setParameter("ss", 1);
        List<Supply> resultList = ss.getResultList();


    }
}
