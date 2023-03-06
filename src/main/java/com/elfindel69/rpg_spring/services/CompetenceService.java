package com.elfindel69.rpg_spring.services;

import com.elfindel69.rpg_spring.models.Competence;
import com.elfindel69.rpg_spring.models.Personnage;

import java.util.List;

public interface CompetenceService {
    Competence createCompetence(Competence competence);

    Competence getCompetence(long id);

    List<Competence> getCompetences();

    void deleteCompetence(long id);

    long countHabiletes(Personnage p);

    long countSpes(Personnage p);
}
