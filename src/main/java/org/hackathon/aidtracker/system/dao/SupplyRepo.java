package org.hackathon.aidtracker.system.dao;

import org.hackathon.aidtracker.system.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepo extends JpaRepository<Supply,Long> {
}
