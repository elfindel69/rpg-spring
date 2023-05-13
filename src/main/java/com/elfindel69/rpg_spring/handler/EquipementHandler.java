package com.elfindel69.rpg_spring.handler;

import com.elfindel69.rpg_spring.dto.EquipementDto;
import com.elfindel69.rpg_spring.enums.TypeDe;
import com.elfindel69.rpg_spring.enums.TypeEquipement;
import lombok.Data;

@Data
public class EquipementHandler {

    private String nom;
    private TypeEquipement type;
    private int prix;

    private TypeDe de;
    private int modif;

    private int armure;

    private int mana;

    private int pv;

    public EquipementHandler(EquipementDto dto) {
        this.nom = dto.getNom();
        this.prix = dto.getPrix();
        this.type = TypeEquipement.fromName(dto.getType());

        this.de = TypeDe.fromValue(dto.getDe());
        this.modif = dto.getModif();

        this.armure = dto.getArmure();

        this.mana = dto.getMana();

        this.pv = dto.getPv();
    }
}
