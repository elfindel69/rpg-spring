package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.Archetype;
import com.elfindel69.rpg_spring.enums.Espece;
import com.elfindel69.rpg_spring.enums.Nation;
import com.elfindel69.rpg_spring.enums.Sexe;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Personnage", indexes = {
        @Index(name = "idx_personnage_id", columnList = "id")
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
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

    public void addCorps(int bonus) {
        corps += bonus;
    }

    public void addEsprit(int bonus) {
        esprit += bonus;
    }

    public void addRelationnel(int bonus) {
        relationnel += bonus;
    }

    public void removePcHab(int pts) {
        pcHab -= pts;
    }

    public void removePcSpe(int pts) {
        pcSpe -= pts;
    }

    public void removeArgent(int prix) {
        argent -= prix;
    }

    public void addVie(int bonusVie) {
        pv += bonusVie;
    }

    public void addMana(int bonusMana) {
        mana += bonusMana;
    }

    public void addArmure(int bonus) {
        armure += bonus;
    }
}
