package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "drivers")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column("driver_number")
    private int driverNumber;

    @Column("driver_code")
    private String driverCode;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("date_of_birth")
    private String dateOfBirth;

    private String nationality;

}
