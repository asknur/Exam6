package Homework20.Products;

import Homework20.Product;
import Homework20.Storage;

public class Milk extends Product {
    public Milk(String name, double expirationDate) {
        super(name, expirationDate);
    }

    public Milk(){
        super("Milk", 60);
    }

    @Override
    public boolean isFresh() {
        if (storage == Storage.Showcase) {
            return getDaysFromExpirationDate() < expirationDate / 2;
        } else  {
            return getDaysFromExpirationDate() < expirationDate;
        }
    }
}
