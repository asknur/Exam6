package Labwork6.states;

import Labwork6.exceptions.StateException;
import Labwork6.models.Truck;

import java.util.Random;

public class OnRepair implements State {
    Random r = new Random();

    @Override
    public void changeDriver(Truck truck) throws StateException {
        System.out.println("Нельзя сменить водителя");
        throw new StateException("Нельзя сменить водителя");
    }

    @Override
    public void startDriving(Truck truck) throws StateException {
        int ran = r.nextInt(1) + 2;
        if (ran == 1) {
            truck.setStateObj(new OnRoute());
            truck.setState("OnRoute");
            System.out.println("Грузовик в пути");
        } else {
            truck.setStateObj(new OnBase());
            truck.setState("OnBase");
            System.out.println("Грузовик на базе");
        }
    }

    @Override
    public void startRepair(Truck truck) throws StateException {
        System.out.println("Грузовик на данный момент уже находится на ремонте");
        throw new StateException("Грузовик на данный момент уже находится на ремонте");
    }
}
