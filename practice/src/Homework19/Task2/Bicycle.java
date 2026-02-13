package Homework19.Task2;

public class Bicycle extends Transport{

    public Bicycle(String brand, String model, int speed) {
        super(brand, model, speed);
    }

    @Override
    public boolean onRoad(int speed) {
        if (speed >= 1){
            System.out.println("Bicycle is on the road");
        } else {
            System.out.println("Bicycle is off the road");
        }
        return true;
    }
}
