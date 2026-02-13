package Exam3.States;

import Exam3.Models.Commodity;
import Exam3.exceptions.CommodityException;

public class InStock implements State{

    @Override
    public void startSale(Commodity commodity) {
        commodity.setStateObject(new ForSale());
        commodity.setState("for_sale");
        System.out.println("Successful start of auction");
    }

    @Override
    public void raisePrice(Commodity commodity) throws CommodityException{
        System.out.println("The commodity is not yet participating in auction");
        throw new CommodityException("The commodity is not yet participating in auction");
    }

    @Override
    public void withdraw(Commodity commodity) throws CommodityException {
        System.out.println("You cannot the goods that they don't participate in the auction");
        throw new CommodityException("You cannot the goods that they don't participate in the auction");
    }

    @Override
    public void giveToTheWinner(Commodity commodity) throws CommodityException {
        System.out.println("Cannot return commodity directly from the stock");
        throw new CommodityException("Cannot return commodity directly from the stock");
    }
}
