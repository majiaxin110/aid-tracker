package org.hackathon.aidtracker.system.dto;

import org.hackathon.aidtracker.system.entity.AidDetail;
import org.hackathon.aidtracker.system.entity.Demand;

public class DemandWithDetail {
    private Demand demand;
    private AidDetail aidDetail;

    public DemandWithDetail(Demand demand,AidDetail aidDetail){
        this.demand=demand;
        this.aidDetail=aidDetail;
    }
}
