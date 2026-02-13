package Homework19.Task4.PaymentMethods;

import Homework19.Task4.PaymentMethod;

public class CreditCard extends PaymentMethod {
    private int limit;

    public CreditCard(int balance, int limit) {
        super(balance);
    }

    @Override
    public boolean getPayment(double sum) {
        if (sum < limit) {
            System.out.println("Payment successful");
        } else  {
            System.out.println("Payment failed");
        }
        return true;
    }
}
