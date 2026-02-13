package Homework20;

import Homework20.Products.Stew;

public class Homework20 {
    public static void main(String[] args){
        System.out.printf("%12s|%12s|%12s|%12s|%12s\n", "Product", "Produced on", "Storage place", "S. life days", "Fresh");
        System.out.printf("%12s+%12s+%12s+%12s+%12s+\n", "-".repeat(12),"-".repeat(12),"-".repeat(13),"-".repeat(12),"-".repeat(12));
        new Store().doInspection();
        System.out.printf("%12s+%12s+%12s+%12s+%12s+\n", "-".repeat(12),"-".repeat(12),"-".repeat(12),"-".repeat(12),"-".repeat(12));

    }

}
