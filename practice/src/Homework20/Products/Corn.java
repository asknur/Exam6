package Homework20.Products;

import Homework20.Product;

public class Corn extends Product {
    public Corn(String name, double expirationDate) {
        super(name, expirationDate);
    }

    public Corn() {
        super("Corn", 150);
    }

    @Override
    public boolean isFresh() {
        return getDaysFromExpirationDate() < expirationDate;
    }


}
