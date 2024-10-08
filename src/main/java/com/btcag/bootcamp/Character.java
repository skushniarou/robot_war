package com.btcag.bootcamp;

public class Character {

    String name;
    String nameChar;
    int currentPositionX;
    int currentPositionY;

    Character() {
        name = "Test";
        nameChar = "T";
        currentPositionX = 0;
        currentPositionY = 0;
    }

    Character(String initialName, String initialNameChar, int initialPositionX, int initialPositionY) {
        name = initialName;
        nameChar = initialNameChar;
        currentPositionX = initialPositionX;
        currentPositionY = initialPositionY;
    }

    String getName (){
        return name;
    }

    String getChar () {
        return nameChar;
    }

    int getPositionX() {
        return currentPositionX;
    }

    int getPositionY() {
        return currentPositionY;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setNameChar (String nameChar){
        this.nameChar = nameChar + " ";
    }

    public void setCurrentPosition (int currentPositionX, int currentPositionY){
        this.currentPositionX = currentPositionX;
        this.currentPositionY = currentPositionY;
    }
}
