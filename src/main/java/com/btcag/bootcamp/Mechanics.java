package com.btcag.bootcamp;

import java.util.*;

import static com.btcag.bootcamp.Game.gameOver;
import static com.btcag.bootcamp.Game.playersTurn;

public class Mechanics {

    //Spieler wird abgefragt was er machen will
    public static void playerTurn(Scanner scanner, Character player, Battlefield battlefield) {
        String choice;
        while (playersTurn) { // ToDo: regex oder turnStatus
            System.out.println();
            System.out.println("""
                    Du hasst folgende Aktionen: Welche willst du auswählen?\s
                    1 = Bewegen
                    2 = Angreifen
                    3 = Warten
                    4 = Aufgeben""");
            choice = scanner.nextLine();
            label:
            if (choice.matches("[1234]+")) {
                switch (choice) {
                    case "1":
                        playerMove(scanner, player,battlefield);
                        playersTurn = false;
                        break label;
                    case "2":
                        // Angreifen
                        break label;
                    case "3":
                        //Warten
                        playersTurn = false;
                        break label;
                    case "4":
                        gameOver = false;
                        playersTurn = false;
                        System.out.println("Du hasst kein Kraft mehr... Leider in diese Kampf hasst du verloren");
                        break label;
                }
            } else {
                System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
            }
        }
    }

    //Opponent decides what to do on his turn
    static void aiTurn(Character opponent, Battlefield battlefield) {
        aiMove(opponent,battlefield);
        playersTurn = true;
    }

    //Function to move object on battlefield and check viability of this move
    public static void playerMove(Scanner scanner, Character player, Battlefield battlefield) {
        String move = "";
        boolean check = false;
        while (!check) {
            System.out.println("""
        In welche Richtung möchtest du dich bewegen?\s
        w = oben
        a = links
        s = unten
        d = rechts""");
        move = scanner.nextLine();

            while(!check){
                if(move.matches("[wasdWASD]+")){
                    if (move.equals("w") || move.equals("W")) {
                        if (player.getPositionX() > 0) {
                            player.currentPositionX -= 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach oben.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    } else if (move.equals("d") || move.equals("D")) {
                        if (player.getPositionY() < battlefield.width-1) {
                            player.currentPositionY += 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach rechts.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    } else if (move.equals("s") || move.equals("S")) {
                        if (player.getPositionX() < battlefield.height-1) {
                            player.currentPositionX += 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach unten.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    } else if (move.equals("a") || move.equals("A")) {
                        if (player.getPositionY() > 0) {
                            player.currentPositionY -= 1;
                            check = true;
                        } else {
                            System.out.println("Das Spielfeld geht nicht weiter nach links.\nWähle eine andere Richtung.");
                            move = scanner.nextLine();
                        }
                    }
                } else {
                    System.out.println("Falsche Eingabe!");
                    break;
                }
            }
        }
    }

    public static void aiMove(Character opponent, Battlefield battlefield) {
        Random random = new Random();
        List<Integer> availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // 1 - w - Oben; 2 - a - Links; 3 -  s - Unten; 4 - d - Rechts
        // ToDo: playField auf high/width umstellen
        if (opponent.getPositionY() + 1 > battlefield.width-1) { // Prüfung auf "d"
            availableMoves.remove((Integer) 4);
        }
        if (opponent.getPositionY() - 1 < 0) { // Prüfung auf "s"
            availableMoves.remove((Integer) 3);
        }
        if (opponent.getPositionX() + 1 > battlefield.height-1) { // Prüfung auf "a"
            availableMoves.remove((Integer) 2);
        }
        if (opponent.getPositionX() - 1 < 0) { // Prüfung auf "w"
            availableMoves.remove((Integer) 1);
        }
        int randomIndex = random.nextInt(availableMoves.size());
        int randomNumber = availableMoves.get(randomIndex);
        if (randomNumber == 1){
            opponent.currentPositionX -= 1;
        } else if (randomNumber == 2) {
            opponent.currentPositionX += 1;
        } else if (randomNumber == 3) {
            opponent.currentPositionY -= 1;
        } else if (randomNumber == 4) {
            opponent.currentPositionY += 1;
        }
    }
}