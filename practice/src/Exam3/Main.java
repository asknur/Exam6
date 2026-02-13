package Exam3;

import Exam3.Models.UserInterface;
import Exam3.Models.Commodity;
import Exam3.States.ForSale;
import Exam3.States.InStock;
import Exam3.States.Sold;
import Exam3.utils.FileUtil;

public class Main {
    public static void main(String[] args) {

        FileUtil fileUtil = new FileUtil("src/Exam3/data/products.json");
        Commodity[] commodities = FileUtil.readFile(fileUtil);
        UserInterface u = new UserInterface(commodities);

        for (Commodity c : commodities) {
            switch (c.getState()) {
                case "in_stock":
                    c.setStateObject(new InStock());
                    break;
                case "for_sale":
                    c.setStateObject(new ForSale());
                    break;
                case "sold":
                    c.setStateObject(new Sold());

                    break;
            }
        }

        u.commodityList();
        u.availableActions();


    }
}
