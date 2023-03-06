package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Espece {
    Sedhars("Sedhars"),
    Dontars("Dontars"),
    Ossars("Ossars"),
    Ethels("Ethels"),
    Dhis_urs("Dhis_urs"),
    Shallagans("Shallagans"),
    Dithers("Dithers"),
    Aiguls("Aiguls"),
    Sondars("Sondars"),
    Humans("Humans"),
    Periandar("Periandar"),
    Fondars("Fondars"),
    Karvurians("Karvurians"),
    Cham_ars("Cham_ars");

    private final String name;

    public static Espece fromName(String name) {
        for (Espece e: Espece.values()) {
            if (e.name.equals(name)){
                return e;
            }
        }
        return null;
    }
}
