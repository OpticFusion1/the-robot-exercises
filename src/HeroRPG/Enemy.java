package HeroRPG;

public class Enemy {
    public String enemyName;
    private int enemyHealth;
    private int enemyAttack;
//    public int enemyPotion = 2;
//    public int enemypotionCount = 3;


    public Enemy(int health, int attack){
        this.enemyHealth = health;
        this.enemyAttack = attack;
    }


    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }
}
