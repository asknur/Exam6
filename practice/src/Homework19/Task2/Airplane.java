package Homework19.Task2;

public class Airplane extends Transport{
    public Airplane(String brand, String model, int speed) {
        super(brand, model, speed);
    }

    @Override
    public boolean onRoad(int speed) {
        if (speed >= 1){
            System.out.println("Airplane is on the road");
        } else {
            System.out.println("Airplane is off the road");
        }
        return true;
    }
}
