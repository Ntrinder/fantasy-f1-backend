package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "constructors")
public class Constructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "constructor_id")
    private String constructorId;

    private String name;

    private String nationality;

}
