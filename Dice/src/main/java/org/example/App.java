package org.example;

import org.example.Model.Dice;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Dice d3 = Dice.D3;

        System.out.println(d3.Roll());
    }
}
