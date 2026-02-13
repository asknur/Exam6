package Homework19.Task4.PaymentMethods;

import Homework19.Task4.PaymentMethod;

public class CashPayment extends PaymentMethod {
    public CashPayment(int balance) {
        super(balance);
    }

    @Override
    public boolean getPayment(double sum) {
        if (sum < getBalance()){
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }
        return true;
    }
}
