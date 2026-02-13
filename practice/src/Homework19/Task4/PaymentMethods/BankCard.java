package Homework19.Task4.PaymentMethods;

import Homework19.Task4.PaymentMethod;

public class BankCard extends PaymentMethod {
    private int limit;

    public BankCard(int balance, int limit) {
        super(balance);
        this.limit = limit;
    }

    @Override
    public boolean getPayment(double sum) {
        if (sum < getBalance() && sum < limit) {
            System.out.println("Payment successful");
        } else  {
            System.out.println("Payment failed");
        }
        return true;
    }
}
