package HeroRPG;
import java.util.Scanner;
public class Hero {
    private String heroName;
    private int heroHealth;
    private int heroAttack;
    private int heroPotion;
    private int potionCount;
    private int goldPoint;
    private boolean warrior;
    private boolean mage;



    public Hero(String name, int health, int attack, int potionStrength, int numPotions, int goldPoint, boolean warrior, boolean mage){
        this.heroName = name;
        this.heroHealth = health;
        this.heroAttack = attack;
        this.heroPotion = potionStrength;
        this.potionCount = numPotions;
        this.goldPoint = goldPoint;
        this.warrior = warrior;
        this.mage = mage;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public int getHeroAttack() {
        return heroAttack;
    }

    public int getHeroPotion() {
        return heroPotion;
    }

    public int getPotionCount() {
        return potionCount;
    }

    public int getGoldPoint() {
        return goldPoint;
    }

    public boolean isWarrior() {
        return warrior;
    }

    public boolean isMage() {
        return mage;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setHeroHealth(int heroHealth) {
        this.heroHealth = heroHealth;
    }

    public void setHeroAttack(int heroAttack) {
        this.heroAttack = heroAttack;
    }

    public void setHeroPotion(int heroPotion) {
        this.heroPotion = heroPotion;
    }

    public void setPotionCount(int potionCount) {
        this.potionCount = potionCount;
    }

    public void setGoldPoint(int goldPoint) {
        this.goldPoint = goldPoint;
    }

    public void setWarrior(boolean warrior) {
        this.warrior = warrior;
    }

    public void setMage(boolean mage) {
        this.mage = mage;
    }
}

