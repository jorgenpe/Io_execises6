package org.example.Model;

import java.util.concurrent.ThreadLocalRandom;

public enum Dice {
    D3( 3),
    d4(4),
    D6(6),
    d8( 8),
    D10( 10),
    d12( 12),
    D20(20),
    D100(100);

    private final int maxRoll;
    private Dice(int maxRoll ){

        this.maxRoll = maxRoll;
    }

    public int Roll(){

        return ThreadLocalRandom.current().nextInt(maxRoll) + 1;

    }


}
