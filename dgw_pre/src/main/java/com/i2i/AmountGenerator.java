package com.i2i;

import java.util.Random;

public class AmountGenerator {

    Random rand;

    AmountGenerator(){
        rand = new Random();
    }
    public int getAmount(){
        return rand.nextInt(120);
    }
}
