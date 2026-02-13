package Exam3.States;

import Exam3.Models.CodeGenerator;
import Exam3.Models.Commodity;
import Exam3.exceptions.CommodityException;

public class ForSale implements State {
    CodeGenerator codeGenerator = new CodeGenerator();

    @Override
    public void startSale(Commodity commodity) throws CommodityException {
        System.out.println("The commodity is already participating in the auction");
        throw new CommodityException("The commodity is already participating in the auction");
    }

    @Override
    public void raisePrice(Commodity commodity) {
        System.out.println("The commodity price is successfully updated");
        double a = commodity.getPrice() + 100.0;
        commodity.setPrice(a);
    }

    @Override
    public void withdraw(Commodity commodity) throws CommodityException {
        if (commodity.getPrice() == commodity.getPrice()) {
            commodity.setStateObject(new InStock());
            commodity.setState("in_stock");
        } else if (commodity.getPrice() != commodity.getPrice()) {
            System.out.println("The commodity is already in reserve. You can only give");
        }
    }

    @Override
    public void giveToTheWinner(Commodity commodity) throws CommodityException {
        if (commodity.getPrice() == 0) {
            System.out.println("You cannot give the commodity for free");
            throw new CommodityException("You cannot give the commodity for free");
        } else if (commodity.getPrice() >= 1) {
            commodity.setStateObject(new Sold());
            commodity.setState("sold");
        }
        codeGenerator.setCode(commodity);
    }
}
