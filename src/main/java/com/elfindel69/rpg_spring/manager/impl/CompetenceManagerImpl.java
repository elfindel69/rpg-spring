package com.elfindel69.rpg_spring.manager.impl;

import com.elfindel69.rpg_spring.handler.CompetenceHandler;
import com.elfindel69.rpg_spring.manager.CompetenceManager;
import com.elfindel69.rpg_spring.models.Competence;
import com.elfindel69.rpg_spring.models.Habilete;
import com.elfindel69.rpg_spring.models.Specialisation;
import com.elfindel69.rpg_spring.services.CompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.elfindel69.rpg_spring.enums.TypeCompetence.HABILETE;
import static com.elfindel69.rpg_spring.enums.TypeCompetence.SPECIALISATION;

@Component
@RequiredArgsConstructor
public class CompetenceManagerImpl implements CompetenceManager {
    private final CompetenceService competenceService;
    @Override
    public Competence createCompetence(CompetenceHandler handler) {
        Competence competence = null;
        if (handler.getType().equals(HABILETE)){
            competence = new Habilete(handler.getNom(),handler.getNiveau());
        }
        if (handler.getType().equals(SPECIALISATION)){
            competence = new Specialisation(handler.getNom(),handler.getNiveau());
        }
        return competenceService.createCompetence(competence);
    }

    @Override
    public Competence getCompetence(long id) {
        return competenceService.getCompetence(id);
    }

    @Override
    public List<Competence> getCompetences() {
        return competenceService.getCompetences();
    }

    @Override
    public void deleteCompetence(long id) {
        competenceService.deleteCompetence(id);
    }
}
