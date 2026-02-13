package Homework22.Task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    Employee employee = new Employee();
    static Scanner input = new Scanner(System.in);

    public void getName(){
        try {
            System.out.print("Please enter your name: ");
            String name = input.nextLine();
            if (!name.matches("[a-zA-Z]+")){
                throw new IllegalArgumentException("Should contain only letters :(");
            }
            employee.setName(name);
            System.out.println("Name entered successfully");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSurname(){
        try{
            System.out.println("Please enter your surname: ");
            String surname = input.nextLine();
            if (!surname.matches("[a-zA-Z]+")){
                throw new IllegalArgumentException("Should be only letters :(");
            }
            employee.setSurname(surname);
            System.out.println("Surname entered successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getBirthYear(){
        try{
            System.out.println("Please enter your birth year: ");
            int birthYear = input.nextInt();
            employee.setBirthYear(birthYear);
            System.out.println("Birth year entered successfully");
        } catch (InputMismatchException e) {
            System.out.println("Should be only digits");
        }
    }

    public void getWorkStartYear(){
        try{
            System.out.println("Please enter your work start year: ");
            int workStartYear = input.nextInt();
            employee.setWorkStartYear(workStartYear);
            System.out.println("Work start year entered successfully");
        } catch (InputMismatchException e) {
            System.out.println("Should be only digits");
        }
    }
}