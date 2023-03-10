package com.elfindel69.rpg_spring.manager;

import com.elfindel69.rpg_spring.handler.CompetenceHandler;
import com.elfindel69.rpg_spring.models.Competence;

import java.util.List;

public interface CompetenceManager {
    Competence createCompetence(CompetenceHandler handler);

    Competence getCompetence(long id);

    List<Competence> getCompetences();

    void deleteCompetence(long id);
}
