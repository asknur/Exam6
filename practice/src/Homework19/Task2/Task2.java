package Homework19.Task2;

public class Task2 {
    public static void main(String[] args) {
        Car car = new Car("Honda", "Accord", 60);
        car.onRoad(car.getSpeed());

        Bicycle bicycle = new Bicycle("Bicycle", "Benz", 15);
        bicycle.onRoad(bicycle.getSpeed());

        Airplane airplane = new Airplane("Airplane", "Samsung Airplane", 500);
        airplane.onRoad(airplane.getSpeed());
    }
}
