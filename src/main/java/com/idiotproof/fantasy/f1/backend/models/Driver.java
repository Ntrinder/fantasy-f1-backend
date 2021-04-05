package com.idiotproof.fantasy.f1.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "drivers")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_id")
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "constructor_id")
    @JsonIgnoreProperties("team")
    private Constructor team;

}
