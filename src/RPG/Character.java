package RPG;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import static RPG.HeroRPG.chooseSpec;
abstract class Character {
    private String name;
    private int maxHealth; //how can this ensure health is kept at max depending on difficulty/class
    private int health;
    private int attack;
//    private int potionNum;
//    private List<String> inventory;
    private int potionStrength;
    private int currency;

//    public Character(String name, int maxHealth, int health, int attack, List<String> inventory, int potionStrength, int currency) {
//        this.name = name;
//        this.maxHealth = maxHealth;
//        this.health = health;
//        this.attack = attack;
//        this.inventory = inventory;
//        this.potionStrength = potionStrength;
//        this.currency = currency;
//    }


        public Character(String name, int maxHealth, int health, int attack, int potionStrength, int currency) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.attack = attack;
//        this.potionNum = 3;
//        this.inventory = inventory;
        this.potionStrength = 5;
        this.currency = 25;
    }



    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

//    public int getPotionNum() {
//        return potionNum;
//    }


//    public List<String> getInventory() {
//        return inventory;
//    }

    public int getPotionStrength() {
        return potionStrength;
    }

    public int getCurrency() {
        return currency;
    }

    /**--------------SETTERS------------**/

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

//    public void setPotionNum(int potionNum) {
//        this.potionNum = potionNum;
//    }

    public void setPotionStrength(int potionStrength) {
        this.potionStrength = potionStrength;
    }

//    public void setInventory(List<String> inventory) {
//        this.inventory = inventory;
//    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public abstract int usePotion(Character chooseDifficulty);
    public abstract int sellPotions(Character chooseDifficulty);
    public abstract int buyPotions(Character chooseDifficulty);
    public abstract String sellWeapons();
    public abstract int buyWeapons(Character chooseDifficulty);
//    public abstract String inspectSelf();
    public abstract int rest(Character chooseDifficulty);
    public abstract int attackEnemy(Character chooseDifficulty);
    public abstract int lootEnemy();
    public abstract int checkHealth(Character chooseDifficulty);
    public abstract String battleChoices(Character chooseDifficulty);
    public abstract int countPotion();
//    public abstract int receive3Potions();

//    public abstract int selectDifficulty();
//    public abstract String nameHero();
//    public abstract int visitInn();
//    public abstract String redoHero();






}


