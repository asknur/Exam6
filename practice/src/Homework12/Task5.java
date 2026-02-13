package Homework12;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int[] precipitations = new int[rnd.nextInt(14) + 1];
        for (int i = 0; i < precipitations.length; i++) {
            precipitations[i] = rnd.nextInt(49) + 1;
            System.out.println(precipitations[i]);
        }
        Arrays.sort(precipitations);
        System.out.println("Max precipitation: " + precipitations[precipitations.length - 1]);
    }
}
