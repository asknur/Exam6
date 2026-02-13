package Homework19.Task1;

import Homework19.Task1.AirTransport.Helicopter;

public class Transport {
    protected String name;
    protected int model;
    protected int engineCapacity;
    protected int speed;

    public Transport(String name, int model, int engineCapacity, int speed) {
        this.name = name;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
