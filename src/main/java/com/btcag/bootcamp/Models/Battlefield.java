package com.btcag.bootcamp.Models;

public class Battlefield {

    public static Battlefield battlefield = new Battlefield(15,10);
    private static int width;
    private static int height;
    protected static String [][] battlefieldArray;

    Battlefield(int width, int height){
        this.width = width;
        this.height = height;
        battlefieldArray = new String[width][height];
    }

    public static Battlefield getBattlefield () {
        return battlefield;
    }

    public static void setBattlefield (Battlefield battlefield) {
        Battlefield.battlefield = battlefield;
    }

    public static int getWidth () {
        return battlefield.width;
    }

    public static int getHeight () {
        return battlefield.height;
    }

    public static String[][] getBattlefieldArray () {
        return battlefieldArray;
    }

    public static void setBattlefieldArray (String[][] battlefieldArray) {
        Battlefield.battlefieldArray = battlefieldArray;
    }

}
