package org.hackathon.aidtracker.system.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "at_supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private SysUser supplier;

    private Date initiateTime;

    private Date completeTime;

    private STATUS status;

    @OneToOne
    private AidDetail supplyDetail;


    public static enum STATUS{
        UNCHECKED,TRANSPORT,COMPLETE
    }
}
