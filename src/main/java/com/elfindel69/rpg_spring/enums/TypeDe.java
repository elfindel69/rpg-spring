package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeDe {
    DE_4(4),
    DE_6(6),
    DE_8(8),
    DE_10(10),
    DE_12(12),
    DE_20(20),
    DE_100(100);
    private final int value;

    public static TypeDe fromValue(int value){
        for (TypeDe de: TypeDe.values()) {
           if(de.value == value) {
               return de;
           }
        }
        return null;
    }
}
