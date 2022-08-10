package com.i2i;

import java.util.Random;

public class MSISDNGenerator {
    Random rand;

    MSISDNGenerator(){
        rand = new Random();
    }
    public String getMsisdn(){
        String msisdn = "0";
        for(int i = 0; i < 10; i++){
            msisdn = msisdn + rand.nextInt(10);
        }
        return msisdn;
    }
}
