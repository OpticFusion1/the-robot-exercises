package RPG;

public class Enemy {
    private static String name;
    private static int health;
    private int attack;
    private int potionNum;
    private int potionStrength;


    public Enemy(String name, int health, int attack, int potionNum, int potionStrength) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.potionNum = potionNum;
        this.potionStrength = potionStrength;
    }

    public static String getName() {
        return name;
    }

    public static int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getPotionNum() {
        return potionNum;
    }

    public int getPotionStrength() {
        return potionStrength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setHealth(int health) {
        Enemy.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setPotionNum(int potionNum) {
        this.potionNum = potionNum;
    }

    public void setPotionStrength(int potionStrength) {
        this.potionStrength = potionStrength;
    }
}
