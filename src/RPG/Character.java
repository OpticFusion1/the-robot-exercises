package RPG;

public class Character {
    private String name;
    private int maxHealth; //how can this ensure health is kept at max depending on difficulty
    private int health;
    private int attack;
    private int potionNum;
    private int potionStrength;
    private int goldPoint;




    public Character(){
        this.name = "Hero";
        this.maxHealth = 25;
        this.health = 25;
        this.attack = 5;
        this.potionNum = 3;
        this.potionStrength = 5;
        this.goldPoint = 100;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
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

    public int getGoldPoint() {
        return goldPoint;
    }

/**----------- SETTERS--------------**/
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public void setGoldPoint(int goldPoint) {
        this.goldPoint = goldPoint;
    }
}


