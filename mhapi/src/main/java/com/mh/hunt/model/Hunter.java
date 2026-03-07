package com.mh.hunt.model;


import com.mh.hunt.enums.Position;
import com.mh.hunt.enums.Weapon;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Hunter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Weapon weapon;
    private Integer huntCount;
    private Position position;


}
