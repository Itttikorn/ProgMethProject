package Util;

import java.util.Random;

public enum Block {
    DIRT,
    WATER,
    GRASS;

    public static Block randomBlock() {
        ////////////////        generate block         ////////////////
        //////////////// WATER 10% GRASS 30% floor 60% ////////////////
        int randIndex = new Random().nextInt(10);
        return randIndex > 1 ? randIndex > 4 ? Block.DIRT : Block.GRASS : Block.WATER;
    }
}
