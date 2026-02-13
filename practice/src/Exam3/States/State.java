package Exam3.States;

import Exam3.Models.Commodity;
import Exam3.exceptions.CommodityException;

public interface State {
    public void startSale(Commodity commodity) throws CommodityException;

    public void raisePrice(Commodity commodity) throws CommodityException;

    public void withdraw(Commodity commodity) throws CommodityException;

    public void giveToTheWinner(Commodity commodity) throws CommodityException;
}
