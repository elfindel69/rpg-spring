package com.elfindel69.rpg_spring.utils;

import java.util.concurrent.ThreadLocalRandom;

public class MyRandom {
    private int min;
    private int max;

    public MyRandom(int var1, int var2) {
        this.min = var1;
        this.max = var2;
    }

    public int randomize() {
        int res = ThreadLocalRandom.current().nextInt(this.min, this.max + 1);
        return res;
    }

}
