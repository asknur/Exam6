package Homework14;

import java.util.Scanner;

public class Task3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        getCycle();
    }

    static int getCycle(){
        int count = 0;
        int sum = 0;

        while (true){
            System.out.print("Enter the number: ");
            int number = sc.nextInt();
            sum += number;
            count++;
            if (number == 0){
                System.out.println("The End");
                break;
            }
        }

        System.out.println("You have entered: " + (count - 1));
        System.out.println("Their sum is: " + sum);
        System.out.println("Average of numbers is " + (sum / count - 1));
        return 1;
    }
}
