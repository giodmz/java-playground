package com.mh.hunt.model;

import com.mh.hunt.enums.monster.Diet;
import com.mh.hunt.enums.monster.Species;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Monster {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Species species;
    private Double height;
    private Double weight;
    private Diet diet;
    


}
