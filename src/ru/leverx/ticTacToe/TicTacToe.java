package ru.leverx.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private final char X = 'X';
    private final char O = '0';
    private final char EMPTY = '_';
    private char[][] playingField;
    private int option;
    private Scanner sc;

    public TicTacToe(int option) {
        playingField = new char[3][3];
        this.option = option;
        sc = new Scanner(System.in);
    }

    public void game() {
        initialField();

        if (option == 1) {
            while (true) {
                showField();
                stepPerson(X);
                if (fieldIsFull() || winCheck(X)) {
                    break;
                }
                showField();

                stepPerson(O);
                if (fieldIsFull() || winCheck(O)) {
                    break;
                }
            }
        } else if (option == 2) {
            while (true) {
                showField();
                stepPerson(X);
                if (fieldIsFull() || winCheck(X)) {
                    break;
                }
                showField();

                stepAI(O);
                if (fieldIsFull() || winCheck(O)) {
                    break;
                }
            }
        }

        System.out.println("---GAME OVER---");
        showField();
    }

    private boolean winCheck(char sign) {
        if (playingField[0][0] == sign && playingField[0][1] == sign && playingField[0][2] == sign
                || playingField[1][0] == sign && playingField[1][1] == sign && playingField[1][2] == sign
                || playingField[2][0] == sign && playingField[2][1] == sign && playingField[2][2] == sign
                || playingField[0][0] == sign && playingField[1][0] == sign && playingField[2][0] == sign
                || playingField[0][1] == sign && playingField[1][1] == sign && playingField[2][1] == sign
                || playingField[0][2] == sign && playingField[1][2] == sign && playingField[2][2] == sign
                || playingField[0][0] == sign && playingField[1][1] == sign && playingField[2][2] == sign
                || playingField[0][2] == sign && playingField[1][1] == sign && playingField[2][0] == sign) {
            System.out.println("Sign '" + sign + "' WINS! CONGRATS!");
            return true;
        }
        return false;
    }

    private void initialField() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                playingField[row][column] = EMPTY;
            }
        }
    }

    private void showField() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.print(playingField[row][column] + " ");
            }
            System.out.println();
        }
    }

    private boolean fieldIsFull() {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (playingField[row][column] != EMPTY) {
                    count++;
                }
            }
        }
        return count == 9;
    }

    private void stepPerson(char sign) {
        int x, y;
        do {
            System.out.println("Enter coordinates for " + sign + " (e.g. 1 and 3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isValid(x, y));
        playingField[x][y] = sign;
    }

    private void stepAI(char sign) {
        int x, y;
        do {
            Random rand = new Random();
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (!isValid(x, y));
        playingField[x][y] = sign;
        System.out.println("AI move:");
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3 && option == 1) {
            System.out.println("Wrong coordinates!");
            return false;
        }

        if (playingField[x][y] == X || playingField[x][y] == O && option == 1) {
            System.out.println("Cell is NOT empty! Please, enter another coordinates:)");
            return false;
        }
        return true;
    }
}
