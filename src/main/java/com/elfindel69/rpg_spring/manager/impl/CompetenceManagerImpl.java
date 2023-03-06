package com.elfindel69.rpg_spring.manager.impl;

import com.elfindel69.rpg_spring.manager.CompetenceManager;
import com.elfindel69.rpg_spring.models.Competence;
import com.elfindel69.rpg_spring.services.CompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompetenceManagerImpl implements CompetenceManager {
    private final CompetenceService competenceService;
    @Override
    public Competence createCompetence(Competence competence) {
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
