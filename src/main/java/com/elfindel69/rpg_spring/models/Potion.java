package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.TypeEquipement;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "potion")
@RequiredArgsConstructor
public abstract class Potion extends Equipement {
    public Potion (String nom, int prix){
        super(nom, TypeEquipement.POTION, prix);
    }
}