package Homework20.Products;

import Homework20.Product;

public class Salt extends Product {
    public Salt(String name, double expirationDate) {
        super(name, expirationDate);
    }

    public Salt(){
        super("Salt", Double.POSITIVE_INFINITY);
    }

    @Override
    public boolean isFresh() {
        return getDaysFromExpirationDate() < expirationDate;
    }
}
