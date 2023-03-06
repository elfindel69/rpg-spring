package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeSort {
    CONE("CONE"),
    TRAIT("TRAIT"),
    ZONE("ZONE"),
    CIBLE("CIBLE");
    private final String name;

    public static TypeSort fromName(final String name){
        for (TypeSort ts : TypeSort.values()) {
            if(ts.name.equals(name)){
                return ts;
            }
        }
        return null;
    }

}
