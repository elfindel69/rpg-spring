package com.elfindel69.rpg_spring.services.impl;

import com.elfindel69.rpg_spring.repository.PersonnageRepository;
import com.elfindel69.rpg_spring.models.Personnage;
import com.elfindel69.rpg_spring.services.PersonnageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonnageServiceImpl implements PersonnageService {
    private final PersonnageRepository repository;


    @Override
    public Personnage editPersonnage(Personnage personnage) {
        return repository.save(personnage);
    }

    @Override
    public Personnage getPersonnage(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Personnage> getPersonnages() {
        return repository.findAll();
    }

    @Override
    public void deletePersonnage(long id) {
        repository.deleteById(id);
    }
}
