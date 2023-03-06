package com.elfindel69.rpg_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "potion_vie")
public class PotionVie extends Potion {
    @Column(name = "pv")
    private int pv;

    public PotionVie(String nom, int prix, int pv) {
        super(nom, prix);
        this.pv = pv;
    }
}