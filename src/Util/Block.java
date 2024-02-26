package Util;

import java.util.Random;

public enum Block {
    Dirt,
    Water,
    Grass;

    public static Block randomBlock() {
        ////////////////        generate block         ////////////////
        //////////////// water 10% grass 30% floor 60% ////////////////
        int randIndex = new Random().nextInt(10);
        return randIndex > 1 ? randIndex > 4 ? Block.Dirt : Block.Grass : Block.Water;
    }
}
