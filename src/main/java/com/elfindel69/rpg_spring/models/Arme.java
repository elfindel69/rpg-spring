package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.TypeDe;
import com.elfindel69.rpg_spring.enums.TypeEquipement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "arme")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Arme extends Equipement {
    @Enumerated
    @Column(name = "de")
    private TypeDe de;

    @Column(name = "modif")
    private int modif;

    public Arme(String nom, int prix, TypeDe de, int modif) {
        super(nom, TypeEquipement.ARMEMENT, prix);
        this.de = de;
        this.modif = modif;
    }

}