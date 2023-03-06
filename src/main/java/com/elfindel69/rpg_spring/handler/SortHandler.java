package com.elfindel69.rpg_spring.handler;

import com.elfindel69.rpg_spring.enums.EcoleSort;
import com.elfindel69.rpg_spring.enums.Portee;
import com.elfindel69.rpg_spring.enums.TypeDe;
import com.elfindel69.rpg_spring.enums.TypeSort;
import dto.SortDto;
import lombok.Data;

@Data
public class SortHandler {

    private String nom;

    private int niveau;

    private EcoleSort ecole;

    private TypeSort type;

    private Portee portee;
    private TypeDe de;
    private int modif;

    public SortHandler (SortDto dto){
        this.nom = dto.getNom();
        this.niveau = dto.getNiveau();
        this.ecole = EcoleSort.fromName(dto.getEcole());
        this.type = TypeSort.fromName(dto.getType());
        this.portee = Portee.fromName(dto.getPortee());
        this.de = TypeDe.fromValue(dto.getDe());
        this.modif = dto.getModif();
    }
}
