package RPG;

import static RPG.HeroRPG.battleMonster;

public class Mage extends Character {
    private int magicPower;
    private int fireDamage;
    private int iceDamage;
    private int fireCost;
    private int iceCost;
    private boolean mage;
    private boolean warrior;


    public Mage() {
//        super(name);
        this.setAttack(3);
        this.magicPower = 20;
        this.fireDamage = 6;
        this.fireCost = 2;
        this.iceDamage = 8;
        this.iceCost = 7;
        this.mage = true;
        this.warrior = false;

        this.setHealth(22);
    }


    public void castFire() {
        if (this.magicPower >= 5) {
            this.setMagicPower(this.getMagicPower() - fireCost);
            System.out.println(this.getName() + " cast FIRE for a total of " + this.fireDamage + " damage");
            Enemy.setHealth(Enemy.getHealth() - fireDamage);
            System.out.println("You have " + this.getMagicPower() + " Magic Power left.");
            System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
        } else if (this.magicPower < 5){
            System.out.println("You do not have enough Magic Power");
            battleMonster();

        }

    }

    public void castIce() {
        System.out.println(this.getName() + " cast ICE for a total of " + this.iceDamage + " damage");
        //enemy health = enemy health - ice damage
        Enemy.setHealth(Enemy.getHealth() - iceDamage);
        System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
    }


    public int getMagicPower() {
        return magicPower;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public int getIceDamage() {
        return iceDamage;
    }

    public int getFireCost() {
        return fireCost;
    }

    public int getIceCost() {
        return iceCost;
    }

    public boolean isMage() {
        return mage;
    }

    public boolean isWarrior() {
        return warrior;
    }

    /**--------------SETTERS---------------------**/
    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public void setFireDamage(int fireDamage) {
        this.fireDamage = fireDamage;
    }

    public void setIceDamage(int iceDamage) {
        this.iceDamage = iceDamage;
    }

    public void setFireCost(int fireCost) {
        this.fireCost = fireCost;
    }

    public void setIceCost(int iceCost) {
        this.iceCost = iceCost;
    }

    public void setMage(boolean mage) {
        this.mage = mage;
    }
}