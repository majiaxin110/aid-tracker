package org.hackathon.aidtracker.system.dao;

import org.hackathon.aidtracker.system.entity.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogisticsRepo extends JpaRepository<Logistics,Long> {
}
