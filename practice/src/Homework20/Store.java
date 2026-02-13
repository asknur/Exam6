package Homework20;

import Homework17.Task1.Channel;
import Homework20.Products.*;

import java.time.LocalDate;
import java.util.Random;

public class Store {
    Product[] products;
    Random rnd = new Random();

    public Store(){
        this.products = new Product[20];
        for(int i = 0; i < this.products.length; i++){
            Product product = getRandom();
            producedProduct(product);
            placeProduct(product);
            this.products[i] = product;
        }
    }

    public void producedProduct(Product product) {
        LocalDate producedProduct = LocalDate.now().minusDays(rnd.nextInt(200) + 1);
        product.setProducedOn(producedProduct);
    }

    public void placeProduct(Product product) {
        Storage[] storages = Storage.values();
        product.setStorage(storages[rnd.nextInt(storages.length)]);
    }

    public Product getRandom(){
        Product[] productsRandom = {new Stew(),new Salt(), new Milk(), new Corn(), new Fish()};
        return productsRandom[rnd.nextInt(productsRandom.length)];
    }

    public void doInspection(){
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }









}
