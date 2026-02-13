package Labwork1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int startingYear = 1984;
        int year = sc.nextInt();
        String[] colors = {"Зелен", "Красн", "Желт", "Бел", "Черн"};
        String[] animals = {"ая крыса", "ая корова", "ый тигр", "ый заяц", "ый дракон", "ая змея", "ая лошадь",
                "ая овца", "ая обезьяна", "ая курица", "ая собака", "ая свинья"};

        if (year < startingYear) {
            System.out.println("Not true range");
        } else {
            System.out.println(colors[((year - startingYear) / 12) % 5] + animals[(year - startingYear) % 12]);

        }






    }
}
