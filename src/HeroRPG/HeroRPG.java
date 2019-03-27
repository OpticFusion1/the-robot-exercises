package HeroRPG;
import java.util.Scanner;

public class HeroRPG {
    public static Scanner scanner = new Scanner(System.in);
    private static Hero Bowie = new Hero("Bowie", 20, 2, 2, 3, 100, false, false);
    public static Enemy Monster = new Enemy(20, 5);
    public static void main(String[] args) {


        boolean gameInPlay = true;
        do{
            System.out.println("Hello, hero!  Welcome to Arcadia.  What do I have the pleasure of calling you?");
            Bowie.setHeroName(scanner.nextLine());
            System.out.println("hmm.. " + Bowie.getHeroName() + ". That is an interesting name, but what is a name after all?");
            System.out.println("Anyway, Arcadia can use all the heroes it can find!  We need a brave hero to take on the monsters around the town!");
            System.out.println("I hope we can count on you!");
/** Hero Difficulty **/
            selectDifficulty();
            System.out.println("Excellent! Now, let's get you properly equipped.  What is your preferred study of the arts?  Warrior or Mage?");
            String heroSpec = scanner.nextLine();
/** Warrior Spec **/
            if (heroSpec.startsWith("W") || heroSpec.startsWith("w")) {
                specWarrior();

/** Mage Spec **/
            }else if (heroSpec.startsWith("M") || heroSpec.startsWith("m")) {
                specMage();
            }
            getHeroRecap();

            System.out.println("Are you ready to continue?");
            System.out.println("CONTINUE *** START OVER");
            String leaveArea = scanner.nextLine();
            if (leaveArea.startsWith("C") || leaveArea.startsWith("c")) {
                System.out.println("*** " + Bowie.getHeroName() + " has left the castle of Arcadia ***");

                visitMarket();

            } else if (leaveArea.startsWith("S") || leaveArea.startsWith("s")) {
                System.out.println("Let's give this another try");
            }

        }while(gameInPlay); //game is currently always in play

    } /** THIS IS THE MAIN **/


    private static void selectDifficulty(){
        System.out.println("To get started how strong do you think you are? The Strongest|Pretty Strong|Not Strong (difficulty level)");
        String heroStrength = scanner.nextLine();
        if (heroStrength.startsWith("T") || heroStrength.startsWith("t")){
            Bowie.setHeroHealth(Bowie.getHeroHealth() - 10);
        } else if (heroStrength.startsWith("P") || heroStrength.startsWith("p")) {
            Bowie.setHeroHealth(Bowie.getHeroHealth() - 5);
        }
    }

    private static void specWarrior(){
            System.out.println("Ah.  A warrior.  I should have known from your huge battle axe.  Let's get you something a little nicer though.");
            System.out.println("** " + Bowie.getHeroName() + " has received the Hero's Axe **");
            System.out.println("** Attack has increased from " + Bowie.getHeroAttack() + " to 5");
            System.out.println("Here are a few potions to help you as well");
            System.out.println("** " + Bowie.getHeroName() + " has received " + Bowie.getPotionCount() + " potions ***");
            Bowie.setWarrior(true);
            Bowie.setHeroAttack(5);
            Bowie.setHeroPotion(4);
            Bowie.setHeroHealth(25);
    }

    private static void specMage(){
        System.out.println("Ah of course.  Who doesn't love a good spell?  You need a good staff to go with your spells though.");
        System.out.println("** " + Bowie.getHeroName() + " has received the Hero's Staff **");
        System.out.println("** Attack has increased from " + Bowie.getHeroAttack() + " to 3");
        System.out.println("You also have the knowledge to use these more potent Health Potions");
        System.out.println("** " + Bowie.getHeroName() + " has received the ability to use Mage Health Potions **");
        System.out.println("** " + Bowie.getHeroName() + " received 2 extra potions **");
        Bowie.setMage(true);
        Bowie.setHeroAttack(3);
        Bowie.setHeroPotion(5);
        Bowie.setPotionCount(7);
    }

    private static void getHeroRecap(){
        System.out.println("Here are some gold coins to get you started around town.");
        System.out.println("** " + Bowie.getHeroName() + " received " + Bowie.getGoldPoint() + " gold coins. **");
        System.out.println();

        System.out.println("Perfect!  Let's take a look at you!");
        System.out.println("Your health is currently: " + Bowie.getHeroHealth());
        System.out.println("You have a damage amount of " + Bowie.getHeroAttack());
        System.out.println("You currently have " + Bowie.getPotionCount() + " potions");
        System.out.println("You currently have " + Bowie.getGoldPoint() + " gold coins");

        System.out.println();
        System.out.println("Now that you are ready, you can explore the town and hopefully save Arcadia!");
        System.out.println("Good Luck " + Bowie.getHeroName() + "!");
    }

    private static void visitMarket(){
        System.out.println("*** " + Bowie.getHeroName() + " finds himself in town.  There are a number of shops to choose from. ***");
        System.out.println("|***| Potion Shop |**| Weapon Shop |**| Inn |**|");
        System.out.println("You may also leave town.  Where would you like to go?");
/**visit potion shop **/
        String heroChoice = scanner.nextLine();
        if (heroChoice.startsWith("P") || heroChoice.equalsIgnoreCase("p")) {
            System.out.println("Welcome to the Potion Shop!");
            System.out.println("We have a number of options when it comes to potions.");
            visitPotionShop();
/**visit weapon shop **/
        } else if (heroChoice.startsWith("W") || heroChoice.equalsIgnoreCase("w")) {
            System.out.println("Welcome to the Weapon Shop!");
            System.out.println("We have plenty of things you can use for stabbing.");
            visitWeaponShop();
/** visit Inn **/
        } else if (heroChoice.startsWith("I") || heroChoice.equalsIgnoreCase("INN")) {
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
        if (potionBuy.startsWith("1 Potion") || potionBuy.equalsIgnoreCase("1 potion")) {
            if (Bowie.getGoldPoint() >= 3) {
                Bowie.setPotionCount(Bowie.getPotionCount() + 1);
                Bowie.setGoldPoint(Bowie.getGoldPoint() - 3);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + Bowie.getHeroName() + " now has " + Bowie.getPotionCount() + " potions and " + Bowie.getGoldPoint() + " gold coins. **");
            } else if (Bowie.getGoldPoint() < 3) {
                System.out.println("It looks as though you don't have enough money. I have kids to feed!");
            }
        } else if (potionBuy.startsWith("3 Potions") || potionBuy.equalsIgnoreCase("3 potions")) {
            if (Bowie.getGoldPoint() >= 6) {
                Bowie.setPotionCount(Bowie.getPotionCount() + 3);
                Bowie.setGoldPoint(Bowie.getGoldPoint() - 6);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + Bowie.getHeroName() + " now has " + Bowie.getPotionCount() + " potions and " + Bowie.getGoldPoint() + " gold coins. **");
            } else if (Bowie.getGoldPoint() < 6) {
                System.out.println("It looks as though you don't have enough money. I have kids to feed!");
            }
        } else if (potionBuy.startsWith("N") || potionBuy.equalsIgnoreCase("nevermind")) {
            System.out.println("Aw! Maybe next time");

        }
        visitPotionShop();
    }

    private static void sellPotions(){
        System.out.println("What do you have to sell?");
        System.out.println("1 Potion = 2GP ** 3 Potions ** 6GP ** Nevermind");
        String potionSell = scanner.nextLine();
        if (potionSell.startsWith("1 Potion") || potionSell.equalsIgnoreCase("1 potion")) {
            if (Bowie.getPotionCount() >= 1) {
                Bowie.setGoldPoint(Bowie.getGoldPoint() + 2);
                Bowie.setPotionCount(Bowie.getPotionCount() - 1);
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + Bowie.getHeroName() + " received 2GP.  You now have a total of: " + Bowie.getGoldPoint() + " gold coins and " + Bowie.getPotionCount() + " potions. **");
            } else if (Bowie.getPotionCount() < 1) {
                System.out.println("Hey! What are you trying to pull.  You don't have any potions!");
            }
        } else if (potionSell.startsWith("3 Potions") || potionSell.equalsIgnoreCase("3 potions")) {
            if (Bowie.getPotionCount() >= 3) {
                Bowie.setGoldPoint(Bowie.getGoldPoint() + 6);
                Bowie.setPotionCount(Bowie.getPotionCount() - 3);
                System.out.println("Hey thanks!  Here is your money");
                System.out.println("** " + Bowie.getHeroName() + " received 6GP.  You now have a total of " + Bowie.getGoldPoint() + " gold coins and " + Bowie.getPotionCount() + " potions. **");
            }
        } else if (potionSell.startsWith("N") || potionSell.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
        }
        visitPotionShop();
    }

    private static void visitWeaponShop(){
        System.out.println("What do you want?");
        System.out.println("BUY ** SELL ** LEAVE");
        String weaponChoice = scanner.nextLine();

        if (weaponChoice.startsWith("Buy") || weaponChoice.startsWith("buy")) {
            buyWeapons();

        } else if (weaponChoice.startsWith("Sell") || weaponChoice.equalsIgnoreCase("sell")) {
            System.out.println("We are currently unable to buy items.  Check back soon!");
            visitWeaponShop();

        } else if (weaponChoice.startsWith("Leave") || weaponChoice.equalsIgnoreCase("leave")) {
            visitMarket();
        }

    }

    private static void buyWeapons(){
        System.out.println("Ah! Here is our selection of wonderful killing devices.");
        System.out.println("Double Sided Battle Axe = 15GP (+5 Attack) *** Magical Magic Stick of Magic = 15GP (+3 Attack & +5 Health) ** Nevermind");
        String weaponBuy = scanner.nextLine();
        if (weaponBuy.startsWith("D") || weaponBuy.startsWith("d")) {
            if (Bowie.getGoldPoint() >= 15 && Bowie.isWarrior()) {
                Bowie.setHeroAttack(8);
                Bowie.setGoldPoint(Bowie.getGoldPoint() - 15);
                System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                System.out.println("** " + Bowie.getHeroName() + " now has a Double Sided Battle Axe.  Attack Damage is now: " + Bowie.getHeroAttack() + ". You have a total of " + Bowie.getGoldPoint() + " gold coins. **");
            } else if (Bowie.getGoldPoint() < 15 || !Bowie.isWarrior()) {
                System.out.println("I'm afraid you are unable to handle this weapon.");
            }
        } else if (weaponBuy.startsWith("M") || weaponBuy.equalsIgnoreCase("m")) {
            if (Bowie.getGoldPoint() >= 15 && Bowie.isMage()) {
                Bowie.setHeroAttack(6);
                Bowie.setHeroHealth(25);
                Bowie.setGoldPoint(Bowie.getGoldPoint() - 15);
                System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                System.out.println("** " + Bowie.getHeroName() + " received the Magical Magic Stick of Magic. **");
                System.out.println("** Attack Damage is now: " + Bowie.getHeroAttack() + ". You have a total of " + Bowie.getGoldPoint() + " gold coins. **");
                System.out.println("** " + Bowie.getHeroName() + "'s health is now at " + Bowie.getHeroHealth() + " **");
            } else if (Bowie.getGoldPoint() < 15 || !Bowie.isMage()) {
                System.out.println("I'm afraid you cannot handle this weapon.");
            }
        } else if (weaponBuy.startsWith("N") || weaponBuy.equalsIgnoreCase("nevermind")) {
            System.out.println("Aw! Maybe next time");
        }
        visitWeaponShop();
    }

    private static void visitInn(){
        System.out.println("Welcome to the Inn, wary hero!");
        System.out.println("Please take some time to rest. There is no charge");
        System.out.println("REST ** LEAVE");
        String innChoice = scanner.nextLine();
        if (innChoice.startsWith("R") || innChoice.startsWith("r")) {
            System.out.println("Come and lay down.  A hero like you needs all the rest they can get.  Do not worry about payment.");
            System.out.println("ZZZ");
            System.out.println("ZZZZZZZZ");
            Bowie.setHeroHealth(25);
            System.out.println("** " + Bowie.getHeroName() + "'s health is now at " + Bowie.getHeroHealth());
            System.out.println("You look well rested!  Good luck out there!");
        }
        visitMarket();
    }

    private static void enterCave(){
        System.out.println("As " + Bowie.getHeroName() + " leaves town, he spends some time wandering the country side.");
        System.out.println("Eventually he comes across a cave guarded by troll.");
        System.out.println("With no other way around and not the brightest when it comes to riddles " + Bowie.getHeroName() + " figures he better try to kill the troll to get across.");
        System.out.println();
        battleMonster(); //if rebattling monster health does not change.
    }

    private static void battleMonster(){
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("|**| Attack |**| Potion |**| Run |**|");

            String battleChoice = scanner.nextLine();
            if (battleChoice.startsWith("A") || battleChoice.startsWith("a")) {
                attackEnemy();

            } else if (battleChoice.startsWith("P") || battleChoice.startsWith("p")){
                usePotion();

            }else if(battleChoice.startsWith("R") || battleChoice.startsWith("r")){
                Monster.setEnemyHealth(20);
                visitMarket();
            }
    }

    private static void attackEnemy(){
        int randomNum = (int) (Math.random() * 6);
        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
            System.out.println();
            System.out.println("** You hit the enemy for " + Bowie.getHeroAttack() + " **");
            Monster.setEnemyHealth(Monster.getEnemyHealth() - Bowie.getHeroAttack());
            System.out.println("Enemy health is now at " + Monster.getEnemyHealth());
        } else if (randomNum == 4) {
            System.out.println("** You hit the enemy for a critical attack of " + Bowie.getHeroAttack() * 2 + " **");
            Monster.setEnemyHealth(Monster.getEnemyHealth() - (Bowie.getHeroAttack() * 2));
            System.out.println("Enemy health is now at " + Monster.getEnemyHealth());
        } else if (randomNum == 1) {
            System.out.println("** The Enemy dodged the attack! **");
            System.out.println("Enemy health is still at " + Monster.getEnemyHealth());
        }
        checkHealth();
        enemyAttack();
    }

    private static void usePotion(){
        if (Bowie.getHeroHealth() < 20 && Bowie.getPotionCount() > 0) {
            Bowie.setPotionCount(Bowie.getPotionCount() - 1);
            Bowie.setHeroHealth(Bowie.getHeroHealth() + Bowie.getHeroPotion());
            System.out.println(Bowie.getHeroName() + " drank a health potion. Health has increased by " + Bowie.getHeroPotion() + ". Health is now at " + Bowie.getHeroHealth());
            System.out.println("You now have " + Bowie.getPotionCount() + " left.");
            System.out.println("The enemies health is at " + Monster.getEnemyHealth());
        } else if (Bowie.getHeroHealth() == 100) {
            System.out.println("You may want to slow down on those potions, you are already at " + Bowie.getHeroHealth() + " health.");
            System.out.println("The enemies health is at " + Monster.getEnemyHealth());
        } else if (Bowie.getPotionCount() == 0) {
            System.out.println("You are out of potions!");
            System.out.println("The enemies health is at " + Monster.getEnemyHealth());
        }
        battleMonster();
    }

    private static void enemyAttack(){
        int randomNum = (int) (Math.random() * 6);
        System.out.println();
        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
            System.out.println();
            System.out.println("** The enemy hit " + Bowie.getHeroName() + " for " + Monster.getEnemyAttack() + " **");
            Bowie.setHeroHealth(Bowie.getHeroHealth() - Monster.getEnemyAttack());
            System.out.println(Bowie.getHeroName() + "'s health is now at " + Bowie.getHeroHealth());
        } else if (randomNum == 4) {
            System.out.println("** The enemy hit " + Bowie.getHeroName() + " for a critical attack of " + Monster.getEnemyAttack() * 2 + " **");
            Bowie.setHeroHealth(Bowie.getHeroHealth() - (Monster.getEnemyAttack() * 2));
            System.out.println(Bowie.getHeroName() + "'s health is now at " + Bowie.getHeroHealth());
        } else if (randomNum == 1) {
            System.out.println("** " + Bowie.getHeroName() + " dodged the attack! **");
            System.out.println(Bowie.getHeroName() + "'s health is still at " + Bowie.getHeroHealth());
        }
        checkHealth();
        battleMonster();
    }

    private static void checkHealth(){
        if (Bowie.getHeroHealth() <= 0) {
            System.out.println(Bowie.getHeroName() + " has been defeated!");
            System.out.println("GAME OVER");
            Bowie.setHeroHealth(25);
            visitInn();
        }else if(Monster.getEnemyHealth() <= 0){
            System.out.println("Enemy has been defeated!");
            lootEnemy();
            Monster.setEnemyHealth(20);
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

