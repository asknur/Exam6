package Homework12;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int[] heights = new int[12];
        for (int i = 0; i < heights.length; i++) {
           heights[i] = rnd.nextInt(28) + 163;
           String fmt = "Player %d height is %d%n";
            System.out.printf(fmt, i, heights[i]);
        }
    }
}
