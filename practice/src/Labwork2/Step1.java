package Labwork2;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Step1 {
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    static char[] encodedWords;
    static int points = 0;
    static int attempts = 3;
    static int[] rounds = new int[3];
    static int count = 1;

    public static void main(String[] args) {
        tourLaunch();
        repeatGame();
    }

    static String[] selectCategory() {
        String[] categories = new String[]{"Cities", "Fruits", "Professions", "Animals"};
        switch (rnd.nextInt(categories.length)) {
            case 0:
                System.out.println("Category: Cities");
                return new String[]{"Bishkek", "Talas", "Osh", "Manas", "Issykkul", "Batken", "Naryn"};
            case 1:
                System.out.println("Category: Fruits");
                return new String[]{"Apple", "Orange", "Pear", "Strawberry"};
            case 2:
                System.out.println("Category: Professions");
                return new String[]{"Baker", "Doctor", "Driver", "Teacher"};
            default:
                System.out.println("Category: Animals");
                return new String[]{"Dog", "Cat", "Elephant", "Monkey", "Horse"};
        }
    }

    static String selectWord(String[] words) {
        return words[rnd.nextInt(words.length)];
    }


    static void setEncodedWord(String word) {
        encodedWords = "*".repeat(word.length()).toCharArray();
        encodedWords = new char[word.length()];
        Arrays.fill(encodedWords, '*');
    }


    static char chooseLetter() {
        System.out.print("Choose a letter: ");
        char letter = sc.nextLine().trim().charAt(0);
        // check for users entering data
        return letter;
    }


    static void game(String word, char letter) {
        char[] wordCharArray = word.toCharArray();
        boolean isExist = false;
        for (int i = 0; i < wordCharArray.length; i++) {
            if (wordCharArray[i] == letter) {
                isExist = true;
                encodedWords[i] = wordCharArray[i];
                points++;
            }
        }
        if (!isExist) {
            System.out.println("Word not found");
            attempts--;
        }
    }


    static boolean isGameOver() {
        for (int i = 0; i < encodedWords.length; i++) {
            if (encodedWords[i] == '*') {
                return false;
            }
        }
        return true;
    }


    static void tourLaunch() {
        for (int i = 0; i < rounds.length; i++) {
            String[] categoryWords = selectCategory();
            String word = selectWord(categoryWords);
            setEncodedWord(word);

            while (!isGameOver()) {
                System.out.println(word);
                System.out.println(Arrays.toString(encodedWords));
                char letter = chooseLetter();
                game(word, letter);
                if (isGameOver()) {
                    System.out.println(word);
                }
                if (attempts == 0) {
                    System.out.println();
                    System.out.println("Attempts are lost");
                    break;
                }
            }
        }

        String format = "-".repeat(10) + " Finish game " + "-".repeat(10);
        String format1 = "  %5s  |  %5s  |  %5s%n";
        String format2 = " -%5d- |  %5d  |  %5d%n";
        String format3 = "  %5s  |  %5d  |  %5d%n";
        System.out.println(format);
        System.out.printf(format1, "Round", "Score", "Attempts");
        for (int i = 0; i < rounds.length; i++) {
            System.out.printf(format2, count++, points, attempts);
        }
        System.out.printf(format1,"-".repeat(5), "-".repeat(5), "-".repeat(5));
        System.out.printf(format3, "Total", points++, attempts);
    }



    static void repeatGame() {
        System.out.print("Do you want to play one more time? (yes/no): ");
        String choose = sc.nextLine().trim().toLowerCase();
        if (choose.equals("yes")) {
            for (int i = 0; i < rounds.length; i++) {
                tourLaunch();
            }
        } else if (choose.equals("no")) {
            System.out.println("Game Over");
        }
    }


}
