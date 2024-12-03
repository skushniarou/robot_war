package com.btcag.bootcamp.Services;

import com.btcag.bootcamp.Views.OtherView;

import java.util.Scanner;

public class InputService {

    public static int userInputInt(String text){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(text);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                OtherView.displayInvalidInputInt();
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
                OtherView.displayInvalidInputOverall();
            }
        }
    }
}
