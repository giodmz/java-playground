package com.mh.hunt.model;


import com.mh.hunt.enums.hunter.Position;
import com.mh.hunt.enums.hunter.Weapon;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
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
