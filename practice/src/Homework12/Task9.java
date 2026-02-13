package Homework12;

import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int[][] train = new int[18][20];
        char[] replaceArray = new char[train.length];
        for (int i = 0; i < train.length; i++) {
            for (int j = 0; j < train[i].length; j++) {
                if (train[i][j] == 0) {
                    replaceArray[i] = '*';
                }
                else if (train[i][j] == 1) {
                    replaceArray[i] = ' ';
                }
                train[i][j] = rnd.nextInt(2);
            }
        }

        System.out.printf("%s", "      ");
        for (int j = 1; j < 21; j++) {
            System.out.printf("|%3d", j);
        }

        System.out.printf("%n");
        System.out.println("--".repeat(41));

        String format = "|%3c";
        for (int i = 0; i < train.length; i++) {
            System.out.printf("%3d ->", i + 1);
            for (char t : replaceArray) {
                System.out.printf(format, t);
            }
            System.out.println("|");
        }

        //-------------------------------------------------------------

        System.out.print("Enter the number of train: ");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                int[] row = train[0];
                for (int t : row) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 2:
                int[] row1 = train[1];
                for (int t : row1) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 3:
                int[] row2 = train[2];
                for (int t : row2) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 4:
                int[] row3 = train[3];
                for (int t : row3) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 5:
                int[] row4 = train[4];
                for (int t : row4) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 6:
                int[] row5 = train[5];
                for (int t : row5) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 7:
                int[] row6 = train[6];
                for (int t : row6) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 8:
                int[] row7 = train[7];
                for (int t : row7) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 9:
                int[] row8 = train[8];
                for (int t : row8) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 10:
                int[] row9 = train[9];
                for (int t : row9) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 11:
                int[] row10 = train[10];
                for (int t : row10) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 12:
                int[] row11 = train[11];
                for (int t : row11) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 13:
                int[] row12 = train[12];
                for (int t : row12) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 14:
                int[] row13 = train[13];
                for (int t : row13) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 15:
                int[] row14 = train[14];
                for (int t : row14) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 16:
                int[] row15 = train[15];
                for (int t : row15) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 17:
                int[] row16 = train[16];
                for (int t : row16) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;
            case 18:
                int[] row17 = train[17];
                for (int t : row17) {
                    String f = "|%3d";
                    System.out.printf(f, t);
                }
                break;


        }
    }
}
