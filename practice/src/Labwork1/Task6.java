package Labwork1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int ruble = a / 100;
        int cents = a % 100;

        String f = "%d %s %d %s";

        if (ruble == 1 || cents == 1){
            System.out.printf(f, ruble, "рубль", cents, "копейка");
        }  else if (ruble >= 2 || cents >= 2){
            System.out.printf(f, ruble, "рублей", cents, "копеек");
        }

    }
}
