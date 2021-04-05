package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "circuits")
public class Circuit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "circuit_id")
    private int id;

    @Column(name = "circuit_identifier")
    private String circuitIdentifier;

    private String name;

    private Double longitude;

    private double latitude;

    private String locality;

    private String country;

}
