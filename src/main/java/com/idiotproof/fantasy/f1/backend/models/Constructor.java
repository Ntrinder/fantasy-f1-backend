package com.idiotproof.fantasy.f1.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "constructors")
public class Constructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "constructor_id")
    private int id;

    @Column(name = "constructor_identifier")
    private String constructorIdentifier;

    private String name;

    private String nationality;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "constructor_id")
    @JsonIgnoreProperties("drivers")
    private List<Driver> drivers;

}
