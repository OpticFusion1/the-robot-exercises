package RPG;
import java.util.Scanner;

public class HeroRPG {
    private static Scanner scanner = new Scanner(System.in);
    private static Character Bowie = new Character();
    private static Enemy Monster = new Enemy("Troll", 25, 6, 3, 6);
    private static Mage mage = new Mage();
    private static Warrior warrior = new Warrior();

    public static void main(String[] args) {

        chooseSpec();
        selectDifficulty();
        nameHero();
        checkStats();
        startOver();


    } /** THIS IS THE END OF MAIN **/


    private static void redoHero(){
    Bowie.setName("Hero");
    warrior.setHealth(25);
    warrior.setWarrior(false);
    mage.setHealth(22);
    mage.setMage(false);
    //both classes set to false

    chooseSpec();
    selectDifficulty();
    nameHero();
    checkStats();
    startOver();

}

    private static void chooseSpec(){
        System.out.println("Hello, hero!  Welcome to Arcadia.");
        System.out.println("Our gallant leader has recently gone missing and we need someone to help us locate and possibly save them!");
        System.out.println("Hopefully you are up for some adventure!");
        System.out.println("You are!? Great! Let's get you properly equipped.  What is your preferred class of study?  Warrior or Mage?");
        String heroSpec = scanner.nextLine();
/** Warrior Spec **/
        if (heroSpec.startsWith("W") || heroSpec.startsWith("w")) {
            specWarrior();

/** Mage Spec **/
        }else if (heroSpec.startsWith("M") || heroSpec.startsWith("m")) {
            specMage();
        }
    }

    private static void specWarrior(){

        System.out.println("Ah.  A warrior.  I should have known from your huge battle axe.  Let's get you something a little nicer though.");
        System.out.println("** " + Bowie.getName() + " has received the Hero's Axe **");
        System.out.println("** Attack has increased to " + warrior.getAttack());
        System.out.println("Here are a few potions to help you as well");
        System.out.println("** " + Bowie.getName() + " has received " + Bowie.getPotionNum() + " potions ***");
        System.out.println("Here are a few gold coins to get you started");
        System.out.println("** " + Bowie.getName() + " received " + Bowie.getGoldPoint() + " gold coins. **");
        mage.setMage(false);
        Bowie = warrior;
//        Bowie.setWarrior(true);
//        Bowie.setAttack(5);
//        Bowie.setPotionStrength(4);
//        Bowie.setHealth(25);
    }

    private static void specMage(){
        System.out.println(Bowie);
        Bowie = mage;
        System.out.println("Ah of course.  Who doesn't love a good spell?  You need a good staff to go with your spells though.");
        System.out.println("** " + Bowie.getName() + " has received the Hero's Staff **");
        System.out.println("** Attack has increased to " + mage.getAttack() + " **");
        System.out.println("** " + Bowie.getName() + " learned FIRE spell **");
        System.out.println("Here are a few gold coins to get you started");
        System.out.println("** " + Bowie.getName() + " received " + Bowie.getGoldPoint() + " gold coins. **");
        warrior.setWarrior(false);

        System.out.println(Bowie);


    }

    private static void specPriest(){
        Priest priest = new Priest();
        Bowie = priest;
        System.out.println("A priest, of course, how pious.  Take this staff to aid in your journey.");
        System.out.println("** " + Bowie.getName() + " has received the Hero's Staff **");
        System.out.println("** Attack has increased from " + Bowie.getAttack() + " to 3");
        System.out.println("I can teach you a few prayers to aid you along the way.");
        System.out.println("** " + Bowie.getName() + " has learned the spell SHIELD");
        System.out.println("** " + Bowie.getName() + " has learned the spell BOOST");
    }

    private static void selectDifficulty(){
        System.out.println(Bowie);
        System.out.println("Perfect!  Now, wow skilled would you say you are? (difficulty level)");
        System.out.println("The most skilled, give me a challenge. (Hard)");
        System.out.println("I am willing to be slightly annoyed. (Medium)");
        System.out.println("I need a boost in my self esteem, please. (Easy)");

        String heroStrength = scanner.nextLine();
        if (heroStrength.startsWith("H") || heroStrength.startsWith("h")){
            Bowie.setHealth(Bowie.getHealth() - 10);
        } else if (heroStrength.startsWith("M") || heroStrength.startsWith("m")){
            Bowie.setHealth(Bowie.getHealth() - 5);
        }else if (heroStrength.startsWith("E") || heroStrength.startsWith("e")){
            System.out.println("Just remember to breathe.  Everything will be okay");
        }
    }

    private static void nameHero(){
        System.out.println("Oh!  I almost forgot to get your name.  We need to get started on your epic songs for your return back.");
        Bowie.setName(scanner.nextLine());
//        String heroName = scanner.nextLine();
        System.out.println("hmm.. " + Bowie.getName() + ". That may be a bit difficult to rhyme...");
        System.out.println("No matter!  What is in a name anyway?  I am sure we can make do..");
        System.out.println("Anyway, Arcadia can use all the heroes it can find!  We need a brave hero to take on the monsters around the town!");
        System.out.println("I hope we can count on you!");
//        selectDifficulty();
    }

    private static void checkStats(){
        System.out.println();
        System.out.println("Your health is currently: " + Bowie.getHealth());
        System.out.println("You have a damage amount of " + Bowie.getAttack());
        System.out.println("You currently have " + Bowie.getPotionNum() + " potions");
        System.out.println("You currently have " + Bowie.getGoldPoint() + " gold coins");
        System.out.println();
    }

    private static void startOver(){
        System.out.println("Now that you are ready, you can explore the town and hopefully save Arcadia!");
        System.out.println("Good Luck " + Bowie.getName() + "!");
        System.out.println("Are you ready to continue?");
        System.out.println("CONTINUE *** START OVER");
        String leaveArea = scanner.nextLine();
        if (leaveArea.startsWith("C") || leaveArea.startsWith("c")) {
            System.out.println("*** " + Bowie.getName() + " has left the castle of Arcadia ***");

            visitMarket();

        } else if (leaveArea.startsWith("S") || leaveArea.startsWith("s")) {
            System.out.println("Let's give this another try");
            redoHero();
        }
    }

    private static void getHeroRecap(){
//        System.out.println("Here are some gold coins to get you started around town.");
//        System.out.println("** " + Bowie.getName() + " received " + Bowie.getGoldPoint() + " gold coins. **");
//        System.out.println();
//
//        System.out.println("Perfect!  Let's take a look at you!");
//        System.out.println("Your health is currently: " + Bowie.getHealth());
//        System.out.println("You have a damage amount of " + Bowie.getAttack());
//        System.out.println("You currently have " + Bowie.getPotionNum() + " potions");
//        System.out.println("You currently have " + Bowie.getGoldPoint() + " gold coins");
//
//        System.out.println();
//        System.out.println("Now that you are ready, you can explore the town and hopefully save Arcadia!");
//        System.out.println("Good Luck " + Bowie.getName() + "!");
    }

    private static void visitMarket(){
        System.out.println("*** " + Bowie.getName() + " finds them self in town.  There are a number of shops to choose from. ***");
        System.out.println("|***| Potion Shop |**| Weapon Shop |**| Inn |**|");
        System.out.println("You may also leave town.  Where would you like to go?");
/**visit potion shop **/
        String heroChoice = scanner.nextLine();
        if (heroChoice.startsWith("P") || heroChoice.startsWith("p")) {
            System.out.println("Welcome to the Potion Shop!");
            System.out.println("We have a number of options when it comes to potions.");
            visitPotionShop();
/**visit weapon shop **/
        } else if (heroChoice.startsWith("W") || heroChoice.startsWith("w")) {
            System.out.println("Welcome to the Weapon Shop!");
            System.out.println("We have plenty of things you can use for stabbing.");
            visitWeaponShop();
/** visit Inn **/
        } else if (heroChoice.startsWith("I") || heroChoice.startsWith("i")) {
            visitInn();
        }
        enterCave();
    }

    private static void visitPotionShop(){
            System.out.println("What would you like to do?.");
            System.out.println("BUY ** SELL ** LEAVE");
            String potionChoice = scanner.nextLine();

            if (potionChoice.startsWith("B") || potionChoice.startsWith("b")) {
                buyPotions();

            }else if (potionChoice.startsWith("S") || potionChoice.startsWith("s")) {
                sellPotions();

            } else if (potionChoice.startsWith("L") || potionChoice.startsWith("l")) {
                visitMarket();
            }
    }

    private static void buyPotions(){
        System.out.println("Ah! Great! How many potions are you wanting to buy?");
        System.out.println("1 Potion = 3GP *** 3 Potions = 6GP *** Nevermind");
        String potionBuy = scanner.nextLine();
        if (potionBuy.startsWith("1")){
            if (Bowie.getGoldPoint() >= 3) {
                Bowie.setPotionNum(Bowie.getPotionNum() + 1);
                Bowie.setGoldPoint(Bowie.getGoldPoint() - 3);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + Bowie.getName() + " now has " + Bowie.getPotionNum() + " potions and " + Bowie.getGoldPoint() + " gold coins. **");
            } else if (Bowie.getGoldPoint() < 3) {
                System.out.println("It looks as though you don't have enough money. I have kids to feed!");
            }
        } else if (potionBuy.startsWith("3")) {
            if (Bowie.getGoldPoint() >= 6) {
                Bowie.setPotionNum(Bowie.getPotionNum() + 3);
                Bowie.setGoldPoint(Bowie.getGoldPoint() - 6);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + Bowie.getName() + " now has " + Bowie.getPotionNum() + " potions and " + Bowie.getGoldPoint() + " gold coins. **");
            } else if (Bowie.getGoldPoint() < 6) {
                System.out.println("It looks as though you don't have enough money. I have kids to feed!");
            }
        } else if (potionBuy.startsWith("N") || potionBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");

        }
        visitPotionShop();
    }

    private static void sellPotions(){
        System.out.println("What do you have to sell?");
        System.out.println("1 Potion = 2GP ** 3 Potions ** 6GP ** Nevermind");
        String potionSell = scanner.nextLine();
        if (potionSell.startsWith("1")) {
            if (Bowie.getPotionNum() >= 1) {
                Bowie.setGoldPoint(Bowie.getGoldPoint() + 2);
                Bowie.setPotionNum(Bowie.getPotionNum() - 1);
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + Bowie.getName() + " received 2GP.  You now have a total of: " + Bowie.getGoldPoint() + " gold coins and " + Bowie.getPotionNum() + " potions. **");
            } else if (Bowie.getPotionNum() < 1) {
                System.out.println("Hey! What are you trying to pull.  You don't have any potions!");
            }
        }else if (potionSell.startsWith("3")) {
            if (Bowie.getPotionNum() >= 3) {
                Bowie.setGoldPoint(Bowie.getGoldPoint() + 6);
                Bowie.setPotionNum(Bowie.getPotionNum() - 3);
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + Bowie.getName() + " received 6GP.  You now have a total of " + Bowie.getGoldPoint() + " gold coins and " + Bowie.getPotionNum() + " potions. **");
            }
        }else if (potionSell.startsWith("N") || potionSell.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
        }
        visitPotionShop();
    }

    private static void visitWeaponShop(){
        System.out.println("What do you want?");
        System.out.println("BUY ** SELL ** LEAVE");
        String weaponChoice = scanner.nextLine();

        if (weaponChoice.startsWith("B") || weaponChoice.startsWith("b")) {
            buyWeapons();

        } else if (weaponChoice.startsWith("S") || weaponChoice.startsWith("s")) {
            System.out.println("We are currently unable to buy items.  Check back soon!");
            visitWeaponShop();

        } else if (weaponChoice.startsWith("L") || weaponChoice.startsWith("l")) {
            visitMarket();
        }

    }

    private static void buyWeapons(){
        //methods for items specific to class
        System.out.println("Ah! Here is our selection of wonderful killing devices.");
        System.out.println("Warriors Double Sided Battle Axe = 15GP (+5 Attack)");
        System.out.println("Magical Magic Stick of Magic = 15GP (+3 Attack & +5 Health)");
        System.out.println("Nevermind");
        String weaponBuy = scanner.nextLine();
        if (weaponBuy.startsWith("W") || weaponBuy.startsWith("w")) {
            if (Bowie.getGoldPoint() >= 15 && warrior.isWarrior()) {
                receiveWarriorAxe();
                System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
            } else if (Bowie.getGoldPoint() < 15 || !warrior.isWarrior()) {
                System.out.println("I'm afraid you are unable to handle this weapon.");
            }
        } else if (weaponBuy.startsWith("M") || weaponBuy.startsWith("m")) {
            if (Bowie.getGoldPoint() >= 15 && mage.isMage()) {
                System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                receiveMageStaff();

            } else if (Bowie.getGoldPoint() < 15 || !mage.isMage()) {
                System.out.println("I'm afraid you cannot handle this weapon.");
            }
        } else if (weaponBuy.startsWith("N") || weaponBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
        }
        visitWeaponShop();
    }

    private static void receiveMageStaff(){
        Bowie.setAttack(6);
        Bowie.setHealth(25);
        Bowie.setGoldPoint(Bowie.getGoldPoint() - 15);
        System.out.println("** " + Bowie.getName() + " received the Magical Magic Stick of Magic. **");
        System.out.println("** Attack Damage is now: " + Bowie.getAttack() + ". You have a total of " + Bowie.getGoldPoint() + " gold coins. **");
        System.out.println("** " + Bowie.getName() + "'s health is now at " + Bowie.getHealth() + " **");
    }

    private static void receiveWarriorAxe(){
        Bowie.setAttack(8);
        Bowie.setGoldPoint(Bowie.getGoldPoint() - 15);
        System.out.println("** " + Bowie.getName() + " now has a Double Sided Battle Axe.  " +
                "Attack Damage is now: " + Bowie.getAttack() + ". You have a total of " + Bowie.getGoldPoint() + " gold coins. **");
    }

    private static void visitInn(){
        System.out.println("Welcome to the Inn, wary hero!");
        System.out.println("Please take some time to rest. There is no charge");
        System.out.println("REST ** LEAVE");
        String innChoice = scanner.nextLine();
        if (innChoice.startsWith("R") || innChoice.startsWith("r")) {
            System.out.println("ZZZ");
            System.out.println("ZZZZZZZZ");
            Bowie.setHealth(25);
            System.out.println("** " + Bowie.getName() + "'s health is now at " + Bowie.getHealth());
            System.out.println("You look well rested!  Good luck out there!");
        }
        visitMarket();
    }

    private static void enterCave(){
        System.out.println("As " + Bowie.getName() + " leaves town, he spends some time wandering the country side.");
        System.out.println("Eventually he comes across a cave guarded by troll.");
        System.out.println("With no other way around and not the brightest when it comes to riddles " + Bowie.getName() + " figures he better try to kill the troll to get across.");
        System.out.println();
        battleMonster();
    }

    static void battleMonster() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("|**| Attack |**| Potion |** Spells |**| Run |**|");

        String battleChoice = scanner.nextLine();
        if (battleChoice.startsWith("A") || battleChoice.startsWith("a")) {
            attackEnemy();

        } else if (battleChoice.startsWith("P") || battleChoice.startsWith("p")) {
            usePotion();

        }else if((battleChoice.startsWith("S") || battleChoice.startsWith("s")) && mage.isMage()){
            mage.castFire();
            checkHealth();
            enemyHeal();

        }else if (battleChoice.startsWith("R") || battleChoice.startsWith("r")) {
            Monster.setHealth(25);
            visitMarket();
        }

    }

    private static void attackEnemy(){
        int randomNum = (int) (Math.random() * 6);
        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
            System.out.println();
            System.out.println("** You hit the enemy for " + Bowie.getAttack() + " **");
            Monster.setHealth(Monster.getHealth() - Bowie.getAttack());
            System.out.println("Enemy health is now at " + Monster.getHealth());
        } else if (randomNum == 4) {
            System.out.println("** You hit the enemy for a critical attack of " + Bowie.getAttack() * 2 + " **");
            Monster.setHealth(Monster.getHealth() - (Bowie.getAttack() * 2));
            System.out.println("Enemy health is now at " + Monster.getHealth());
        } else if (randomNum == 1) {
            System.out.println("** The Enemy dodged the attack! **");
            System.out.println("Enemy health is still at " + Monster.getHealth());
        }
        checkHealth();
        enemyHeal();

    }

    private static void usePotion(){
        if (Bowie.getHealth() < 20 && Bowie.getPotionNum() > 0) {
            Bowie.setPotionNum(Bowie.getPotionNum() - 1);
            Bowie.setHealth(Bowie.getHealth() + Bowie.getPotionStrength());
            System.out.println(Bowie.getName() + " drank a health potion. Health has increased by " + Bowie.getPotionStrength() + ". Health is now at " + Bowie.getHealth());
            System.out.println("You now have " + Bowie.getPotionNum() + " left.");
            System.out.println("The enemies health is at " + Monster.getHealth());
        } else if (Bowie.getHealth() == 100) {
            System.out.println("You may want to slow down on those potions, you are already at " + Bowie.getHealth() + " health.");
            System.out.println("The enemies health is at " + Monster.getHealth());
        } else if (Bowie.getPotionNum() == 0) {
            System.out.println("You are out of potions!");
            System.out.println("The enemies health is at " + Monster.getHealth());
        }
        enemyHeal();
    }

    private static void enemyAttack(){
        int randomNum = (int) (Math.random() * 6);
        System.out.println();
        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
            System.out.println();
            System.out.println("** The enemy hit " + Bowie.getName() + " for " + Monster.getAttack() + " **");
            Bowie.setHealth(Bowie.getHealth() - Monster.getAttack());
            System.out.println(Bowie.getName() + "'s health is now at " + Bowie.getHealth());
        } else if (randomNum == 4) {
            System.out.println("** The enemy hit " + Bowie.getName() + " for a critical attack of " + Monster.getAttack() * 2 + " **");
            Bowie.setHealth(Bowie.getHealth() - (Monster.getAttack() * 2));
            System.out.println(Bowie.getName() + "'s health is now at " + Bowie.getHealth());
        } else if (randomNum == 1) {
            System.out.println("** " + Bowie.getName() + " dodged the attack! **");
            System.out.println(Bowie.getName() + "'s health is still at " + Bowie.getHealth());
        }
        checkHealth();
        battleMonster();
    }

    private static void enemyHeal(){
        if (Monster.getHealth() <= 10 && Monster.getPotionNum() > 0) {
            Monster.setPotionNum(Monster.getPotionNum() - 1);
            Monster.setHealth(Monster.getHealth() + Monster.getPotionStrength());
            System.out.println();
            System.out.println(Monster.getName() + " used heal.");
            System.out.println(Monster.getName() + " has been healed for " + Monster.getPotionStrength());
            System.out.println(Monster.getName() + "'s health is now at " + Monster.getHealth());
            battleMonster();
        } else if (Monster.getHealth() > 10 || Monster.getPotionNum() == 0){
            enemyAttack();
        }
    }

    private static void checkHealth(){
        if (Bowie.getHealth() <= 0) {
            System.out.println(Bowie.getName() + " has been defeated!");
//            System.out.println("GAME OVER");
            Bowie.setHealth(25);
            visitInn();
        }else if(Monster.getHealth() <= 0){
            System.out.println("Enemy has been defeated!");
            lootEnemy();
            Monster.setHealth(20);
            //What do you do after defeating the enemy? Enter the Cave
            visitMarket();
        }
    }

    private static void lootEnemy(){
        int randomNum = (int) (Math.random() * 6);
        if (randomNum == 1 || randomNum == 3) {
            System.out.println("** Enemy has dropped 3 Gold **");
            System.out.println();
            Bowie.setGoldPoint(Bowie.getGoldPoint() + 3);
        } else if (randomNum == 2 || randomNum == 4) {
            System.out.println("** Enemy has dropped 5 Gold **");
            System.out.println();
            Bowie.setGoldPoint(Bowie.getGoldPoint() + 5);
        } else if (randomNum == 0) {
            System.out.println("** Enemy has dropped NEW ITEM **");
            System.out.println();
        }
    }




}//end of class HeroRPG.HeroRPG

