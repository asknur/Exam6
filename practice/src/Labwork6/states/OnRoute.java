package Labwork6.states;

import Labwork6.exceptions.StateException;
import Labwork6.models.Truck;

public class OnRoute implements State{
    @Override
    public void changeDriver(Truck truck) throws StateException {
        System.out.println("Нельзя сменить водителя. Он уже находится в пути!");
        throw new StateException("Нельзя сменить водителя. Он уже находится в пути!");
    }

    @Override
    public void startDriving(Truck truck) throws StateException {
        System.out.println("Грузовик уже в пути!");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateObj(new OnRepair());
        truck.setState("OnRepair");
        System.out.println("Грузовик отправлен на ремонт");
    }
}
