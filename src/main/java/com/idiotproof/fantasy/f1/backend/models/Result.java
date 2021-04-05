package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "results")
public class Result implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private int position;

    private String status;

    private String time;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fastest_lap_id")
    private FastestLap fastestLap;

}
