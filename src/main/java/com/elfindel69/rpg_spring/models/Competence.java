package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.TypeCompetence;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "competence")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "niveau")
    protected int niveau=0;

    @Enumerated
    @Column(name = "type")
    protected TypeCompetence type;

    @ManyToMany
  @JsonIgnore
    @JoinTable(name = "competence_personnages",
            joinColumns = @JoinColumn(name = "competence_id"),
            inverseJoinColumns = @JoinColumn(name = "personnages_id"))
    private List<Personnage> personnages = new ArrayList<>();

    public Competence(String nom, int niveau, TypeCompetence type ){
        this.nom = nom;
        this.niveau = niveau;
        this.type = type;
    }

}