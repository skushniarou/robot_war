package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Battlefield {

    private final int height;
    private final int width;
    private static String [][] battlefieldArray;

    Battlefield(){
        Random random = new Random();
        this.height = random.nextInt(15);
        this.width = random.nextInt(15);
        battlefieldArray = new String[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public static String[][] getBattlefieldArray() {
        return battlefieldArray;
    }

    public static void setBattlefieldArray(String[][] battlefieldArray) {
        Battlefield.battlefieldArray = battlefieldArray;
    }

    static void createBattlefield() {
        Battlefield battlefield = new Battlefield();
        String[][] newBattlefield = new String[battlefield.height][battlefield.width];
        for (String[] strings : newBattlefield) {
            Arrays.fill(strings, "[ ]");
        }
        battlefieldArray = newBattlefield;
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
                    System.out.print(battlefieldArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
