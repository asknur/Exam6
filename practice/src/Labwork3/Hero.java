package Labwork3;

public class Hero extends Character {
    private int shield;
    private boolean isShieldUp;

    public Hero(int health, int defence, int strength, int weapon, int shield) {
        super(health, defence, strength, weapon);
        this.shield = shield;
        isShieldUp = false;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void isShieldUp() {
        defence += shield;
        isShieldUp = true;
    }

    public void isShieldDown() {
        defence -= shield;
        isShieldUp = false;
    }


}
