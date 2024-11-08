package com.btcag.bootcamp.Models;

public class Battlefield {

    public static Battlefield battlefield = new Battlefield(15,10);
    private final int width;
    private final int height;
    private static String [][] battlefieldArray;

    Battlefield(int width, int height){
        this.width = width;
        this.height = height;
        battlefieldArray = new String[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBattlefieldArray() {
        return battlefieldArray;
    }

    public void setBattlefieldArray(String[][] battlefieldArray) {
        Battlefield.battlefieldArray = battlefieldArray;
    }

}
