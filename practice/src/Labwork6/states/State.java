package Labwork6.states;

import Labwork6.exceptions.StateException;
import Labwork6.models.Truck;

public interface State {
    public void changeDriver(Truck truck) throws StateException;

    public void startDriving(Truck truck) throws StateException;

    public void startRepair(Truck truck) throws StateException;
}
