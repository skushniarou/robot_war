package com.btcag.bootcamp;

import java.util.concurrent.ThreadLocalRandom;

import static com.btcag.bootcamp.Other.*;

public class Robot {

    private final String name;
    private String nameChar;
    private int currentPositionX;
    private int currentPositionY;
    private final Colors color;
    private final boolean isHuman;
    private int HP; //Health Points - If Health Points fall below zero, player will lose
    private int EP; // Energy Points - Needed to use Special Weapons
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
        this.HP = 20;
        this.EP = 5;
        this.MS = 1;
        this.AS = 0;
        this.DM = 1.0F;
        this.AB = 0.00F;
        this.AP = 100;
    }

    public int getCurrentPositionY() {
        return currentPositionY;
    }

    public void setCurrentPositionY(int currentPositionY) {
        this.currentPositionY = currentPositionY;
    }

    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public void setCurrentPositionX(int currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    String getName (){
        return name;
    }

    String getNameChar () {
        return nameChar;
    }

    int getPositionX() {
        return currentPositionX;
    }

    int getPositionY() {
        return currentPositionY;
    }

    Colors getColor(){
        return color;
    }

    boolean getIsHuman(){
        return isHuman;
    }

    int getHP (){
        return HP;
    }

    int getEP (){
        return EP;
    }

    int getMS (){
        return MS;
    }

    int getAS (){
        return AS;
    }

    float getDM (){
        return DM;
    }

    float getAB (){
        return AB;
    }

    int getAP (){
        return AP;
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

    public void generateXYPosition(String [][] battlefieldArray) {
        this.currentPositionX = ThreadLocalRandom.current().nextInt(0, battlefieldArray.length);
        this.currentPositionY = ThreadLocalRandom.current().nextInt(0, battlefieldArray[0].length);
    }
}
