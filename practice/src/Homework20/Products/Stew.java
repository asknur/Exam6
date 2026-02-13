package Homework20.Products;

import Homework20.Product;

public class Stew extends Product {
    public Stew(String name, double expirationDate) {
        super(name, expirationDate);
    }

    public Stew(){
        super("Stew", 180);
    }

    @Override
    public boolean isFresh() {
        return getDaysFromExpirationDate() < expirationDate;
    }
}
