package Exam3.States;

import Exam3.Models.Commodity;
import Exam3.exceptions.CommodityException;

public class Sold implements State{

    @Override
    public void startSale(Commodity commodity) throws CommodityException {
        System.out.println("You cannot start the sales cause of the commodity is already sold");
        throw new CommodityException("You cannot start the sales cause of the commodity is already sold");
    }

    @Override
    public void raisePrice(Commodity commodity) throws CommodityException {
        System.out.println("You cannot update the price cause of the commodity is already sold");
        throw new CommodityException("You cannot update the price cause of the commodity is already sold");
    }

    @Override
    public void withdraw(Commodity commodity) throws CommodityException {
        System.out.println("You cannot take off from auction cause of the commodity is already sold");
        throw new CommodityException("You cannot take off from auction cause of the commodity is already sold");
    }

    @Override
    public void giveToTheWinner(Commodity commodity) throws CommodityException {
        System.out.println("You cannot give cause of the commodity is already given");
        throw new CommodityException("You cannot give cause of the commodity is already given");
    }
}
