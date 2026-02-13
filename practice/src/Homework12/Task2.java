package Homework12;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n =  sc.nextInt();
        for(int i = 0; i < 10; i++){
            String fmt = "%d * %d = %d%n";
            System.out.printf(fmt, n, i, n * i);
        }
    }
}
