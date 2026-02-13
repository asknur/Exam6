package Homework20.Products;

import Homework20.Product;
import Homework20.Storage;

import java.time.LocalDate;

public class Fish extends Product {
    public Fish(String name, double expirationDate) {
        super(name, expirationDate);
    }

    public Fish() {
        super("Fish", 20);
    }


    @Override
    public boolean isFresh() {
        if (storage == Storage.Showcase){
            return getDaysFromExpirationDate() < expirationDate / 6;
        } else  {
            return getDaysFromExpirationDate() < expirationDate;
        }
    }
}
