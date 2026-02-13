package Homework12;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int[] numbersOfFibonacci = new int[rnd.nextInt(15) + 1];
        numbersOfFibonacci[0] = 1;
        numbersOfFibonacci[1] = 1;
        for (int i = 2; i < numbersOfFibonacci.length; i++) {
            numbersOfFibonacci[i] = numbersOfFibonacci[i - 1] + numbersOfFibonacci[i - 2];
            System.out.println((numbersOfFibonacci[i]));
        }
        System.out.println("In DESC");

        for (int i = numbersOfFibonacci.length - 1; i >= 0; i--) {
            System.out.println((numbersOfFibonacci[i]));
        }
    }
}
