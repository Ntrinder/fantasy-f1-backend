package com.idiotproof.fantasy.f1.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "points")
public class Points implements Serializable {

    @Id
    private int position;

    private int points;

}
