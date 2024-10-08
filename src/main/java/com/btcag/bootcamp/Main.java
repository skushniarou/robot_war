package com.btcag.bootcamp;

import java.util.Scanner;

import static com.btcag.bootcamp.Mechanics.playerMove;

public class Main {
    public static void main(String[] args) {

        //Constructor
        Character player = new Character("Abba","A",0,0);
        Character opponent = new Character("Test","T",9,14);
        Scanner scanner = new Scanner(System.in);

        //Intro
        introduction();

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

        while (true) {
            updatePlayfield(spielFeld,player,opponent);
            playerTurn(scanner,player);
            enemyTurn();
            checkWinCondition();
        }
    }

    private static void checkWinCondition() {
        //do smth
    }

    private static void enemyTurn() {
        //do smth
    }

    public static void playerTurn(Scanner scanner, Character player) {
        String choise = "";
        boolean check = false;
        while (!check) {
            System.out.println();
            System.out.println("""
                    Du hasst folgende Aktionen: Welche willst du auswählen?\s
                    1 = Bewegen
                    2 = Angreifen
                    3 = Aufgeben""");
            choise = scanner.nextLine();
            while(true){
                if (choise.matches("[123]+")) {
                    if (choise.equals("1")) {
                        playerMove(scanner, player);
                        check = true;
                        break;
                    }
                    else if (choise.equals("2")) {
                        // Angreifen
                        break;
                    }
                    else if (choise.equals("3")) {
                        // Aufgeben
                        break;
                    }
                }   else {
                    System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
                    break;
                }
            }
        }
    }



    private static String getFirstChar (String name) {
        return "[" + name.charAt(0) + "]";
    }

    public static void updatePlayfield (String [][] spielFeld, Character player, Character opponent) {
        System.out.println();
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                if ( i == player.getPositionX() && j == player.getPositionY()) {
                    System.out.print(player.getChar());
                } else if ( i == opponent.getPositionX() && j == opponent.getPositionY()) {
                    System.out.print(opponent.getChar());
                } else {
                    System.out.print(spielFeld[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void introduction() {
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
    }
}