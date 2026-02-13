package Homework19.Task1;

import Homework19.Task1.AirTransport.Airplane;
import Homework19.Task1.AirTransport.Helicopter;
import Homework19.Task1.RailTransport.Tram;

public class Task1 {
    public static void main(String[] args){
        Airplane airplane = new Airplane("Airbus", 3434, 3, 3, 4, 4);
        System.out.println("Airplane name: " + airplane.getName());
        Helicopter helicopter = new Helicopter("Helicopter", 3434, 3, 3, 4, 4);
        System.out.println("Helicopter name: " + helicopter.getName());
        System.out.println(helicopter.getSpeed());
        Tram tram = new Tram("Akjol", 4343, 43, 43);
        System.out.println("Tram name: " + tram.getName());
        System.out.println(tram.getSpeed());
        System.out.println(tram.getEngineCapacity());



    }
}
