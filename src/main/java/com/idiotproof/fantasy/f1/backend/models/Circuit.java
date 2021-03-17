package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "circuits")
public class Circuit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column("circuit_id")
    private String circuitId;

    private String name;

    private Double longitude;

    private double latitude;

    private String locality;

    private String country;

}
