package Homework14;

import java.util.Scanner;

public class Task4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solution(8.5, 9.3, 3.5);
        solution(7, 9, 15);
        
    }

    static double solution(double x, double y, double z) {
        double max = 0;
        if (x > y && x > z) {
            max = x;
            System.out.println(x + " is greater");
        }  else if (y > x && y > z) {
            max = y;
            System.out.println(y + " is greater");
        }   else if (z > x && z > y) {
            max = z;
            System.out.println(z + " is greater");
        }
        return max;
    }

    static int solution(int x, int y, int z) {
        int max1 = 0;
        if (x > y && x > z) {
            max1 = x;
            System.out.println(x + " is greater");
        }   else if (y > x && y > z) {
            max1 = y;
            System.out.println(y + " is greater");
        }   else if (z > x && z > y) {
            max1 = z;
            System.out.println(z + " is greater");
        }
        return max1;
    }



}
