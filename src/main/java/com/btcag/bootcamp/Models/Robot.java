package com.btcag.bootcamp.Models;

import com.btcag.bootcamp.Enums.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.btcag.bootcamp.Models.Battlefield.battlefield;
import static com.btcag.bootcamp.Services.InputService.userInputInt;

public class Robot {

    //Liste von allen Roboter in Spiel
    public static List<Robot> robotList = new ArrayList<> ();

    private final String name;
    private String nameChar;
    private int x;
    private int y;
    private final Colors color;
    private final boolean isHuman;
    private int HP; //Health Points - If Health Points fall below zero, player will lose
    private int EP; // Energy Points - Needed to use Special Weapons
    private final int AR; // Attack Range - Distance within Robot can Auto-attack
    private final int BD; // Base Damage - Normal Damage that robot deals by attacking
    private int MS; // Movement Speed - Distance how far can robot Move
    private int AS; // Armor Score - Amount of damage reduction
    private float DM; // Damage Modification - Increases amount of sum damage output
    private float AB; // Accuracy Bonus - Increases hit chance of Weapons
    private int AP; // Attributes Points

    public Robot(String name){
        this.name = name;
        this.color = chooseColor();
        setNameChar(name);
        isHuman = true;
        this.HP = 5;
        this.EP = 5;
        this.AR = 3;
        this.BD = 2;
        this.MS = 1;
        this.AS = 0;
        this.DM = 1.0F;
        this.AB = 0.00F;
        this.AP = 100;
    }

    public Robot (int random){
        this.name = "Testroboter Nr." + random ;
        this.color = Colors.BLUE;
        setNameChar(this.name);
        isHuman = false;
        this.HP = 7;
        this.EP = 5;
        this.AR = 1;
        this.BD = 1;
        this.MS = 1;
        this.AS = 0;
        this.DM = 1.0F;
        this.AB = 0.00F;
        this.AP = 0;
    }

    public static List<Robot> getRobotList() {
        return robotList;
    }

    public static int getRobotListSize(){
        return robotList.size();
    }

    public String getName (){
        return name;
    }

    public String getNameChar () {
        return nameChar;
    }

    public int getPositionX () {
        return x;
    }

    public int getPositionY () {
        return y;
    }

    public Colors getColor (){
        return color;
    }

    public boolean getIsHuman (){
        return isHuman;
    }

    public int getHP (){
        return HP;
    }

    public int getEP (){
        return EP;
    }

    public int getAR() {
        return AR;
    }

    public int getBD() {
        return BD;
    }

    public int getMS (){
        return MS;
    }

    public int getAS (){
        return AS;
    }

    public float getDM (){
        return DM;
    }

    public float getAB (){
        return AB;
    }

    public int getAP (){
        return AP;
    }

    public void setPositionX(int x) {
        this.x = x;
    }

    public void setPositionY(int y) {
        this.y = y;
    }

    public void setNameChar (String name){
        this.nameChar = color.getAnsiCode() + name.charAt(0) + Colors.resetColor();
    }

    public void setHP (int HP){
        this.HP = HP;
    }

    public void setEP (int EP){
        this.EP = EP;
    }

    public void setMS (int MS){
        this.MS = MS;
    }

    public void setAS (int AS){
        this.AS = AS;
    }

    public void setDM (float DM){
        this.DM = DM;
    }

    public void setAB (float AB){
        this.AB = AB;
    }

    public void setAP (int AP){
        this.AP = AP;
    }

    public Colors chooseColor(){
        boolean validInput = false;
        while (!validInput) {
            int input;
            try {
                input = userInputInt("Wähle bitte Farbe von deinem Roboter? 1 - BLACK, 2 - RED, 3 - GREEN, 4 - YELLOW, 5 - BLUE, 6 - PURPLE, 7 - CYAN: ");
                switch (input) {
                    case 1 -> {validInput = true; return Colors.BLACK;  }
                    case 2 -> {validInput = true; return Colors.RED;}
                    case 3 -> {validInput = true; return Colors.GREEN; }
                    case 4 -> {validInput = true; return Colors.YELLOW; }
                    case 5 -> {validInput = true; return Colors.BLUE; }
                    case 6 -> {validInput = true; return Colors.PURPLE; }
                    case 7 -> {validInput = true; return Colors.CYAN; }
                    default -> System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }
        return null;
    }

    //Setzt neue Positionen von Roboter auf dem Battlefield
    public static void setNewRobotPositions (ArrayList<Robot> robotList){
        for (Robot robot : robotList) {
            int x = robot.getPositionX();
            int y = robot.getPositionY();

            // Wenn Koordinaten mit Roboter stimmen, ersetze Zelle mit Roboter-Char
            if (y >= 0 && y < battlefield.getHeight() && x >= 0 && x < battlefield.getWidth()) {
                Battlefield.battlefieldArray[y][x] = "[" + robot.getNameChar() + "]";
            }
        }
    }

    public void generateXYPosition(String [][] battlefieldArray) {
        this.x = ThreadLocalRandom.current().nextInt(0, battlefieldArray[0].length);
        this.y = ThreadLocalRandom.current().nextInt(0, battlefieldArray.length);
    }

    public void displayXYPosition(Robot robot){
        System.out.println(robot.getName() + " hat sich nach Position [" + robot.getPositionX() + "," + robot.getPositionY() + "] bewegt.");
        System.out.println();
    }
}
