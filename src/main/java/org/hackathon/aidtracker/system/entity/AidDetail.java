package org.hackathon.aidtracker.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "at_aid_detail")
public class AidDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //todo
}
