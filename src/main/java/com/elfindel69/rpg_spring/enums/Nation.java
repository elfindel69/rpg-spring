package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Nation {
    Ossarion("Ossarion"),
    Chalitis("Chalitis"),
    Uvov("Uvov"),
    Rivoth("Rivoth"),
    Arkilia("Arkilia"),
    Cillon("Cillon"),
    Nithelea("Nithelea"),
    Keitheas("Keitheas"),
    Vanov("Vanov"),
    Silellon("Silellon"),
    Galata("Galata"),
    Setera("Setera"),
    Carilla("Carilla"),
    Ethea("Ethea"),
    Nuetis("Nuetis"),
    Ievis("Ievis"),
    Thrandingar("Thrandingar"),
    Treiliv("Treiliv"),
    Eria("Eria"),
    Ninda("Ninda"),
    Zolla("Zolla"),
    Garus("Garus"),
    TF("TF"),
    Kraat("Kraat"),
    Loc("Loc"),
    Drix("Drix"),
    Shao("Shao"),
    Dauxur("Dauxur"),
    Hox("Hox"),
    Plaol("Plaol");
    private final String name;

    public static Nation fromName(String name) {
        for (Nation n: Nation.values()) {
            if (n.name.equals(name)){
                return n;
            }
        }
        return null;
    }
}
