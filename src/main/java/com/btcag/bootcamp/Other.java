package com.btcag.bootcamp;

import java.util.Scanner;

public class Other {

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

    public static void getCharactersNames(Scanner scanner, Character player, Character opponent){
        //Name von Spieler setzen
        System.out.println("Wie heißt dein Roboter?: ");
        player.setName(scanner.nextLine());
        System.out.println();
        //Name von Opponent setzen
        System.out.println("Und wie heißt dein Gegner?: ");
        opponent.setName(scanner.nextLine());
        System.out.println();

        System.out.println("Cool. " + player.getName() + " ist bereit für ein Kampf!");
    }

    // Gets first Character of Opponent and Player
    // ToDo: Zwei verschiedene Funktionen machen
    public static void getCharactersSymbol(Character player, Character opponent){
        player.setNameChar(setFirstChar(player.getName()));
        opponent.setNameChar(setFirstChar(opponent.getName()));
    }

    //Saves first Character of Players/Opponents Name
    public static String setFirstChar(String name) {
        return "[" + name.charAt(0) + "]";
    }
}
