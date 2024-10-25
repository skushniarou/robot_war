package com.btcag.bootcamp;

public class Battlefield {

    public int height;
    public int width;
    public static String [][] battlefieldArray;

    Battlefield() {
        height = 0;
        width = 0;
        battlefieldArray = new String[height][width];
    }

    Battlefield(int height, int width){
        this.height = height;
        this.width = width;
        battlefieldArray = new String[height][width];
    }

    static Battlefield createBattlefield(Battlefield battlefield) {
        String[][] newBattlefield = new String[battlefield.height][battlefield.width];
        for (int i = 0; i < newBattlefield.length; i++) {
            for (int j = 0; j < newBattlefield[i].length; j++) {
                newBattlefield[i][j] = "[ ]";
            }
        }
        battlefield.battlefieldArray = newBattlefield;
        return battlefield;
    }

    //Updates Battlefield on users interface
    public static void updateBattlefield(Battlefield battlefield, Character player, Character opponent) {
        System.out.println();
        for (int i = 0; i < battlefield.height; i++) {
            for (int j = 0; j < battlefield.width; j++) {
                if (i == player.getPositionX() && j == player.getPositionY()) {
                    System.out.print(player.color.getAnsiCode() + player.getChar() + Colors.resetColor());
                } else if (i == opponent.getPositionX() && j == opponent.getPositionY()) {
                    System.out.print(opponent.color.getAnsiCode() + opponent.getChar() + Colors.resetColor());
                } else {
                    System.out.print(battlefield.battlefieldArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
