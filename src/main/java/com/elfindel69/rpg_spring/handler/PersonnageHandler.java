package com.elfindel69.rpg_spring.handler;

import com.elfindel69.rpg_spring.enums.Archetype;
import com.elfindel69.rpg_spring.enums.Espece;
import com.elfindel69.rpg_spring.enums.Nation;
import com.elfindel69.rpg_spring.enums.Sexe;
import dto.PersonnageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonnageHandler {
    private String nom;
    private Sexe sexe;
    private Archetype archetype;
    private Nation nation;
    private Espece espece;
    private String metier;

    public PersonnageHandler(PersonnageDto dto){
        this.nom = dto.getNom();
        this.sexe = Sexe.fromName(dto.getSexe());
        this.archetype = Archetype.fromName(dto.getArchetype());
        this.nation = Nation.fromName(dto.getNation());
        this.espece = Espece.fromName(dto.getEspece());
        this.metier = dto.getMetier();
    }
}
