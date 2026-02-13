package Homework17.Task2;

import java.util.Random;
import java.util.Scanner;

public class Elevator {
    private int currentFloor;
    private int capacity = 200;
    private int maxFloor = 18;

    public Elevator(int currentFloor){
        this.currentFloor = currentFloor;
    }

    public void move(int toFloor){
        Random rand = new Random();

        while (currentFloor != toFloor){
            steps(toFloor);
            if (rand.nextInt(3) + 1 > 2){
                System.out.println("You stuck in " + currentFloor + " floor");
                break;
            }
        }
        System.out.println("You got current " + currentFloor + " floor");
    }

    public void steps(int toFloor){
        System.out.println("Current Floor: " + currentFloor);
        if (currentFloor < toFloor) {
            currentFloor++;
        } else if (currentFloor > toFloor) {
            currentFloor--;
        }

    }

    public boolean isAllowableWeight(int weight){
        return weight <= capacity && weight >= 1;
    }

    public boolean isAllowableFloor(int floor){
        return floor <= maxFloor && floor >= 1;
    }
}
