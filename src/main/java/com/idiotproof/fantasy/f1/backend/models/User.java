package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class User implements Serializable {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private Date joinDate;

}
