package RPG;
import java.util.Scanner;

import static RPG.Enemy.enemyAttack;
import static RPG.Enemy.enemyHeal;
import static RPG.HeroRPG.*;

public class Mage extends Character {
    private int magicPower;
    private int maxMagicPower;
    private int fireDamage;
    private int iceDamage;
    private int fireCost;
    private int iceCost;
    private boolean mage;


    public Mage(String name) {
        super(name, 22, 22, 3, 3, 5, 25);
        this.magicPower = 20;
        this.maxMagicPower = 20;
        this.fireDamage = 6;
        this.iceDamage = 8;
        this.fireCost = 3;
        this.iceCost = 5;
        this.mage = true;
    }



    /** Character Methods **/
    @Override
    public int usePotion(Character chooseClass) {
        if (this.getHealth() < 20 && this.getPotionNum() > 0) {
            this.setPotionNum(this.getPotionNum() - 1);
            this.setHealth(this.getHealth() + this.getPotionStrength());
            System.out.println(this.getName() + " drank a health potion. Health has increased by " + this.getPotionStrength() + ". Health is now at " + this.getHealth());
            System.out.println("You now have " + this.getPotionNum() + " left.");
            System.out.println("The enemies health is at " + Enemy.getHealth());
            enemyHeal(chooseClass);
        } else if (this.getHealth() == 100) {
            System.out.println("You may want to slow down on those potions, you are already at " + this.getHealth() + " health.");
            System.out.println("The enemies health is at " + Enemy.getHealth());
            battleChoices(chooseClass);
        } else if (this.getPotionNum() == 0) {
            System.out.println("You are out of potions!");
            System.out.println("The enemies health is at " + Enemy.getHealth());
            battleChoices(chooseClass);
        }
        return this.getHealth();
    }

    @Override
    public int sellPotions(Character chooseClass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you have to sell?");
        System.out.println("1 Potion = 2GP ** 3 Potions ** 6GP ** Nevermind");
        String potionSell = scanner.nextLine();
        if (potionSell.startsWith("1")) {
            if (this.getPotionNum() >= 1) {
                this.setCurrency(this.getCurrency() + 2);
                this.setPotionNum(this.getPotionNum() - 1);
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + this.getName() + " received 2GP.  You now have a total of: " + this.getCurrency() + " gold coins and " + this.getPotionNum() + " potions. **");
                sellPotions(chooseClass);
            } else if (this.getPotionNum() < 1) {
                System.out.println("Hey! What are you trying to pull.  You don't have any potions!");
                sellPotions(chooseClass);
            }
        }else if (potionSell.startsWith("3")) {
            if (this.getPotionNum() >= 3) {
                this.setCurrency(super.getCurrency() + 6);
                this.setPotionNum(this.getPotionNum() - 3);
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + this.getName() + " received 6GP.  You now have a total of " + this.getCurrency() + " gold coins and " + this.getPotionNum() + " potions. **");
                sellPotions(chooseClass);
            }
        }else if (potionSell.startsWith("N") || potionSell.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitPotionShop(chooseClass);
        }
        return this.getPotionNum();
    }

    @Override
    public int buyPotions(Character chooseClass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many potions are you wanting to buy?");
        System.out.println("1 Potion = 3GP *** 3 Potions = 6GP *** Nevermind");
        String potionBuy = scanner.nextLine();
        if (potionBuy.startsWith("1")){
            if (this.getCurrency() >= 3) {
                this.setPotionNum(this.getPotionNum() + 1);
                this.setCurrency(this.getCurrency() - 3);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + this.getName() + " now has " + this.getPotionNum() + " potions and " + this.getCurrency() + " gold coins. **");
                buyPotions(chooseClass);
            } else if (this.getCurrency() < 3) {
                System.out.println("It looks as though you don't have enough money.");
                buyPotions(chooseClass);
            }

        } else if (potionBuy.startsWith("3")) {
            if (this.getCurrency() >= 6) {
                this.setPotionNum(this.getPotionNum() + 3);
                this.setCurrency(this.getCurrency() - 6);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + this.getName() + " now has " + this.getPotionNum() + " potions and " + this.getCurrency() + " gold coins. **");
                buyPotions(chooseClass);
            } else if (this.getCurrency() < 6) {
                System.out.println("It looks as though you don't have enough money. I have kids to feed!");
                buyPotions(chooseClass);
            }
        } else if (potionBuy.startsWith("N") || potionBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitPotionShop(chooseClass);
        }
        return this.getPotionNum();
    }

    @Override
    public int attackEnemy(Character chooseClass) {
        int randomNum = (int) (Math.random() * 6);
        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
            System.out.println();
            System.out.println("** You hit " + Enemy.getName() + " for " + this.getAttack() + " **");
            Enemy.setHealth(Enemy.getHealth() - this.getAttack());
            System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
        } else if (randomNum == 4) {
            System.out.println("** You hit " + Enemy.getName() +  " for a critical attack of " + this.getAttack() * 2 + " **");
            Enemy.setHealth(Enemy.getHealth() - (this.getAttack() * 2));
            System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
        } else if (randomNum == 1) {
            System.out.println("** " + Enemy.getName() + " dodged the attack! **");
            System.out.println(Enemy.getName() + " health is still at " + Enemy.getHealth());
        }
        checkHealth(chooseClass);
        enemyHeal(chooseClass);
        return Enemy.getHealth();
    }

    @Override
    public int checkHealth(Character chooseClass) {
        if (this.getHealth() <= 0) {
            System.out.println(this.getName() + " has been defeated!");
            this.setHealth(this.getMaxHealth());
            this.setMagicPower(getMaxMagicPower());
            Enemy.setHealth(Enemy.getMaxHealth());
            visitInn(chooseClass);
        }else if(Enemy.getHealth() <= 0){
            System.out.println("Enemy has been defeated!");
            lootEnemy();
            Enemy.setHealth(Enemy.getMaxHealth());
            exploreTown(chooseClass);
            //What do you do after defeating the enemy? Enter the Cave
//            visitMarket();
        }
        return this.getMaxHealth();
    }



    /**specific Methods for the class **/

    @Override
    public int rest(Character chooseClass) {
        System.out.println("ZZZ");
        System.out.println("ZZZZZZZZ");
        this.setHealth(this.getMaxHealth());
        this.setMagicPower(this.getMaxMagicPower());
        System.out.println("** " + this.getName() + "'s health is now at " + this.getHealth());
        System.out.println("You look well rested!  Good luck out there!");
        System.out.println("Your health is now " + this.getMaxHealth());
        exploreTown(chooseClass);
        return this.getHealth();
    }

    @Override
    public String battleChoices(Character chooseClass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("|**| Attack |**| Potion |** Spells |**| Run |**|");

        String battleChoice = scanner.nextLine();
        if (battleChoice.startsWith("A") || battleChoice.startsWith("a")) {
            attackEnemy(chooseClass);
            enemyAttack(chooseClass);

        } else if (battleChoice.startsWith("P") || battleChoice.startsWith("p")) {
            usePotion(chooseClass);
            //enemyHeal();

        }else if(battleChoice.startsWith("S") || battleChoice.startsWith("s")){
            this.castFire(chooseClass);
            checkHealth(chooseClass);
//            enemyHeal();

        }else if (battleChoice.startsWith("R") || battleChoice.startsWith("r")) {
            Enemy.setHealth(25);
            exploreTown(chooseClass);
        }
        return battleChoice;
    }

    @Override
    public int lootEnemy() {
        int randomNum = (int) (Math.random() * 6);
        if (randomNum == 1 || randomNum == 3) {
            System.out.println("** Enemy has dropped 3 Gold **");
            System.out.println();
            this.setCurrency(this.getCurrency() + 3);
        } else if (randomNum == 2 || randomNum == 4) {
            System.out.println("** Enemy has dropped 5 Gold **");
            System.out.println();
            this.setCurrency(this.getCurrency() + 5);
        } else if (randomNum == 0) {
            System.out.println("** Enemy has dropped NEW ITEM **");
            System.out.println();
        }
        return this.getHealth();
    }

    @Override
    public String sellWeapons() {
        return "Currently unavailable";
    }

    @Override
    public int buyWeapons(Character chooseClass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ah! Here is our selection of wonderful killing devices.");
        System.out.println("Warriors Double Sided Battle Axe = 15GP (+5 Attack)");
        System.out.println("Magical Magic Stick of Magic = 15GP (+3 Attack & +5 Health)");
        System.out.println("Nevermind");
        String weaponBuy = scanner.nextLine();
        if (weaponBuy.startsWith("W") || weaponBuy.startsWith("w")) {
            System.out.println("I'm afraid you are unable to handle this weapon.");
            visitWeaponShop(chooseClass);
        }else if (weaponBuy.startsWith("M") || weaponBuy.startsWith("m")) {
            if (this.getCurrency() >= 15) {
                System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                receiveMageStaff();
                visitWeaponShop(chooseClass);
            } else if (this.getCurrency() < 15) {
                System.out.println("You are too poor for this right now.");
                visitWeaponShop(chooseClass);
            }
        } else if (weaponBuy.startsWith("N") || weaponBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitWeaponShop(chooseClass);
        }
        return this.getAttack();
    }



/**--------Mage Specific Methods--------**/

    private int receiveMageStaff(){
        this.setAttack(6);
        this.setMaxHealth(25);
        this.setHealth(this.getMaxHealth());
        this.setCurrency(this.getCurrency()- 15);
        System.out.println("** " + this.getName() + " received the Magical Magic Stick of Magic. **");
        System.out.println("** Attack Damage is now: " + this.getAttack() + ". You have a total of " + this.getCurrency() + " gold coins. **");
        System.out.println("** " + this.getName() + "'s health has increased to " + this.getHealth() + " **");
        return this.getAttack();
    }

    public void castFire(Character chooseClass) {
        if (this.magicPower >= 5) {
            this.setMagicPower(this.getMagicPower() - fireCost);
            System.out.println(this.getName() + " cast FIRE for a total of " + this.fireDamage + " damage");
            Enemy.setHealth(Enemy.getHealth() - fireDamage);
            System.out.println("You have " + this.getMagicPower() + " Magic Power left.");
            System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
            enemyAttack(chooseClass);
        } else if (this.magicPower < 5){
            System.out.println("You do not have enough Magic Power");
            battleChoices(chooseClass);
        }

        checkHealth(chooseClass);

    }
//
//    public void castIce() {
//        System.out.println(this.getName() + " cast ICE for a total of " + this.iceDamage + " damage");
//        //enemy health = enemy health - ice damage
//        Enemy.setHealth(Enemy.getHealth() - iceDamage);
//        System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
//    }

/**--------------GETTERS-----------------**/

    public int getMaxMagicPower() {
        return maxMagicPower;
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


/**--------------SETTERS---------------------**/
    public void setMaxMagicPower(int maxMagicPower) {
        this.maxMagicPower = maxMagicPower;
    }

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