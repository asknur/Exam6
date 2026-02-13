package Homework19.Task4;

public abstract class PaymentMethod {
    private double balance;

    public PaymentMethod(int balance) {
        this.balance = balance;
    }

    public abstract boolean getPayment(double sum);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
