package com.elfindel69.rpg_spring.manager;

import com.elfindel69.rpg_spring.enums.Archetype;
import com.elfindel69.rpg_spring.enums.Sexe;
import com.elfindel69.rpg_spring.handler.PersonnageHandler;
import com.elfindel69.rpg_spring.models.*;

import java.util.List;

public interface PersonnageManager {

    Personnage createPersonnage(final PersonnageHandler handler);

    boolean addSort(final Personnage personnage, final Sort sort);

    void addEquip(final Personnage personnage, final Equipement equipment);

    boolean addHabilete(final Personnage personnage, final Habilete habilete);

    boolean addSpe(final Personnage personnage, final Specialisation specialisation);

    Personnage getPersonnage(long id);

    List<Personnage> getPersonnages();

    void deletePersonnage(long id);
}
