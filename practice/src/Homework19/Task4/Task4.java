package Homework19.Task4;

import Homework19.Task4.PaymentMethods.CashPayment;

public class Task4 {
    public static void main(String[] args) {
        CashPayment cashPayment = new CashPayment(300);
        cashPayment.getPayment(350);

    }
}
