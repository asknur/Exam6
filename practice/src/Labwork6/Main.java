package Labwork6;

import Labwork6.exceptions.StateException;
import Labwork6.models.Driver;
import Labwork6.models.Truck;
import Labwork6.states.OnBase;
import Labwork6.utils.FileUtil;
import Labwork6.utils.FileUtil2;
import com.google.gson.Gson;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        Gson GSON = new Gson();

        Truck[] trucks = FileUtil.readFile();
        Truck truck = trucks[0];
        truck.setStateObj(new OnBase());

        truck.startDriving();
        truck.startDriving();
        truck.startRepair();
        truck.changeDriver();
        truck.startDriving();
        truck.changeDriver();


        truck();
        driver();

        truck.getTruckById();
//        truck.getStateByNumber();
        truck();

    }

    public static void truck() {
        Path PATH = Paths.get("src/Labwork6/data/trucks.json");

        Truck[] trucks = FileUtil.readFile();
        System.out.println("#   | Bus                | Driver          | State   ");
        System.out.println("----|--------------------|-----------------|---------");

        for (Truck truck : trucks) {
            System.out.println(truck);
            truck.setState("OnBase");

        }

        FileUtil.writeFile(trucks);
    }

    public static void driver() {
        Path PATH = Paths.get("src/Labwork6/data/drivers.json");

        Driver[] drivers = FileUtil2.readFile();
        System.out.println("\n");
        System.out.println("#     | Driver        | Bus       ");
        System.out.println("------|---------------|--------------");

        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }


}
