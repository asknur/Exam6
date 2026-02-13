package Labwork1;

import java.util.Arrays;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[10];

        System.out.print("Массив А: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Массив B: ");
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }

        System.out.print("Массив С: ");
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i] + b[i];
        }

        System.out.println(Arrays.toString(c));

        Arrays.sort(c);
        for (int i = 0; i < 1; i++) {
            System.out.printf("Максимальное значение: " + c[c.length - 1] + "%n");
        }

        for (int i = 0; i < 1; i++) {
            System.out.println("Минимальное значение из трех последних элементов: " + c[0] + ", " + c[1] + ", " + c[2]);
        }



    }
}