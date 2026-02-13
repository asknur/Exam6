package Labwork3;

public class Character {
    protected int health;
    protected int defence;
    protected int strength;
    protected int weapon;
    protected int shield;

    public Character(int health, int defence, int strength, int weapon) {
        this.health = health;
        this.defence = defence;
        this.strength = strength;
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }
}
