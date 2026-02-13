package Exam3.Models;

import Exam3.States.State;
import Exam3.exceptions.CommodityException;

public class Commodity {
    private String id;
    private String name;
    private double price;
    private String honorary_code;
    private String state;
    private transient State stateObject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHonorary_code() {
        return honorary_code;
    }

    public void setHonorary_code(String honorary_code) {
        this.honorary_code = honorary_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public State getStateObject() {
        return stateObject;
    }

    public void setStateObject(State stateObject) {
        this.stateObject = stateObject;
    }

    public void raisePrice() {
        try {
            stateObject.raisePrice(this);
        } catch (CommodityException e) {
            e.getMessage();
        }
    }

    public void startSale() {
        try {
            stateObject.startSale(this);
        } catch (CommodityException e) {
            e.getMessage();
        }
    }

    public void giveToTheWinner() {
        try {
            stateObject.giveToTheWinner(this);
        } catch (CommodityException e) {
            e.getMessage();
        }
    }

    public void withdraw() {
        try {
            stateObject.withdraw(this);
        } catch (CommodityException e) {
            e.getMessage();
        }
    }
}
