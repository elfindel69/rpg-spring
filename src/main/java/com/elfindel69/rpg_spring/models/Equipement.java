package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.TypeEquipement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipement")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "nom")
    protected String nom;

    @Enumerated
    @Column(name = "type")
    protected TypeEquipement type;

    @Column(name = "prix")
    protected int prix;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "equipement_personnages",
            joinColumns = @JoinColumn(name = "equipement_id"),
            inverseJoinColumns = @JoinColumn(name = "personnages_id"))
    private List<Personnage> personnages = new ArrayList<>();

    public Equipement(String nom, TypeEquipement type, int prix){
        this.nom = nom;
        this.type = type;
        this.prix = prix;
    }

}