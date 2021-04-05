package com.idiotproof.fantasy.f1.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "races")
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "race_id")
    private int id;

    private int season;

    private int round;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "circuit_id")
    private Circuit circuit;

    private String date;

    private String time;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "result_id")
    private List<Result> results;

}
