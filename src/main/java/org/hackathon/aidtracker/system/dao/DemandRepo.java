package org.hackathon.aidtracker.system.dao;

import org.hackathon.aidtracker.system.entity.Demand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepo extends JpaRepository<Demand,Long> {
    @Override
    Page<Demand> findAll(Pageable pageable);
}
