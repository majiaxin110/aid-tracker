package org.hackathon.aidtracker;

import cn.hutool.db.Entity;
import cn.hutool.db.sql.SqlUtil;
import cn.hutool.json.JSONUtil;
import org.hackathon.aidtracker.system.dao.AidDetailRepo;
import org.hackathon.aidtracker.system.dao.DemandRepo;
import org.hackathon.aidtracker.system.entity.Demand;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.transform.Transformer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class AidTrackerApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    DemandRepo demandRepo;

    @Autowired
    AidDetailRepo aidDetailRepo;

    @Autowired
    EntityManager entityManager;

    @Test
    void insert(){


    }

}
