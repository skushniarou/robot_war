package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.btcag.bootcamp.Game.createRobot;

public class Battlefield {

    public static Battlefield battlefield = new Battlefield(2,2);
    private final int height;
    private final int width;
    private static String [][] battlefieldArray;

    Battlefield(int height, int width){
        this.height = height;
        this.width = width;
    }

    Battlefield(){
        Random random = new Random();
        this.height = random.nextInt(10);
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

    public boolean hasObjectAt(int x, int y) {
        if (getBattlefieldArray() == null
                || x < 0 || x >= getBattlefieldArray().length
                || y < 0 || y >= getBattlefieldArray()[0].length) {
            return false; // Außerhalb des Spielfelds: Kein Objekt vorhanden
        }
        return !battlefieldArray[x][y].equals("[ ]");
    }

    static void createGameComponents(){
        String[][] newBattlefield = new String[battlefield.getHeight()][battlefield.getWidth()];
        createClearBattlefield(newBattlefield);
        createRobot();
    }

    static void createClearBattlefield(String[][] newBattlefield) {
        for (String[] strings : newBattlefield) {
            Arrays.fill(strings, "[ ]");
        }
        battlefield.setBattlefieldArray(newBattlefield);
    }

    //Updates Battlefield on users interface
    public static void updateBattlefield(ArrayList<Robot> robotList) {
        String[][] battlefieldArray = battlefield.getBattlefieldArray();
        createClearBattlefield(battlefieldArray);

        System.out.println();
        for (Robot robot : robotList) {
            int x = robot.getPositionX();
            int y = robot.getPositionY();

            // Wenn Koordinaten mit Roboter stimmen, ersetze Zelle mit Roboter-Char
            if (y >= 0 && y < battlefield.getHeight() && x >= 0 && x < battlefield.getWidth()) {
                battlefieldArray[y][x] = "[" + robot.getNameChar() + "]";
            }
        }

        // Spielfeld auf der Konsole anzeigen
        for (int i = 0; i < battlefield.getHeight(); i++) {
            for (int j = 0; j < battlefield.getWidth(); j++) {
                System.out.print(battlefieldArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
