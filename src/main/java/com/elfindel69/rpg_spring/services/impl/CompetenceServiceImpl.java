package com.elfindel69.rpg_spring.services.impl;

import com.elfindel69.rpg_spring.enums.TypeCompetence;
import com.elfindel69.rpg_spring.models.Competence;
import com.elfindel69.rpg_spring.models.Personnage;
import com.elfindel69.rpg_spring.repository.CompetenceRepository;
import com.elfindel69.rpg_spring.services.CompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {
    private final CompetenceRepository repository;
    @Override
    public Competence createCompetence(Competence competence) {
        return repository.save(competence);
    }

    @Override
    public Competence getCompetence(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Competence> getCompetences() {
        return repository.findAll();
    }

    @Override
    public void deleteCompetence(long id) {
        repository.deleteById(id);
    }

    @Override
    public long countHabiletes(Personnage p){
        return repository.findAll().stream()
                .filter(c -> c.getType().equals(TypeCompetence.HABILETE)
                && c.getPersonnages().contains(p))
                .count();
    }

    @Override
    public long countSpes(Personnage p) {
        return repository.findAll().stream()
                .filter(c -> c.getType().equals(TypeCompetence.SPECIALISATION)
                        && c.getPersonnages().contains(p))
                .count();
    }
}
