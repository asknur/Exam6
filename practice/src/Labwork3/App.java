package Labwork3;

import java.util.Random;
import java.util.Scanner;

public class App {
    private boolean isContinue = true;
    private int round = 1;
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public void run() {
        Dragon dragon = new Dragon(2000, 120, 150, 0);
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        HellHound hellHound = new HellHound(2500, 100, 170, 0);

        while (isContinue) {
            System.out.printf("====== Round %d ======\n", round++);
            if (attackOfHero(hero, dragon)) break;
            System.out.println("-".repeat(20));
            int randomChoice = rand.nextInt(2) + 1;
            if (randomChoice == 1) {
                if (attackOfDragon(hero, dragon)) break;
            } else {
                if (attackOfHellHound(hero, hellHound)) break;
            }
            hero.isShieldDown();

        }
        System.out.printf("%s has won!!!%n", getWinner(hero, dragon, hellHound));
    }

    public boolean attackOfHero(Hero hero, Dragon dragon) {
        System.out.println("Choose one of the following steps: \n" +
                "\t1. Attack the enemy\n" +
                "\t2. Do not attack\n" +
                "\t3. Raise the shield");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You choose to attack!");
                System.out.println("Attack of hero!");
                int chanceOfAttack = rand.nextInt(4) + 1;

                if (chanceOfAttack == 1) {
                    System.out.println("Hero's attack missed :(");
                } else {
                    int damage = (dragon.getDefence() + dragon.getHealth()) - (hero.getStrength() + hero.getWeapon());
                    dragon.setHealth(damage);
                    System.out.println("Hero makes " +  damage + " damage");
                    System.out.println("Dragons health left: " + dragon.getHealth());
                }
                break;
            case 2:
                System.out.println("You choose to do nothing");
                break;
            case 3:
                System.out.println("You choose to defence");
                hero.isShieldUp();
                break;
        }
        return hero.getHealth() <= 0;
    }

    public boolean attackOfDragon(Hero hero, Dragon dragon) {
        System.out.println("Attack of dragon!");
        int chanceOfAttack = rand.nextInt(2) + 1;

        if (chanceOfAttack == 1){
            System.out.println("Dragon's attack missed :(");
        } else {
            int damage = Math.max(0, (hero.getHealth() + hero.getDefence()) - (dragon.getStrength() + dragon.getWeapon()));
            hero.setHealth(damage);
            System.out.println("Dragon makes " + damage + " damage");
            System.out.println("Hero health left " + hero.getHealth());
        }
        return dragon.getHealth() <= 0;
    }

    public boolean attackOfHellHound(Hero hero, HellHound hellHound) {
        System.out.println("Attack of Hell hound!");
        int chanceOfAttack = rand.nextInt(2) + 1;

        if (chanceOfAttack == 1){
            System.out.println("Hell hound's attack missed :(");
        } else {
            int damage = Math.max(0, (hero.getHealth() + hero.getDefence()) - (hellHound.getStrength() + hellHound.getWeapon()));
            hero.setHealth(damage);
            System.out.println("Hell hound makes " + damage + " damage");
            System.out.println("Hero health left " + hero.getHealth());
        }
        return hellHound.getHealth() <= 0;
    }
     
    private String getWinner(Hero hero,  Dragon dragon, HellHound heroHound) {
        String result = "";
        if (hero.getHealth() <= 0){
            result = "Dragon";
        } else if (dragon.getHealth() <= 0){
            result = "Hero";
        } else if (heroHound.getHealth() <= 0) {
            result = "Hero";
        }
        return result;
    }
}
