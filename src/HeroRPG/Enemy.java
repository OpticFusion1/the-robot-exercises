package HeroRPG;

public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int enemyAttack;
    private int enemyPotion;
    private int enemypotionCount;


    public Enemy(String name, int health, int attack, int healAmt, int potionNum){
        this.enemyName = name;
        this.enemyHealth = health;
        this.enemyAttack = attack;
        this.enemyPotion = healAmt;
        this.enemypotionCount = potionNum;

    }


    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public int getEnemyPotion() {
        return enemyPotion;
    }

    public int getEnemypotionCount() {
        return enemypotionCount;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }

    public void setEnemyPotion(int enemyPotion) {
        this.enemyPotion = enemyPotion;
    }

    public void setEnemypotionCount(int enemypotionCount) {
        this.enemypotionCount = enemypotionCount;
    }
}
