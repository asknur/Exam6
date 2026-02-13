package Homework19.Task2;

public class Car extends Transport{

    public Car(String brand, String model, int speed) {
        super(brand, model, speed);
    }

    @Override
    public boolean onRoad(int speed) {
        if (speed >= 1){
            System.out.println("Car is on the road");
        } else {
            System.out.println("Car is off the road");
        }
        return true;
    }
}
