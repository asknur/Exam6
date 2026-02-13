package Labwork1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ввод: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (y >= 0 && y <= 2){
            System.out.println("|| область");
        } else if (y > 3){
            System.out.println("| область");
        }  else if (y == 0 || y == 3){
            System.out.println("На границе");
        }
    }
}
