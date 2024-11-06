package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;

import static com.btcag.bootcamp.Game.createRobot;

public class Battlefield {

    public static Battlefield battlefield = new Battlefield(3,5);
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

    public boolean notValidMove(int x, int y) {
        String[][] battlefieldArray = battlefield.getBattlefieldArray();
        return x < 0 || x >= getWidth()
                || y < 0 || y >= getHeight()
                || !battlefieldArray[y][x].equals("[ ]");
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

    //Setzt neue Positionen von Roboter auf dem Battlefield
    static void setNewRobotPositions(ArrayList<Robot> robotList){
        for (Robot robot : robotList) {
            int x = robot.getPositionX();
            int y = robot.getPositionY();

            // Wenn Koordinaten mit Roboter stimmen, ersetze Zelle mit Roboter-Char
            if (y >= 0 && y < battlefield.getHeight() && x >= 0 && x < battlefield.getWidth()) {
                battlefieldArray[y][x] = "[" + robot.getNameChar() + "]";
            }
        }
    }

    //Updates Battlefield on users interface
    public static void updateBattlefield(ArrayList<Robot> robotList) {
        String[][] battlefieldArray = battlefield.getBattlefieldArray();

        createClearBattlefield(battlefieldArray);
        setNewRobotPositions(robotList);

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
