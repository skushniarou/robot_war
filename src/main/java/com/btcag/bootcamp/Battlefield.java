package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Battlefield {

    public static Battlefield battlefield = new Battlefield(10,15);
    private final int height;
    private final int width;
    private static String [][] battlefieldArray;

    Battlefield(int height, int width){
        this.height = height;
        this.width = width;
    }

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

    public String[][] getBattlefieldArray() {
        return battlefieldArray;
    }

    public void setBattlefieldArray(String[][] battlefieldArray) {
        Battlefield.battlefieldArray = battlefieldArray;
    }

    static void createBattlefield() {
        String[][] newBattlefield = new String[battlefield.getHeight()][battlefield.getWidth()];
        for (String[] strings : newBattlefield) {
            Arrays.fill(strings, "[ ]");
        }
        battlefield.setBattlefieldArray(newBattlefield);
    }

    //Updates Battlefield on users interface
    public static void updateBattlefield(ArrayList<Robot> robotList) {
        System.out.println();
        for (int i = 0; i < battlefield.getHeight(); i++) {
            for (int j = 0; j < battlefield.getWidth(); j++) {
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
