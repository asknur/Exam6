package Labwork6.models;

public class Driver {
    private String id;
    private String name;
    private String bus;

    @Override
    public String toString() {
        return String.format(
                "%-3s | %-13s | %-15s",
                id,
                name,
                bus
        );
    }


}
