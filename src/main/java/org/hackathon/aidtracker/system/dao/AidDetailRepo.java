package org.hackathon.aidtracker.system.dao;

import org.hackathon.aidtracker.system.entity.AidDetail;
import org.hackathon.aidtracker.system.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AidDetailRepo extends JpaRepository<AidDetail,Long> {
    AidDetail findByDemand(Demand demand);
}
