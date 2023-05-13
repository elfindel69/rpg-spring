package com.elfindel69.rpg_spring.manager.impl;

import com.elfindel69.rpg_spring.handler.PersonnageHandler;
import com.elfindel69.rpg_spring.manager.PersonnageManager;
import com.elfindel69.rpg_spring.models.*;
import com.elfindel69.rpg_spring.services.CompetenceService;
import com.elfindel69.rpg_spring.services.EquipementService;
import com.elfindel69.rpg_spring.services.PersonnageService;
import com.elfindel69.rpg_spring.services.SortService;
import com.elfindel69.rpg_spring.utils.MyRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonnageManagerImpl implements PersonnageManager {

    private final PersonnageService personnageService;
    private final CompetenceService competenceService;
    private final SortService sortService;
    private final EquipementService equipementService;

    @Override
    public Personnage createPersonnage(final PersonnageHandler handler) {
        Personnage personnage = new Personnage();

        personnage.setNom(handler.getNom());
        personnage.setSexe(handler.getSexe());
        personnage.setArchetype(handler.getArchetype());
        personnage.setNation(handler.getNation());
        personnage.setEspece(handler.getEspece());
        personnage.setMetier(handler.getMetier());
        final MyRandom randomLevel = new MyRandom(50, 80);
        personnage.setCorps(randomLevel.randomize());
        personnage.setEsprit(randomLevel.randomize());
        personnage.setRelationnel(randomLevel.randomize());
        final MyRandom randomArgent = new MyRandom(300, 1000);
        personnage.setArgent(randomArgent.randomize());
        final MyRandom randomDestin = new MyRandom(1, 4);
        personnage.setPtsDestin(randomDestin.randomize());

        addSpeciesBonus(personnage);

        return personnageService.editPersonnage(personnage);
    }

    private boolean addSort(final Personnage personnage, Sort sort) {
        boolean added = false;
        if (personnage.getSorts().size() < 3 + (personnage.getNiveau() - 1)) {
            sort = sortService.editSort(sort);
            sort.getPersonnages().add(personnage);
            sortService.editSort(sort);
            personnage.getSorts().add(sort);
            personnageService.editPersonnage(personnage);
            added = true;
        } else {
            System.out.println("liste de sorts pleine!");
        }

        return added;
    }

    private void addEquip(final Personnage personnage, Equipement equipment) {

        equipment = equipementService.editEquipement(equipment);
        if (equipment instanceof Protection) {

            int armor = ((Protection) equipment).getArmure();
            personnage.addArmure(armor);
        }
        if (equipment instanceof Arme) {
            if (equipment.getPrix() < personnage.getArgent()) {
                personnage.removeArgent(equipment.getPrix());
            } else {
                System.out.println("Pas assez d'argent");
            }

        }
        if (equipment instanceof PotionMana) {
            int mana = ((PotionMana) equipment).getMana();
            personnage.addMana(mana);
        }
        if (equipment instanceof PotionVie) {
            int vie = ((PotionVie) equipment).getPv();
            personnage.addVie(vie);
        }
        equipment.getPersonnages().add(personnage);
        equipementService.editEquipement(equipment);
        personnage.getEquipements().add(equipment);
        personnageService.editPersonnage(personnage);

    }


    private boolean addHabilete(Personnage personnage, Habilete habilete) {
        boolean added = false;
        if (competenceService.countHabiletes(personnage) <= 3 && personnage.getPcHab() > 0) {
            habilete = (Habilete) competenceService.editCompetence(habilete);
            personnage.getCompetences().add(habilete);
            personnage.removePcHab(habilete.getNiveau());
            habilete.getPersonnages().add(personnage);
            competenceService.editCompetence(habilete);
            personnageService.editPersonnage(personnage);

            added = true;
        } else {
            System.out.println("liste d'habiletés pleine!");
        }

        return added;
    }


    private boolean addSpe(Personnage personnage, Specialisation specialisation) {
        boolean added = false;
        if (competenceService.countSpes(personnage) <= 3 && personnage.getPcSpe() > 0) {
            specialisation = (Specialisation) competenceService.editCompetence(specialisation);
            personnage.getCompetences().add(specialisation);
            personnage.removePcSpe(specialisation.getNiveau());
            specialisation.getPersonnages().add(personnage);
            competenceService.editCompetence(specialisation);
            personnageService.editPersonnage(personnage);
            added = true;
        } else {
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

    @Override
    public Personnage addEquipement(Long id, Long idEquipement) {
        Equipement equipement = equipementService.getEquipement(idEquipement);
        Personnage personnage = personnageService.getPersonnage(id);
        addEquip(personnage, equipement);
        return personnage;
    }

    @Override
    public Personnage addSort(Long id, Long idSort) {
        Sort sort = sortService.getSort(idSort);
        Personnage personnage = personnageService.getPersonnage(id);
        addSort(personnage, sort);
        return personnage;
    }

    @Override
    public Personnage addComp(Long id, Long idComp) {
        Personnage personnage = personnageService.getPersonnage(id);
        Competence competence = competenceService.getCompetence(idComp);
        if (competence instanceof Habilete) {
            addHabilete(personnage, (Habilete) competence);
        } else {
            addSpe(personnage, (Specialisation) competence);
        }
        return personnage;
    }

    private void addSpeciesBonus(Personnage p) {
        Specialisation nego = new Specialisation("Négociant", 1);
        Specialisation diss = new Specialisation("Dissimulation", 1);
        Habilete pist = new Habilete("Pistage", 1);

        switch (p.getEspece()) {
            case Aiguls:
                p.addRelationnel(3);
                addSpe(p, nego);
                break;
            case Cham_ars:
                addSpe(p, nego);
                addSpe(p, diss);
                break;
            case Dhis_urs:
                p.addCorps(5);
                addSpe(p, nego);
            case Dontars:
                p.addRelationnel(3);
                break;
            case Ethels:
                p.addEsprit(5);
                break;
            case Fondars:
                p.addCorps(3);
            case Periandar:
                addHabilete(p, pist);
                addSpe(p, nego);
                break;
            case Sedhars:
                p.addEsprit(3);
                break;
            case Sondars:
                p.addCorps(2);
                break;
            case Ossars:
                p.addRelationnel(5);
                break;
            case Humans:
            default:
                break;
        }
    }
}
