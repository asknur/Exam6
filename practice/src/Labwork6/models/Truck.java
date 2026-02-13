package Labwork6.models;

import Labwork6.exceptions.StateException;
import Labwork6.states.State;
import Labwork6.utils.FileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Truck {
    private int id;
    private String name;
    private String driver;
    private String state;
    private State stateObj;
    static Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return String.format(
                "%-3d | %-18s | %-15s | %-8s",
                id,
                name,
                driver,
                state
        );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public State getStateObj() {
        return stateObj;
    }

    public void setStateObj(State stateObj) {
        this.stateObj = stateObj;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }


    public void changeDriver() {
        try {
            stateObj.changeDriver(this);
        } catch (StateException e) {
            e.getMessage();
        }
    }

    public void startDriving() {
        try {
            stateObj.startDriving(this);
        } catch (StateException e) {
            e.getMessage();
        }
    }

    public void startRepair() {
        try {
            stateObj.startRepair(this);
        } catch (StateException e) {
            e.getMessage();
        }
    }

    public void getTruckById() {
        Truck[] trucks = FileUtil.readFile();
        Truck truck1 = trucks[0];
        Truck truck2 = trucks[1];
        Truck truck3 = trucks[2];


        try {
            System.out.print("\nВведите ID клиента: ");
            int id = sc.nextInt();
            switch (id) {
                case 1:
                    System.out.printf("%8s: %d\n", "#", truck1.getId());
                    System.out.printf("%8s: %s\n", "Bus", truck1.getName());
                    System.out.printf("%8s: %s\n", "Driver", truck1.getDriver());
                    System.out.printf("%8s: %s\n", "State", truck1.getState());
                    break;
                case 2:
                    System.out.printf("%8s: %d\n", "#", truck2.getId());
                    System.out.printf("%8s: %s\n", "Bus", truck2.getName());
                    System.out.printf("%8s: %s\n", "Driver", truck2.getDriver());
                    System.out.printf("%8s: %s\n", "State", truck2.getState());
                    break;
                case 3:
                    System.out.printf("%8s: %d\n", "#", truck3.getId());
                    System.out.printf("%8s: %s\n", "Bus", truck3.getName());
                    System.out.printf("%8s: %s\n", "Driver", truck3.getDriver());
                    System.out.printf("%8s: %s\n", "State", truck3.getState());
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно ввести число от 1 до 3");
        }
    }

//    public void getStateByNumber() throws StateException {
//        System.out.println("1. Сменить водителя\n");
//        System.out.println("2. Отправить на маршрут\n");
//        System.out.println("3. Отправить на ремонт\n");
//        System.out.print("Введите номер: ");
//        int n = sc.nextInt();
//        switch (n){
//            case 1:
//
//                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//        }
//
//    }


}
