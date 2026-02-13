package Exam2;

import java.util.Random;
import java.util.Scanner;

public class Step1 {
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    static int[] rounds = new int[3];

    public static void main(String[] args) {
        rollTheDice();
    }

    static void rollTheDice(){
        System.out.println("--- Start game ---");

        int[] userPredicted = new int[3];
        int[] userDice = new int[3];
        int[] userResults = new int[3];

        int[] computerPredicted = new int[3];
        int[] computerDice = new int[3];
        int[] computerResults = new int[3];

        int userTotal = 0;
        int computerTotal = 0;

        for (int i = 0; i < rounds.length; i++) {
            System.out.println();
            System.out.println("--------------------- User ---------------------");
            System.out.print("Predict amount of points (2..12): ");
            int points = sc.nextInt();
            System.out.println("User rolls the dices...");
            int roll = rnd.nextInt(6) + 1;
            int roll2 = rnd.nextInt(6) + 1;

            printDice(roll);
            printDice(roll2);

            int dicesFellResult = roll + roll2;
//            System.out.println("On the dice fell " + dicesFellResult + " points.");
            int resultTotal = dicesFellResult - (Math.abs(dicesFellResult - points) * 2);
//            System.out.println("Result is " + resultTotal + " points");

            userPredicted[i] = points;
            userDice[i] = dicesFellResult;
            userResults[i] = resultTotal;
            userTotal += resultTotal;



            System.out.println();
            System.out.println("--------------------- Computer ---------------------");

            int computerPredictedPoint = rnd.nextInt(12) + 1;
            System.out.println("Computer predicted " +  computerPredictedPoint + " points.");
            System.out.println("Computer rolls the dices...");

            int roll3 = rnd.nextInt(6) + 1;
            int roll4 = rnd.nextInt(6) + 1;

            printDice(roll3);
            printDice(roll4);

            int computerDicesFellResult = roll3 + roll4;
//            System.out.println("On the dice fell " + computerDicesFellResult + " points.");
            int computerResultTotal = computerDicesFellResult - (Math.abs(computerDicesFellResult - computerPredictedPoint) * 2);
//            System.out.println("Result is " + computerResultTotal + " points");

            computerPredicted[i] = computerPredictedPoint;
            computerDice[i] = computerDicesFellResult;
            computerResults[i] = computerResultTotal;
            computerTotal += computerResultTotal;

            System.out.println();
            System.out.println();

            System.out.println("---------- Current score ----------");
            System.out.println("User:     " + resultTotal + " points");
            System.out.println("Computer:  " + computerResultTotal + " points");
            if (resultTotal > computerResultTotal) {
                int p = resultTotal - computerResultTotal;
                System.out.println("User is ahead by " + p + " points");
            } else if (computerResultTotal > resultTotal) {
                int p = computerResultTotal - resultTotal;
                System.out.println("Computer is ahead by " + p + " points");
            }
            System.out.println("-----------------------------------");
        }

        System.out.println("\n-------------- Finish game ---------------");
        System.out.println("Round |     User     | Computer");
        for (int i = 0; i < rounds.length; i++) {
            System.out.println("- " + (i + 1) + " - | Predicted: " + userPredicted[i] + " | Predicted: " + computerPredicted[i]);
            System.out.println("      | Dice: " + userDice[i] + "      | Dice: " + computerDice[i]);
            System.out.println("      | Result: " + userResults[i] + "    | Result: " + computerResults[i]);
            System.out.println("------------------------------------------");
        }
        System.out.println("Total | Points: " + userTotal + " | Points: " + computerTotal);

        if (userTotal > computerTotal) {
            System.out.println("\nUsers win " + (userTotal - computerTotal) + " points more. Congratulations!");
        } else if (computerTotal > userTotal) {
            System.out.println("\nComputer win " + (computerTotal - userTotal) + " points more. Congratulations!");
        } else {
            System.out.println("\nDraw!");
        }
    }

    static void printDice(int number){
        switch (number){
            case 1:
                System.out.println("+-------+\n|       |\n|   #   |\n|       |\n+-------+");
                break;
            case 2:
                System.out.println("+-------+\n| #     |\n|       |\n|     # |\n+-------+");
                break;
            case 3:
                System.out.println("+-------+\n| #     |\n|   #   |\n|     # |\n+-------+");
                break;
            case 4:
                System.out.println("+-------+\n| #   # |\n|       |\n| #   # |\n+-------+");
                break;
            case 5:
                System.out.println("+-------+\n| #   # |\n|   #   |\n| #   # |\n+-------+");
                break;
            case 6:
                System.out.println("+-------+\n| #   # |\n| #   # |\n| #   # |\n+-------+");
                break;
            default:
                break;
        }
    }

}
