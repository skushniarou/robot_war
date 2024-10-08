package com.btcag.bootcamp;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Character player = new Character("Abba","A",0,0);
        Character opponent = new Character("Test","T",9,14);

        //Variablen
        Scanner scanner = new Scanner(System.in);
        String spielerName = "";
        String gegnerName = "";

        //Intro
        System.out.println("Welcome to Robot Wars!");
        System.out.println("        _____            ");
        System.out.println("       /     \\          ");
        System.out.println("      | () () |         ");
        System.out.println("      |  |_|  |         ");
        System.out.println("      |  (_)  |         ");
        System.out.println("      |_______|         ");
        System.out.println("     /  / _ \\  \\       ");
        System.out.println("    /  / (_) \\  \\      ");
        System.out.println("   |  |       |  |     ");
        System.out.println("  /|  |_______|  |\\    ");
        System.out.println(" / |  |       |  | \\   ");
        System.out.println("/__|__|_______|__|__\\  ");
        System.out.println("   /_/         \\_\\     ");
        System.out.println();

        System.out.println("In einer Zukunft, in der Maschinen die Arenen beherrschen, übernimmst du die Kontrolle über einen mächtigen Kampfroboter.\n" +
                "Ausgestattet mit scharfen Klingen, schweren Geschützen und unzerstörbaren Panzerplatten, trittst du gegen andere stählerne Krieger an.\n" +
                "\n" +
                "Dein Ziel? Den Gegner in Einzelteile zu zerlegen – bis zur letzten Schraube! Jeder Kampf ist ein Test deiner Reflexe, deiner Strategie und deiner Entschlossenheit.\n"+
                "Dein Roboter wird nicht aufgeben, solange du an den Steuerhebeln sitzt. \n" +
                "Bist du bereit für die ultimative Schlacht? Die Arena wartet auf dich!");
        System.out.println();

        //Namen setzen von Spieler und Opponent
        System.out.println("Wie heißt dein Roboter?: ");
        player.setName(scanner.nextLine());
        System.out.println();

        System.out.println("Und wie heißt dein Gegner..?: ");
        opponent.setName(scanner.nextLine());
        System.out.println();

        System.out.println("Cool. " + player.getName() + " ist bereit für ein Kampf!");

        //Erste Buchstabe von Name bekommen
        player.setNameChar(getFirstChar(player.getName()));
        opponent.setNameChar(getFirstChar(opponent.getName()));

        //Spielfeld generieren
        String [][] spielFeld = new String [10][15];
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                spielFeld[i][j] = "[ ]";
            }
        }

        //Startposition
        spielFeld[player.getPositionX()][player.getPositionY()]  = player.getChar();
        spielFeld[opponent.getPositionX()][opponent.getPositionY()]  = opponent.getChar();

        while (true) {
            updatePlayfield(spielFeld);
            playerTurn();
            enemyTurn();
            checkWinCondition();
            break;
        }
    }

    private static void checkWinCondition() {
        //do smth
    }

    private static void enemyTurn() {
        //do smth
    }

    private static void playerTurn() {
        //do something
    }

    private static String getFirstChar (String name) {
        return "[" + name.charAt(0) + "]";
    }

    public static void updatePlayfield (String [][] spielFeld) {
        System.out.println();
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                System.out.print(spielFeld[i][j] + " ");
            }
            System.out.println();
        }
    }
}