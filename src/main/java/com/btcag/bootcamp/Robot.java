package com.btcag.bootcamp;

import java.util.Scanner;

public class Robot {

    String name;
    String nameChar;
    int currentPositionX;
    int currentPositionY;
    Colors color;
    boolean human;

    Robot(String initialName, String initialNameChar, int initialPositionX, int initialPositionY, Colors initColor, boolean initHuman) {
        name = initialName;
        nameChar = initialNameChar;
        currentPositionX = initialPositionX;
        currentPositionY = initialPositionY;
        color = initColor;
        human = initHuman;
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
            6 - CYAN
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
                    default -> System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }
    }
}
