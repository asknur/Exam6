package Homework19.Task1.AirTransport;

import Homework19.Task1.Transport;

public class AirTransport extends Transport {
    private double flightTime;
    private double cargoCapacity;

    public AirTransport(String name, int model, int engineCapacity, int speed, double flightTime, double cargoCapacity) {
        super(name, model, engineCapacity, speed);
        this.flightTime = flightTime;
        this.cargoCapacity = cargoCapacity;
    }

    public double getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(double flightTime) {
        this.flightTime = flightTime;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
