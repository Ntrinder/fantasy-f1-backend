package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Driver implements Serializable {

    @Id
    private int id;

    private int driverNumber;

    private String driverCode;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String nationality;

}
