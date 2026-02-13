package Homework17.Task2;

import java.util.Scanner;

public class Task2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Elevator elevator = new Elevator(1);

        System.out.print("Enter the number of floor: ");
        int floor = sc.nextInt();

        System.out.print("Enter the number of weight: ");
        int weight = sc.nextInt();

        if (!elevator.isAllowableFloor(floor)) {
            System.out.println("The floor is not allowable");
            return;
        } else if (!elevator.isAllowableWeight(weight)) {
            System.out.println("The weight is not allowable");
            return;
        }

        elevator.move(floor);

    }
}
