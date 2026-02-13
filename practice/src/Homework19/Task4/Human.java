package Homework19.Task4;

import java.util.Arrays;
import java.util.Random;

public class Human {
    private PaymentMethod[] paymentMethods;
    static Random rand = new Random();

    public Human(PaymentMethod[] paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

}
