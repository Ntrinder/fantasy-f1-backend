package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "fastest_lap")
public class FastestLap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fastest_lap_id")
    private int id;

    @Column(name = "lap_no")
    private int lapNo;

    private int rank;

    private String time;

    @Column(name = "avg_speed")
    private String avgSpeed;
}
