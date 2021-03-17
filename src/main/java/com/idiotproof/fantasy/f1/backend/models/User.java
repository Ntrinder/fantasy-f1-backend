package com.idiotproof.fantasy.f1.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    private String username;

    private String email;

    @Column("join_date")
    private Date joinDate;

}
