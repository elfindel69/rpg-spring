package com.elfindel69.rpg_spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "potion_mana")
public class PotionMana extends Potion {
    @Column(name = "mana")
    private int mana;

    public PotionMana(String nom, int prix, int mana){
        super(nom, prix);
        this.mana = mana;
    }
}