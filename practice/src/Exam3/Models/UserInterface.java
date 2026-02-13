package Exam3.Models;

import Exam3.utils.FileUtil;

import java.util.Scanner;

public class UserInterface {
    Commodity[] commodities;
    Scanner sc = new Scanner(System.in);

    public UserInterface(Commodity[] commodities) {
        this.commodities = commodities;
    }

    public void commodityList() {
        String format = "%-3s| %-7s| %s";
        System.out.println(String.format(format, "#", "ID", "Name"));
        System.out.println("-------------------------------------------");
        for (int i = 0; i < commodities.length; i++) {
            System.out.println(String.format(format,
                    i + 1,
                    commodities[i].getId(),
                    commodities[i].getName()));
        }
    }

    public void availableActions() {
        while (true) {
            System.out.print("\nВведите серийный номер товара: ");
            int n = sc.nextInt();
            Commodity c = commodities[n - 1];

            String format = "%-5s| %-15s| %-10s| %-10s| %-10s%n";
            System.out.println(String.format(format, "ID", "Name", " State", "Price", "Code"));
            System.out.println(String.format(format,
                    c.getId(),
                    c.getName(),
                    c.getState(),
                    c.getPrice(),
                    c.getHonorary_code()));


            System.out.println("1. Выставить на аукцион\n" +
                    "2. Поднять цену\n" +
                    "3. Выдать победителю\n" +
                    "4. Снять с торгов\n" +
                    "5. Отобразить информацию о товаре\n" +
                    "6. Вернуться в список товаров\n");
            System.out.print("Введите номер действия: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    c.startSale();
                    break;
                case 2:
                    c.raisePrice();
                    break;
                case 3:
                    c.giveToTheWinner();
                    break;
                case 4:
                    c.withdraw();
                    break;
                case 5:
                    System.out.println(String.format(format, "ID", "Name", " State", "Price", "Code"));
                    System.out.println(String.format(format,
                            c.getId(),
                            c.getName(),
                            c.getState(),
                            c.getPrice(),
                            c.getHonorary_code()));
                    break;
                case 6:
                    commodityList();
                    break;
                default:
                    System.out.println("ХаюХай");
            }
        }
    }


}
