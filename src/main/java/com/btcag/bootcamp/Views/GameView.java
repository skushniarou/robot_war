package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Robot;

public class GameView {
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

    public static void displayAttackMessage(Robot attacker, Robot target){
        System.out.println(attacker.getName() + " greift " + target.getName() + " an!");
    }

    public static void displayAttackResultMessage(Robot attacker, Robot target, int damage){
        System.out.println(attacker.getName() + " hat " + damage + " Schaden verursacht!");
        System.out.println(target.getName() + " hat nur " + target.getHP() + " HP übrig!");
    }

    public static void displayWinner(String winner){
        System.out.println("Robot " + winner + " ist der letzte Roboter!");
        System.out.println("Robot " + winner + " hat gewonnen!");
    }
}
