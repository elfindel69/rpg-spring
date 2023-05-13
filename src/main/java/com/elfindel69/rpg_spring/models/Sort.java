package com.elfindel69.rpg_spring.models;

import com.elfindel69.rpg_spring.enums.EcoleSort;
import com.elfindel69.rpg_spring.enums.Portee;
import com.elfindel69.rpg_spring.enums.TypeDe;
import com.elfindel69.rpg_spring.enums.TypeSort;
import com.elfindel69.rpg_spring.handler.SortHandler;
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
@Table(name = "sort")
public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "niveau")
    private int niveau;

    @Enumerated
    @Column(name = "ecole")
    private EcoleSort ecole;

    @Enumerated
    @Column(name = "type")
    private TypeSort type;

    @Enumerated
    @Column(name = "portee")
    private Portee portee;
    @Enumerated
    @Column(name = "de")
    private TypeDe de;
    @Column(name = "modif")
    private int modif;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "sort_personnages",
            joinColumns = @JoinColumn(name = "sort_id"),
            inverseJoinColumns = @JoinColumn(name = "personnages_id"))
    @ToString.Exclude
    private List<Personnage> personnages = new ArrayList<>();

    public Sort(SortHandler handler) {
        this.nom = handler.getNom();
        this.niveau = handler.getNiveau();
        this.ecole = handler.getEcole();
        this.type = handler.getType();
        this.portee = handler.getPortee();
        this.de = handler.getDe();
        this.modif = handler.getModif();
    }
}