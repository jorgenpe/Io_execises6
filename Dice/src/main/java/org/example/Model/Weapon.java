package org.example.Model;

import java.util.List;

public class Weapon {

    private String name;
    private List<Dice> damageDices;
    private int modifier;


    public Weapon(String name, List<Dice> damageDices, int modifier){
        this.name = name;
        this.damageDices = damageDices;
        this.modifier = modifier;
    }

}
