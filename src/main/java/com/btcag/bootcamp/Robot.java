package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.btcag.bootcamp.Game.playerCounter;

public class Robot {

    public static List<Robot> robotList = new ArrayList<Robot>();

    String name;
    String nameChar;
    int currentPositionX;
    int currentPositionY;
    Colors color;
    boolean isHuman;

    Robot(String name, String nameChar, int currentPositionX, int currentPositionY, Colors color, boolean isHuman) {
        this.name = name;
        this.nameChar = nameChar;
        this.currentPositionX = currentPositionX;
        this.currentPositionY = currentPositionY;
        this.color = color;
        this.isHuman = isHuman;
    }

    public static void createRobot (Scanner scanner, Battlefield battlefield){
        System.out.println("Gebe Anzahl von Spieler ein: ");
        playerCounter = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < playerCounter; i++ ){
            robotList.add(new Robot("Test", "T", 0, 0, Colors.BLACK, true));
            System.out.print("Gib den neuen Namen für den Roboter " + (i+1) + " ein: ");
            String newName = scanner.nextLine();
            robotList.get(i).setName(newName);
            robotList.get(i).setColor(scanner);
            robotList.get(i).setNameChar(newName);
            robotList.get(i).generateXYPosition(battlefield);
        }
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

    private void generateXYPosition(Battlefield battlefield) {
        this.currentPositionX = ThreadLocalRandom.current().nextInt(0, battlefield.height);
        this.currentPositionY = ThreadLocalRandom.current().nextInt(0, battlefield.width);
    }

    public void setColor(Scanner scanner){
        boolean validInput = false;
        Colors color;
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
                    case 6 -> { this.color = Colors.PURPLE; validInput = true; }
                    case 7 -> { this.color = Colors.CYAN; validInput = true; }
                    default -> System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen 1 und 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }
    }
}
