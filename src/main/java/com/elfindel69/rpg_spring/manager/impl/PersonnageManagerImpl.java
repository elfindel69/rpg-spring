package com.elfindel69.rpg_spring.manager.impl;

import com.elfindel69.rpg_spring.handler.PersonnageHandler;
import com.elfindel69.rpg_spring.manager.PersonnageManager;
import com.elfindel69.rpg_spring.models.*;
import com.elfindel69.rpg_spring.services.CompetenceService;
import com.elfindel69.rpg_spring.services.PersonnageService;
import com.elfindel69.rpg_spring.utils.MyRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonnageManagerImpl implements PersonnageManager {

    private final PersonnageService personnageService;
    private final CompetenceService competenceService;

    @Override
    public Personnage createPersonnage(final PersonnageHandler handler) {
        Personnage personnage = new Personnage();
        personnage.setNom(handler.getNom());
        personnage.setSexe(handler.getSexe());
        personnage.setArchetype(handler.getArchetype());
        personnage.setNation(handler.getNation());
        personnage.setEspece(handler.getEspece());
        personnage.setMetier(handler.getMetier());
        final MyRandom randomLevel = new MyRandom(50,80);
        personnage.setCorps(randomLevel.randomize());
        personnage.setEsprit(randomLevel.randomize());
        personnage.setRelationnel(randomLevel.randomize());
        final MyRandom randomArgent = new MyRandom(300,1000);
        personnage.setArgent(randomArgent.randomize());
        final MyRandom randomDestin = new MyRandom(1,4);
        personnage.setPtsDestin(randomDestin.randomize());
        return personnageService.editPersonnage(personnage);
    }

    @Override
    public boolean addSort(final Personnage personnage, final Sort sort) {
        boolean added = false;
        if (personnage.getSorts().size() < 3 + (personnage.getNiveau() - 1)) {
            personnage.getSorts().add(sort);
            added = true;
        } else {
            System.out.println("liste de sorts pleine!");
        }

        return added;
    }

    @Override
    public void addEquip(Personnage personnage, Equipement equipment) {


        if (equipment instanceof Protection) {
            int armor = ((Protection)equipment).getArmure();
            int baseArmor = personnage.getArmure();
            personnage.setArmure(armor + baseArmor);
        }

        personnage.getEquipements().add(equipment);
        personnageService.editPersonnage(personnage);
    }

    @Override
    public boolean addHabilete(Personnage personnage, Habilete habilete) {
        boolean added = false;
        if (competenceService.countHabiletes(personnage) <= 3 && personnage.getPcHab() > 0) {
            personnage.getCompetences().add(habilete);
            personnage.setPcHab(personnage.getPcHab() - habilete.getNiveau());
            added = true;
        }  else {
            System.out.println("liste d'habiletés pleine!");
        }

        return added;
    }

    @Override
    public boolean addSpe(Personnage personnage, Specialisation specialisation) {
        boolean added = false;
        if (competenceService.countSpes(personnage) <= 3 && personnage.getPcSpe() > 0) {
            personnage.getCompetences().add(specialisation);
            personnage.setPcSpe(personnage.getPcSpe() - specialisation.getNiveau());
            added = true;
        }  else {
            System.out.println("liste de spécialisations pleine!");
        }

        return added;
    }

    @Override
    public Personnage getPersonnage(long id) {
        return personnageService.getPersonnage(id);
    }

    @Override
    public List<Personnage> getPersonnages() {
        return personnageService.getPersonnages();
    }

    @Override
    public void deletePersonnage(long id) {
        personnageService.deletePersonnage(id);
    }
}
