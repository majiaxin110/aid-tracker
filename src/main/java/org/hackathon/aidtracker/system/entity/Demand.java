package org.hackathon.aidtracker.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "at_demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private STATUS status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "demander_id")
    private SysUser demander;

    @OneToOne
    private AidDetail demandDetail;

    public static enum STATUS{
        OPEN,TRANSPORT,SATISFIED
    }
}
