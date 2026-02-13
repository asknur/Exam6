package Labwork1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int employers = 5;
        int[] salary = new int[employers];
        int sum = 0;
        System.out.println("Enter the salary of worker below: ");

        for (int i = 0; i < employers; i++) {
            salary[i] = sc.nextInt();
            sum += salary[i];
        }

        Arrays.sort(salary);
        System.out.println("The maximum salary is: " + salary[salary.length-1]);
        System.out.println("The minimum salary is: " + salary[0]);
        int diff =  salary[salary.length-1] - salary[0];
        System.out.println("The difference between max amd min salary is: " + diff);
        System.out.println("Total sum of all salaries is: " + sum);



    }
}
