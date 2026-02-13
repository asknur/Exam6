package Homework12;

import java.util.Random;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int[] num = new int[rnd.nextInt(10) + 1];
        for (int i = 0; i < num.length; i++) {
            num[i] = rnd.nextInt(20) - 10;
            System.out.println(i + "->.   " + num[i]);
        }

        System.out.println("Negative number");
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 1) {
                System.out.println(i + "->.   " + num[i]);
            }
        }

        System.out.println("Positive number");
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 1) {
                System.out.println(i + "->.   " + num[i]);
            }
        }

        System.out.println("Devilled number");
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.println(i + "->.   " + num[i]);
            }
        }

        System.out.println("Non devilled number");
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 != 0) {
                System.out.println(i + "->.   " + num[i]);
            }
        }

        System.out.println("Sum of positive numbers");
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                num[i] = count++;
                System.out.println(count);
            }
        }

        System.out.println("Sum of negative numbers");
        int count2 = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0) {
                num[i] = count2++;
                System.out.println(count2);
            }
        }


    }
}
