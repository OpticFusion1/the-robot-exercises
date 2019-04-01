package RPG;
public class Enemy {
    private static String name;
    private static int maxHealth;
    private static int health;
    private static int attack;
    private static int potionNum;
    private static int potionStrength;


    public Enemy(String name, int maxHealth, int health, int attack, int potionNum, int potionStrength) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.attack = attack;
        this.potionNum = potionNum;
        this.potionStrength = potionStrength;
    }


        static void enemyAttack(Character chooseClass){
        int randomNum = (int) (Math.random() * 6);
        System.out.println();
        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
            System.out.println();
            System.out.println("** " + Enemy.getName() + " hit " + chooseClass.getName() + " for " + Enemy.getAttack() + " **");
            chooseClass.setHealth(chooseClass.getHealth() - Enemy.getAttack());
            System.out.println(chooseClass.getName() + "'s health is now at " + chooseClass.getHealth());
        } else if (randomNum == 4) {
            System.out.println("** " + Enemy.getName() + " hit " + chooseClass.getName() + " for a critical attack of " + Enemy.getAttack() * 2 + " **");
            chooseClass.setHealth(chooseClass.getHealth() - (Enemy.getAttack() * 2));
            System.out.println(chooseClass.getName() + "'s health is now at " + chooseClass.getHealth());
        } else if (randomNum == 1) {
            System.out.println("** " + chooseClass.getName() + " dodged the attack! **");
            System.out.println(chooseClass.getName() + "'s health is still at " + chooseClass.getHealth());
        }
        chooseClass.checkHealth(chooseClass);
        chooseClass.battleChoices(chooseClass);
    }

         static void enemyHeal(Character chooseClass){
            int randomNum = (int) (Math.random() * 2);
            if(randomNum == 0 && Enemy.getHealth() <= 10 && Enemy.getPotionNum() > 0){
                Enemy.setPotionNum(Enemy.getPotionNum() - 1);
                Enemy.setHealth(Enemy.getHealth() + Enemy.getPotionStrength());
                System.out.println();
                System.out.println(Enemy.getName() + " used heal.");
                System.out.println(Enemy.getName() + " has been healed for " + Enemy.getPotionStrength());
                System.out.println(Enemy.getName() + "'s health is now at " + Enemy.getHealth());
                chooseClass.checkHealth(chooseClass);
                chooseClass.battleChoices(chooseClass);
            }else {
            enemyAttack(chooseClass);
        }
    }


    public static int getMaxHealth() {
        return maxHealth;
    }

    public static String getName() {
        return name;
    }

    public static int getHealth() {
        return health;
    }

    public static int getAttack() {
        return attack;
    }

    public static int getPotionNum() {
        return potionNum;
    }

    public static int getPotionStrength() {
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

    public static void setPotionNum(int potionNum) {
        Enemy.potionNum = potionNum;
    }

    public static void setPotionStrength(int potionStrength) {
        Enemy.potionStrength = potionStrength;
    }

    public static void setMaxHealth(int maxHealth) {
        Enemy.maxHealth = maxHealth;
    }
}
