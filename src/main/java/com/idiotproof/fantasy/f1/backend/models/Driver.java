package com.idiotproof.fantasy.f1.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "drivers")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "driver_number")
    @JsonProperty("permanentNumber")
    private int driverNumber;

    @Column(name = "driver_code")
    @JsonProperty("code")
    private String driverCode;

    @Column(name = "first_name")
    @JsonProperty("givenName")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("familyName")
    private String lastName;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    @JsonProperty("nationality")
    private String nationality;

}
