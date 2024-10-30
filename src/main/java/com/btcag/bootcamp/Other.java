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

    public static int userInputInt(String text){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(text);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte eine ganze Zahl eingeben.");
            }
        }
    }

    public static String userInputStr(String text) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(text);
            try {
                return scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte neu eingeben.");
            }
        }
    }
}
