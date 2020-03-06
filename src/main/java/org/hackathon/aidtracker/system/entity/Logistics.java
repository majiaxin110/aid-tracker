package org.hackathon.aidtracker.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "at_logistics")
public class Logistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Long pId;
}
