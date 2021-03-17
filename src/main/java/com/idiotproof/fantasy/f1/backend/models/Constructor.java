package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Constructor implements Serializable {

    @Id
    private int id;

    private String constructorId;

    private String name;

    private String nationality;

}
