package RPG;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> inventory;
    private boolean mage;


    public Mage(String name) {
        super(name, 22, 22, 3, 5, 25);
        this.magicPower = 20;
        this.maxMagicPower = 20;
        this.fireDamage = 6;
        this.iceDamage = 8;
        this.fireCost = 3;
        this.iceCost = 5;
        this.inventory = new ArrayList<>();
        this.mage = true;
    }

//public int countPotion(){
//    int potionNum = 0;
//    for(int i = 0; i < this.inventory.size(); i++){
//        if (this.inventory.contains("health potion")) {
//            potionNum++;
//        }
//    }
// return potionNum;
//}


//    @Override
//    public int receive3Potions() {
//        for (int i = 0; i < 3; i++) {
//            this.inventory.add("health potion");
//        }
//        return countPotion();
//    }



    /** Character Methods **/



//    @Override
//    public int receive3Potions(){
//        for(int i = 0; i < 3; i++) {
//            this.inventory.add("health potion");
//        }
//        return countPotion();
//    }



    @Override
    public int countPotion() {
        int potionNum = 0;
        for(int i = 0; i < this.inventory.size(); i++){
            if (this.inventory.contains("health potion")) {
                potionNum++;
            }
        }
        return potionNum;
    }

    @Override
    public int usePotion(Character chooseDifficulty) {
        if (this.getHealth() < chooseDifficulty.getMaxHealth() && this.inventory.contains("health potion")) {
//            this.setPotionNum(this.getPotionNum() - 1);
            this.inventory.remove("health potion");
            this.setHealth(this.getHealth() + this.getPotionStrength());
            System.out.println(this.getName() + " drank a health potion. Health has increased by " + this.getPotionStrength() + ". Health is now at " + this.getHealth());
            System.out.println("You now have " + countPotion() + " left.");
            System.out.println("The enemies health is at " + Enemy.getHealth());
            enemyHeal(chooseDifficulty);
        } else if (this.getHealth() == chooseDifficulty.getMaxHealth() && this.inventory.contains("health potion")) {
            System.out.println("You may want to slow down on those potions, you are already at " + this.getHealth() + " health.");
            System.out.println("The enemies health is at " + Enemy.getHealth());
            battleChoices(chooseDifficulty);
        } else if (!this.inventory.contains("health potion")) {
            System.out.println("You are out of potions!");
            System.out.println("The enemies health is at " + Enemy.getHealth());
            battleChoices(chooseDifficulty);
        }
        return this.getHealth();
    }

    @Override
    public int sellPotions(Character chooseDifficulty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you have to sell?");
        System.out.println("1 Potion = 2GP ** 3 Potions ** 6GP ** Nevermind");
        String potionSell = scanner.nextLine();
        if (potionSell.startsWith("1")) {
            if (this.inventory.contains("health potion")){
                this.setCurrency(this.getCurrency() + 2);
                this.inventory.remove("health potion");
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + this.getName() + " received 2GP.  You now have a total of " + this.getCurrency() + " gold coins and " + countPotion() + " potions. **");
                sellPotions(chooseDifficulty);
            } else if (!this.inventory.contains("health potion")) {
                System.out.println("Hey! What are you trying to pull.  You don't have any potions!");
                sellPotions(chooseDifficulty);
            }
        }else if (potionSell.startsWith("3")) {
            if (countPotion() >= 3) {
                this.setCurrency(super.getCurrency() + 6);
                for(int i = 0; i < 3; i++) {
                    this.inventory.remove("health potion");
                }
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + this.getName() + " received 6GP.  You now have a total of " + this.getCurrency() + " gold coins and " + countPotion() + " potions. **");
                sellPotions(chooseDifficulty);
            }
        }else if (potionSell.startsWith("N") || potionSell.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitPotionShop(chooseDifficulty);
        }
        return countPotion();
    }

    @Override
    public int buyPotions(Character chooseDifficulty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many potions are you wanting to buy?");
        System.out.println("1 Potion = 3GP *** 3 Potions = 6GP *** Nevermind");
        String potionBuy = scanner.nextLine();
        if (potionBuy.startsWith("1")){
            if (this.getCurrency() >= 3) {
                this.inventory.add("health potion");
                this.setCurrency(this.getCurrency() - 3);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + this.getName() + " now has " + countPotion() + " potions and " + this.getCurrency() + " gold coins. **");
                buyPotions(chooseDifficulty);
            } else if (this.getCurrency() < 3) {
                System.out.println("It looks as though you don't have enough money.");
                buyPotions(chooseDifficulty);
            }

        } else if (potionBuy.startsWith("3")) {
            if (this.getCurrency() >= 6) {
                for(int i = 0; i <= 3; i++) {
                    this.inventory.add("health potion");
                }
                this.setCurrency(this.getCurrency() - 6);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + this.getName() + " now has " + countPotion() + " potions and " + this.getCurrency() + " gold coins. **");
                buyPotions(chooseDifficulty);
            } else if (this.getCurrency() < 6) {
                System.out.println("It looks as though you don't have enough money. I have kids to feed!");
                buyPotions(chooseDifficulty);
            }
        } else if (potionBuy.startsWith("N") || potionBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitPotionShop(chooseDifficulty);
        }
        return countPotion();
    }

    @Override
    public int attackEnemy(Character chooseDifficulty) {
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
        checkHealth(chooseDifficulty);
        enemyHeal(chooseDifficulty);
        return Enemy.getHealth();
    }

    @Override
    public int checkHealth(Character chooseDifficulty) {
        if (this.getHealth() <= 0) {
            System.out.println(this.getName() + " has been defeated!");
            this.setHealth(this.getMaxHealth());
            this.setMagicPower(getMaxMagicPower());
            Enemy.setHealth(Enemy.getMaxHealth());
            visitInn(chooseDifficulty);
        }else if(Enemy.getHealth() <= 0){
            System.out.println("Enemy has been defeated!");
            lootEnemy();
            Enemy.setHealth(Enemy.getMaxHealth());
            exploreTown(chooseDifficulty);
            //What do you do after defeating the enemy? Enter the Cave
//            visitMarket();
        }
        return this.getMaxHealth();
    }



    /**specific Methods for the Mage Specs **/

    @Override
    public int rest(Character chooseDifficulty) {
        System.out.println("ZZZ");
        System.out.println("ZZZZZZZZ");
        this.setHealth(this.getMaxHealth());
        this.setMagicPower(this.getMaxMagicPower());
        System.out.println("** " + this.getName() + "'s health is now at " + this.getHealth());
        System.out.println("You look well rested!  Good luck out there!");
        System.out.println("Your health is now " + this.getMaxHealth());
        exploreTown(chooseDifficulty);
        return this.getHealth();
    }

    @Override
    public String battleChoices(Character chooseDifficulty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("|**| Attack |**| Potion |** Spells |**| Run |**|");

        String battleChoice = scanner.nextLine();
        if (battleChoice.startsWith("A") || battleChoice.startsWith("a")) {
            attackEnemy(chooseDifficulty);

        } else if (battleChoice.startsWith("P") || battleChoice.startsWith("p")) {
            usePotion(chooseDifficulty);
            //enemyHeal();

        }else if(battleChoice.startsWith("S") || battleChoice.startsWith("s")){
            this.castFire(chooseDifficulty);
            checkHealth(chooseDifficulty);
//            enemyHeal();

        }else if (battleChoice.startsWith("R") || battleChoice.startsWith("r")) {
            Enemy.setHealth(25);
            exploreTown(chooseDifficulty);
        }
        return battleChoice;
    }

    @Override
    public int lootEnemy() {
        int randomNum = (int) (Math.random() * 6);
        if (randomNum == 1 || randomNum == 3 || randomNum == 5) {
            System.out.println("** Enemy has dropped 3 Gold **");
            System.out.println();
            this.setCurrency(this.getCurrency() + 3);
        } else if (randomNum == 2 || randomNum == 4) {
            System.out.println("** Enemy has dropped 5 Gold **");
            System.out.println();
            this.setCurrency(this.getCurrency() + 5);
        } else if (randomNum == 0) {
            System.out.println("** Enemy has dropped a health potion **");
            this.inventory.add("health potion");
            System.out.println();
        }
        return this.getHealth();
    }

    @Override
    public String sellWeapons() {
        return "Currently unavailable";
    }

    @Override
    public int buyWeapons(Character chooseDifficulty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ah! Here is our selection of wonderful killing devices.");
        System.out.println("Warriors Double Sided Battle Axe = 15GP (+5 Attack)");
        System.out.println("Magical Magic Stick of Magic = 15GP (+3 Attack & +5 Health)");
        System.out.println("Nevermind");
        String weaponBuy = scanner.nextLine();
        if (weaponBuy.startsWith("W") || weaponBuy.startsWith("w")) {
            System.out.println("I'm afraid you are unable to handle this weapon.");
            visitWeaponShop(chooseDifficulty);
        }else if (weaponBuy.startsWith("M") || weaponBuy.startsWith("m")) {
            if (this.getCurrency() >= 15) {
                System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                receiveMageStaff();
                visitWeaponShop(chooseDifficulty);
            } else if (this.getCurrency() < 15) {
                System.out.println("You are too poor for this right now.");
                visitWeaponShop(chooseDifficulty);
            }
        } else if (weaponBuy.startsWith("N") || weaponBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitWeaponShop(chooseDifficulty);
        }
        return this.getAttack();
    }



/**--------Mage Specific Methods--------**/

    private int receiveMageStaff(){
        this.setAttack(4);
        this.setMaxHealth(this.getMaxHealth() + 3);
        this.setHealth(this.getMaxHealth());
        this.setCurrency(this.getCurrency()- 15);
        System.out.println("** " + this.getName() + " received the Magical Magic Stick of Magic. **");
        System.out.println("** Attack Damage is now: " + this.getAttack() + ". You have a total of " + this.getCurrency() + " gold coins. **");
        System.out.println("** " + this.getName() + "'s health has increased to " + this.getHealth() + " **");
        return this.getAttack();
    }

    public void castFire(Character chooseDifficulty) {
        if (this.magicPower >= 5) {
            this.setMagicPower(this.getMagicPower() - fireCost);
            System.out.println(this.getName() + " cast FIRE for a total of " + this.fireDamage + " damage");
            Enemy.setHealth(Enemy.getHealth() - fireDamage);
            System.out.println("You have " + this.getMagicPower() + " Magic Power left.");
            System.out.println(Enemy.getName() + " health is now at " + Enemy.getHealth());
            checkHealth(chooseDifficulty);
            enemyHeal(chooseDifficulty);
        } else if (this.magicPower < 5){
            System.out.println("You do not have enough Magic Power");
            battleChoices(chooseDifficulty);
        }

        checkHealth(chooseDifficulty);

    }

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

    public List<String> getInventory() {
        return inventory;
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


    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    public void setMage(boolean mage) {
        this.mage = mage;
    }
}