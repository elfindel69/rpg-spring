package com.elfindel69.rpg_spring.dto;

import lombok.Data;

@Data
public class PersonnageDto {
    private final String nom;
    private final char sexe;

    private final String archetype;
    private final String nation;
    private final String espece;

    private final String metier;

}
