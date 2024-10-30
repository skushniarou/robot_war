package com.btcag.bootcamp;

import java.util.ArrayList;

public class Battlefield {

    private int height;
    private int width;
    public static String [][] battlefieldArray;

    Battlefield() {
        height = 0;
        width = 0;
        battlefieldArray = new String[height][width];
    }

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
        for (int i = 0; i < newBattlefield.length; i++) {
            for (int j = 0; j < newBattlefield[i].length; j++) {
                newBattlefield[i][j] = "[ ]";
            }
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
                        System.out.print(robot.getNameChar() + " ");
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
