package RPG;

import java.util.Scanner;

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


    static void enemyAttack(Character chooseDifficulty){
    int randomNum = (int) (Math.random() * 6);
    System.out.println();
    if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
        System.out.println();
        System.out.println("** " + Enemy.getName() + " hit " + chooseDifficulty.getName() + " for " + Enemy.getAttack() + " **");
        chooseDifficulty.setHealth(chooseDifficulty.getHealth() - Enemy.getAttack());
        System.out.println(chooseDifficulty.getName() + "'s health is now at " + chooseDifficulty.getHealth());
    } else if (randomNum == 4) {
        System.out.println("** " + Enemy.getName() + " hit " + chooseDifficulty.getName() + " for a critical attack of " + Enemy.getAttack() * 2 + " **");
        chooseDifficulty.setHealth(chooseDifficulty.getHealth() - (Enemy.getAttack() * 2));
        System.out.println(chooseDifficulty.getName() + "'s health is now at " + chooseDifficulty.getHealth());
    } else if (randomNum == 1) {
        System.out.println("** " + chooseDifficulty.getName() + " dodged the attack! **");
        System.out.println(chooseDifficulty.getName() + "'s health is still at " + chooseDifficulty.getHealth());
    }
    chooseDifficulty.checkHealth(chooseDifficulty);
    chooseDifficulty.battleChoices(chooseDifficulty);
}

    static void enemyHeal(Character chooseDifficulty){
            int randomNum = (int) (Math.random() * 2);
            if(randomNum == 0 && Enemy.getHealth() <= 10 && Enemy.getPotionNum() > 0){
                Enemy.setPotionNum(Enemy.getPotionNum() - 1);
                Enemy.setHealth(Enemy.getHealth() + Enemy.getPotionStrength());
                System.out.println();
                System.out.println(Enemy.getName() + " used heal.");
                System.out.println(Enemy.getName() + " has been healed for " + Enemy.getPotionStrength());
                System.out.println(Enemy.getName() + "'s health is now at " + Enemy.getHealth());
                chooseDifficulty.checkHealth(chooseDifficulty);
                chooseDifficulty.battleChoices(chooseDifficulty);
            }else {
            chooseDifficulty.checkHealth(chooseDifficulty);
            enemyAttack(chooseDifficulty);
        }
    }

    static String battleTroll(Character chooseDifficulty) {
        Enemy troll = new Enemy("Troll", 25, 25, 5, 3, 5);
        Scanner playRiddle = new Scanner(System.in);
        System.out.println("Troll: Greetings, hero!  I see you are wanting to pass through this cave.");
        System.out.println("Troll: If you can answer three riddles correctly, then I will let you pass.");
        System.out.println("Troll: If you fail, however, then I eat you.");
        System.out.println("Troll: Deal?");
        System.out.println("Y/N");
        String riddleChoice = playRiddle.nextLine();
        if(riddleChoice.startsWith("y") || riddleChoice.startsWith("Y")){
            HeroRPG.giveRiddles(chooseDifficulty);
        }else {
            System.out.println("Troll: Aw you are no fun.  Killing you will be fun.");
            chooseDifficulty.battleChoices(chooseDifficulty);
        }
        System.out.println();
        return riddleChoice;

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
