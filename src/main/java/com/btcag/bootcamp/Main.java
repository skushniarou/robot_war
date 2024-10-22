package com.btcag.bootcamp;

import java.util.Scanner;

import static com.btcag.bootcamp.Mechanics.playerMove;

public class Main {
    public static boolean gameStatus = true;
    public static boolean turnStatus = true;

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

        //Erster Buchstabe von Name bekommen
        player.setNameChar(getFirstChar(player.getName()));
        opponent.setNameChar(getFirstChar(opponent.getName()));

        //Spielfeld generieren
        String [][] spielFeld = new String [10][15];
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++) {
                spielFeld[i][j] = "[ ]";
            }
        }

        //Game turn order
        while (gameStatus) {
            updatePlayfield(spielFeld,player,opponent);
            playerTurn(scanner,player);
            enemyTurn();
            checkWinCondition(player,opponent);
        }
    }

    //Checks if player or opponent wins the game
    private static void checkWinCondition(Character player, Character opponent) {
        if (player.getPositionX() == opponent.getPositionX() && player.getPositionY() == opponent.getPositionY()){
            System.out.println("Endlich! Du hasst " + opponent.getName() + " gewonnen.");
            gameStatus = false;
        }
        if (opponent.getPositionX() == player.getPositionX() && opponent.getPositionY() == player.getPositionY()){
            System.out.println("Leider dein Gegner " + opponent.getName() + " war stärker... für dieses mal");
            gameStatus = false;
        }
    }

    //Enemy player decides what to do on his turn
    private static void enemyTurn() {
        //do smth
    }

    //Spieler wird abgefragt was er machen will
    public static void playerTurn(Scanner scanner, Character player) {
        String choise;
        turnStatus = true;
        while (turnStatus) {
            System.out.println();
            System.out.println("""
                    Du hasst folgende Aktionen: Welche willst du auswählen?\s
                    1 = Bewegen
                    2 = Angreifen
                    3 = Aufgeben""");
            choise = scanner.nextLine();
            label:
            while(true){
                if (choise.matches("[123]+")) {
                    switch (choise) {
                        case "1":
                            playerMove(scanner, player);
                            turnStatus = false;
                            break label;
                        case "2":
                            // Angreifen
                            break label;
                        case "3":
                            gameStatus = false;
                            turnStatus = false;
                            System.out.println("Du hasst kein Kraft mehr... Leider in diese Kampf hasst du verloren");
                            break label;
                    }
                }   else {
                    System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
                    break;
                }
            }
        }
    }

    //Saves first Character of Players/Opponents Name
    private static String getFirstChar (String name) {
        return "[" + name.charAt(0) + "]";
    }

    //Updates Playfield on users interface
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

    //Introduction at the start of this game
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

        System.out.println("""
                In einer Zukunft, in der Maschinen die Arenen beherrschen, übernimmst du die Kontrolle über einen mächtigen Kampfroboter.
                Ausgestattet mit scharfen Klingen, schweren Geschützen und unzerstörbaren Panzerplatten, trittst du gegen andere stählerne Krieger an.
                
                Dein Ziel? Den Gegner in Einzelteile zu zerlegen – bis zur letzten Schraube! Jeder Kampf ist ein Test deiner Reflexe, deiner Strategie und deiner Entschlossenheit.
                Dein Roboter wird nicht aufgeben, solange du an den Steuerhebeln sitzt.\s
                Bist du bereit für die ultimative Schlacht? Die Arena wartet auf dich!""");
        System.out.println();
    }
}