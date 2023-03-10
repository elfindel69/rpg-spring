package com.elfindel69.rpg_spring.handler;

import com.elfindel69.rpg_spring.enums.TypeCompetence;
import dto.CompetenceDto;
import lombok.Data;

@Data
public class CompetenceHandler {
    private String nom;

    private int niveau;

    private TypeCompetence type;

    public CompetenceHandler(CompetenceDto dto) {
        nom = dto.getNom();
        niveau = dto.getNiveau();
        type = TypeCompetence.findByName(dto.getType());
    }

}
