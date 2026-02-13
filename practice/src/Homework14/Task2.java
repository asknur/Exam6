package Homework14;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(getArrays(numbers)));

    }

    static int[] getArrays(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= -1;
        }
        return numbers;
    }
}
