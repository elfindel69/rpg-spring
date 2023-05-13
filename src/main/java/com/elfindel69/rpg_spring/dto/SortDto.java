package com.elfindel69.rpg_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SortDto {

    private String nom;

    private int niveau;

    private String ecole;

    private String type;

    private String portee;
    private int de;
    private int modif;

}
