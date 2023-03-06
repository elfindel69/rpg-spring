package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.TypeEquipement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "protection")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Protection extends Equipement {
    @Column(name = "armure")
    private int armure;

    public Protection(String nom, int prix, int armure) {
        super(nom, TypeEquipement.PROTECTION, prix);
        this.armure = armure;
    }
}