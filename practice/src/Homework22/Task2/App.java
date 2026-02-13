package Homework22.Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);


    public void getParallelepiped() {
        try{
            System.out.print("Please enter the length of the parallelepiped: ");
            int a = sc.nextInt();
            System.out.print("Please enter the width of the parallelepiped: ");
            int b = sc.nextInt();
            System.out.print("Please enter the height of the parallelepiped: ");
            int c = sc.nextInt();
            Parallelepiped p = new Parallelepiped(a,b,c);
            System.out.println("Total area is: " + p.getTotalArea());
        } catch (IllegalArgumentException e){
            System.out.println("Must be positive number");
            e.printStackTrace();
        } catch (InputMismatchException e){
            System.out.println("Must be a number");
            e.printStackTrace();
        }
    }




}
