package Homework12;

import java.util.Random;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int[] boxersWeight = new int[rnd.nextInt(16) + 10];
        int light = 0;
        int mediumLight = 0;
        int medium = 0;
        int mediumHard = 0;
        for (int i = 0; i < boxersWeight.length; i++) {
            boxersWeight[i] = rnd.nextInt(18) + 63;

            if (boxersWeight[i] <= 63) {
                System.out.println("Легкий вес: " + boxersWeight[i]);
                light++;
            }

            else if (boxersWeight[i] >= 64 && boxersWeight[i] <= 69 ) {
                System.out.println("Полусредний вес: "+ boxersWeight[i]);
                mediumLight++;

            } else if (boxersWeight[i] >= 70 && boxersWeight[i] <= 75) {
                System.out.println("Средний вес: " + boxersWeight[i]);
                medium++;

            } else {
                System.out.println("Полутяжелый вес: " + boxersWeight[i]);
                mediumHard++;
            }
        }

        System.out.println();
        System.out.println("Общий свод по весам: ");
        System.out.println("Легкий вес: " + light);
        System.out.println("Полусредний вес: "  + mediumLight);
        System.out.println("Средний вес: " + medium);
        System.out.println("Полутяжелый вес: " + mediumHard);
    }
}
