package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public void weekPlaning(String status){

    if(status == "Ledig"){
        FiskerTur();
        }else{
            System.out.println("Sitt your As down and do your Java programming assignment. ")
        }
}

public void Fisketur(){

          boolean fishingGear  = checkFishingGear();
          if(fishingGear){
              goOnFishingTrip();
        }
}
