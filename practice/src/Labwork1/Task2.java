package Labwork1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int number = sc.nextInt();
        int counter = 0;
        int sum = 0;
        if (number <= 10 || number >= 1000000) {
            System.out.println("Error number");
        }  else {
            String num = String.valueOf(number); //преобразовываю в строку
            char[] arr = num.toCharArray();      //преобразовываю в массив символов
            int[] dv = new int[arr.length];      //преобразовываю массива символов в массив чисел

            for (int i = 0; i < arr.length; i++) {
                dv[i] = Character.getNumericValue(arr[i]);
                System.out.println(dv[i]);
                counter++;
                sum += dv[i];
            }

            System.out.println("The count of digits: " + counter);
            System.out.println("The sum of digits: " + sum);

            System.out.println("Even numbers: ");
            for (int i = 0; i < arr.length; i++) {
                if (dv[i] % 2 == 0) {
                    System.out.println(dv[i]);
                }
            }

            System.out.println("Not even numbers: ");
            for (int i = 0; i < arr.length; i++) {
                if (dv[i] % 2 != 0) {
                    System.out.println(dv[i]);
                }
            }

            Arrays.sort(dv);
            for (int i = 0; i < 1; i++) {
                double a =  (dv[dv.length -1] + dv[0]) / 2;
                System.out.println("Arithmetic average: " + a);
            }


        }


    }
}
