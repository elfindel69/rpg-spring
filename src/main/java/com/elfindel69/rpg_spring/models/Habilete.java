package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.TypeCompetence;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Habilete extends Competence {



    public Habilete(String nom, int niveau) {
        super(nom, niveau, TypeCompetence.HABILETE);
    }
}