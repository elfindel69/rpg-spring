package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.Archetype;
import com.elfindel69.rpg_spring.enums.Espece;
import com.elfindel69.rpg_spring.enums.Nation;
import com.elfindel69.rpg_spring.enums.Sexe;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Enumerated
    @Column(name = "sexe")
    private Sexe sexe;

    @Enumerated
    @Column(name = "archetype")
    private Archetype archetype;

    @Enumerated
    @Column(name = "nation")
    private Nation nation;

    @Enumerated
    @Column(name = "espece")
    private Espece espece;

    @Column(name = "metier")
    private String metier;

    @Column(name = "niveau")
    private int niveau = 1;

    @Column(name = "xp")
    private int xp = 0;

    @Column(name = "mana")
    private int mana = 25;

    @Column(name = "pv")
    private int pv = 50;

    @Column(name = "armure")
    private int armure = 0;
    @Column(name = "corps")
    private int corps = 0;
    @Column(name = "esprit")
    private int esprit = 0;
    @Column(name = "relationnel")
    private int relationnel = 0;
    @Column(name = "argent")
    private int argent = 0;
    @Column(name = "ptsDestin")
    private int ptsDestin = 0;
    @Column(name = "pcHab")
    private int pcHab = 8;
    @Column(name = "pcSpe")
    private int pcSpe = 8;

    @ToString.Exclude
    @ManyToMany(mappedBy = "personnages")
    private List<Sort> sorts = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "personnages")
    private List<Equipement> equipements = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "personnages")
    private List<Competence> competences = new ArrayList<>();

}
