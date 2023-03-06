package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeEquipement {
    EQUIPEMENT("EQUIPEMENT"),
    ARMEMENT("ARMEMENT"),
    PROTECTION("PROTECTION"),
    POTION("POTION"),
    MAGIQUE("MAGIQUE");

    private final String name;
    public static TypeEquipement fromName(String name){
        for (TypeEquipement t: TypeEquipement.values()) {
            if (t.name.equals(name)){
                return t;
            }
        }
        return null;
    }

}
