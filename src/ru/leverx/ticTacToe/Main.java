package ru.leverx.ticTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the tic-tac-toe game!");

        boolean run = true;
        while (run){
            System.out.println("Select the option of the game:\n" +
                                "1. Person vs Person;\n" +
                                "2. Person vs AI;\n" +
                                "0. Exit.");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
            case 0:
                run = false;

            }
        }

    }
}
