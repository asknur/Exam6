package Homework20;

import java.time.LocalDate;
import java.util.Random;

public abstract class Product {
    protected String name;
    protected double expirationDate;
    protected Storage storage;
    protected LocalDate producedOn;

    public Product(String name, double expirationDate) {
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public abstract boolean isFresh();

    public int getDaysFromExpirationDate(){
        return LocalDate.now().minusDays(this.producedOn.getDayOfMonth()).getDayOfMonth();
    }

    public void setProducedOn(LocalDate producedOn) {
        this.producedOn = producedOn;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return String.format("%-11s | %-10s | %-11s | %-11s | %-11s", name, expirationDate, storage, producedOn, isFresh());
    }
}
