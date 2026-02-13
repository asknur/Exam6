package Labwork6.states;

import Labwork6.exceptions.StateException;
import Labwork6.models.Driver;
import Labwork6.models.Truck;

public class OnBase implements State {

    @Override
    public void changeDriver(Truck truck) throws StateException {
        if (truck.getDriver() == null) {
            truck.setDriver("Sasha");
        } else {
            truck.setDriver("Petya");
        }

        System.out.println("Теперь грузовик " + truck.getName() + " ведёт водитель " + truck.getDriver());
    }

    @Override
    public void startDriving(Truck truck) throws StateException {
        truck.setStateObj(new OnRoute());
        truck.setState("OnRoute");
        System.out.println("Грузовик выехал в рейс");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateObj(new OnRepair());
        truck.setState("OnRepair");
        System.out.println("Машина на ремонте");
    }
}
