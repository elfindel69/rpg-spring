package com.elfindel69.rpg_spring.services;

import com.elfindel69.rpg_spring.models.Personnage;

import java.util.List;


public interface PersonnageService {
    Personnage editPersonnage(Personnage personnage);

    Personnage getPersonnage(long id);

    List<Personnage> getPersonnages();

    void deletePersonnage(long id);

}
