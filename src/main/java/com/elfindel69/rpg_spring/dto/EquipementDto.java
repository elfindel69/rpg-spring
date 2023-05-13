package com.elfindel69.rpg_spring.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipementDto {
    private String nom;
    private String type;
    private int prix;

    private int de;
    private int modif;

    private int armure;

    private int mana;

    private int pv;
}
