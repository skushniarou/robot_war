package com.btcag.bootcamp;

import java.awt.*;
import java.util.Scanner;

import static com.btcag.bootcamp.Colors.*;
import static com.btcag.bootcamp.Other.setFirstChar;

public class Character {

    String name;
    String nameChar;
    int currentPositionX;
    int currentPositionY;
    Colors color;

    Character() {
        name = "Test";
        nameChar = "T";
        currentPositionX = 0;
        currentPositionY = 0;
        color = BLACK;
    }

    Character(String initialName, String initialNameChar, int initialPositionX, int initialPositionY, Colors initColor) {
        name = initialName;
        nameChar = initialNameChar;
        currentPositionX = initialPositionX;
        currentPositionY = initialPositionY;
        color = initColor;
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

    public void setNameChar (String charName){
        this.nameChar = "[" + color.getAnsiCode() + charName.charAt(0) + Colors.resetColor() + "]";
    }

    public void setColor(Scanner scanner){
        boolean validInput = false;

        while (!validInput) {
            System.out.println("""
            Wählen Sie eine Farbe:
            1 - BLACK
            2 - RED
            3 - GREEN
            4 - YELLOW
            5 - BLUE
            6 - PURPLE
            7 - CYAN
            8 - WHITE
            Ihre Wahl: """);

            int input;
            try {
                input = Integer.parseInt(scanner.nextLine());

                switch (input) {
                    case 1 -> { this.color = Colors.BLACK; validInput = true; }
                    case 2 -> { this.color = Colors.RED; validInput = true; }
                    case 3 -> { this.color = Colors.GREEN; validInput = true; }
                    case 4 -> { this.color = Colors.YELLOW; validInput = true; }
                    case 5 -> { this.color = Colors.BLUE; validInput = true; }
                    case 6 -> { this.color = Colors.CYAN; validInput = true; }
                    case 7 -> { this.color = Colors.WHITE; validInput = true; }
                    default -> System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }
    }
}
