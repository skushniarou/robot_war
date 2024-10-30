package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;

public class Battlefield {

    private final int height;
    private final int width;
    public static String [][] battlefieldArray;

    Battlefield(int height, int width){
        this.height = height;
        this.width = width;
        battlefieldArray = new String[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    static Battlefield createBattlefield(Battlefield battlefield) {
        String[][] newBattlefield = new String[battlefield.height][battlefield.width];
        for (String[] strings : newBattlefield) {
            Arrays.fill(strings, "[ ]");
        }
        battlefield.battlefieldArray = newBattlefield;
        return battlefield;
    }

    //Updates Battlefield on users interface
    public static void updateBattlefield(Battlefield battlefield,  ArrayList<Robot> robotList) {
        System.out.println();
        for (int i = 0; i < battlefield.height; i++) {
            for (int j = 0; j < battlefield.width; j++) {
                boolean robotFound = false;
                for (Robot robot : robotList) {
                    if (i == robot.getPositionX() && j == robot.getPositionY()) {
                        System.out.print("[" + robot.getNameChar() + "] ");
                        robotFound = true;
                        break;
                    }
                }
                if (!robotFound) {
                    System.out.print(battlefield.battlefieldArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
