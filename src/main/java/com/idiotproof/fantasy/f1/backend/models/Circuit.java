package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Circuit implements Serializable {

    @Id
    private int id;

    private String circuitId;

    private String name;

    private Double longitude;

    private double latitude;

    private String locality;

    private String country;

}
