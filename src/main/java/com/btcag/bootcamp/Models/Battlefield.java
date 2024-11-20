package com.btcag.bootcamp.Models;

import com.btcag.bootcamp.Controls.BattlefieldController;

public class Battlefield {

    private static int width;
    private static int height;
    protected static String [][] battlefieldArray;

    public Battlefield(int width, int height){
        Battlefield.width = width;
        Battlefield.height = height;
        battlefieldArray = new String[width][height];
    }

    public static Battlefield getBattlefield () {
        return BattlefieldController.battlefield;
    }

    public static void setBattlefield (Battlefield battlefield) {
        BattlefieldController.battlefield = battlefield;
    }

    public static int getWidth () {
        return Battlefield.width;
    }

    public static int getHeight () {
        return Battlefield.height;
    }

    public static String[][] getBattlefieldArray () {
        return battlefieldArray;
    }

    public static void setBattlefieldArray (String[][] battlefieldArray) {
        Battlefield.battlefieldArray = battlefieldArray;
    }

}
