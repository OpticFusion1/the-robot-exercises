package RPG;
import java.util.Scanner;

public class HeroRPG {
    public static void main(String[] args) {
//        boolean redoHero = true;
//        do {
            Scanner readName = new Scanner(System.in);
            System.out.println("Hello, traveller.  Welcome to Arcadia.");
            System.out.println("Our leader has recently gone missing.  We need someone to venture out and locate them.");
            System.out.println("What is your name?");
            String userName = readName.nextLine();
            System.out.println();

            Scanner readRole = new Scanner(System.in);
            System.out.println(userName + "..hmm");
            System.out.println("Interesting name.  Well, I'm sure we can find a way to make it rhyme in an epic song if you succeed.");
            System.out.println("What is your desired field of study?");
            System.out.println("|**| Mage |**| Warrior |**|");
            String userRole = readRole.nextLine();
            chooseClass(userRole, userName);
            System.out.println();

            Scanner readDifficulty = new Scanner(System.in);
            System.out.println("Perfect!  Now, how skilled would you say you are? (difficulty level)");
            System.out.println("The most skilled, give me a challenge. (Hard)");
            System.out.println("I am willing to be slightly annoyed. (Medium)");
            System.out.println("I need a boost in my self esteem, please. (Easy)");
            String userDifficulty = readDifficulty.nextLine();
            chooseDifficulty(userDifficulty, chooseClass(userRole, userName));
            System.out.println();

            System.out.println("All right.  Let's take a look at you.");
            inspectSelf(chooseDifficulty(userDifficulty, chooseClass(userRole,userName)));
            System.out.println();

//            Scanner readRedo = new Scanner(System.in);
            System.out.println("Wonderful!  I think you are ready to begin your journey.");
//            System.out.println("Did you want to start over?");
//            System.out.println("Y/N");
//            String userRedo = readRedo.nextLine();
//            if(userRedo.startsWith("N") || userRedo.startsWith("n")){
//                redoHero = false;
//            }
//
//        }while(redoHero);

        System.out.println("** Welcome to Arcadia! **");
        exploreTown(chooseDifficulty(userDifficulty, chooseClass(userRole,userName)));

        Enemy troll = new Enemy("Troll",25, 25, 5, 3, 5);
        Scanner playRiddle = new Scanner(System.in);
        System.out.println("***" + userName + " leaves town ***");
        System.out.println("***" + userName + " comes across a cave guarded by troll.");
        System.out.println("Troll: Greetings, hero!  I see you are wanting to pass through this cave.");
        System.out.println("Troll: If you can answer three riddles correctly, then I will let you pass.");
        System.out.println("Troll: If you fail, however, then I eat you.");
        System.out.println("Troll: Deal?");
        System.out.println("Y/N");
        String riddleChoice = playRiddle.nextLine();
        playRiddle(riddleChoice, chooseClass(userRole, userName));
        System.out.println();




    } /** THIS IS THE END OF MAIN **/

    private static void giveRiddles(Character chooseClass){
        Scanner riddleAnswer = new Scanner(System.in);
        System.out.println("Voiceless is cries,");
        System.out.println("Wingless flutters,");
        System.out.println("Toothless bites,");
        System.out.println("Mouthless mutters.");
        String riddleAnswer1 = riddleAnswer.nextLine();
        if(riddleAnswer1.equalsIgnoreCase("Wind")){
            System.out.println("Troll: hmm.. quite wise.. you are correct.");
            System.out.println("Alive without breath,");
            System.out.println("As cold as death,");
            System.out.println("Never thirsty, ever drinking,");
            System.out.println("All in mail never clinking.");
            String riddleAnswer2 = riddleAnswer.nextLine();
            if(riddleAnswer2.equalsIgnoreCase("Fish")){
                System.out.println("Troll: ....You are too good at this, again, you are correct.");
                System.out.println("What has roots as nobody sees,");
                System.out.println("Is taller than trees,");
                System.out.println("Up, up it goes,");
                System.out.println("And yet never grows?");
                String riddleAnswer3 = riddleAnswer.nextLine();
                if(riddleAnswer3.equalsIgnoreCase("Mountain")){
                    System.out.println("Troll: UGH!  How! ...stupid hero.  Okay.  Last one!");
                    System.out.println("Troll: I know I said three, but let's see how smart you really are..");
                    System.out.println("What have I got in my pocket?");
                    String riddleAnswer4 = riddleAnswer.nextLine();
                    if(riddleAnswer4.equalsIgnoreCase("Ring")){
                        System.out.println("Troll: .....");
                        System.out.println("Troll: ... someone is quite the reader.  All right.  Time to kill you.  I'm afraid I lied..");
                        System.out.println("Troll: Can't have someone so good at riddles roaming the land.");
                        chooseClass.battleChoices(chooseClass);
                    }else{
                        System.out.println("Troll: You should really read the classics, you tricksy hero");
                        chooseClass.battleChoices(chooseClass);
                    }
                }else{
                    System.out.println("Troll: I'm afraid you are wrong.  This is going to be a good fight");
                    chooseClass.battleChoices(chooseClass);
                }
            }else{
                System.out.println("Troll: So close.  This is going to be fun.");
               chooseClass.battleChoices(chooseClass);
            }

        }else{
            System.out.println("Troll: Aw, that's a shame.  Looks like you are wrong.  Get ready to die, dummy");
            chooseClass.battleChoices(chooseClass);
        }
    }

    public static void playRiddle(String riddleChoice, Character chooseClass){
        if(riddleChoice.startsWith("y") || riddleChoice.startsWith("Y")){
            giveRiddles(chooseClass);
        }else {
            System.out.println("Troll: Aw you are no fun.  Killing you will be fun.");
            chooseClass.battleChoices(chooseClass);
        }
    }

    public static void exploreTown(Character chooseClass) {
    System.out.println("There are number of shops within town.  Which shop would you like to visit?");
    System.out.println("|***| Potion Shop |***|");
    System.out.println("|***| Weapon Shop |***|");
    System.out.println("|***|     Inn     |***|");
    System.out.println("|***|  Leave Town |***|");
    visitShop(chooseClass);
}

    public static String visitShop(Character chooseClass){
            Scanner readShopChoice = new Scanner(System.in);
            String shopChoice = readShopChoice.nextLine();
/**visit potion shop **/
        if (shopChoice.startsWith("P") || shopChoice.startsWith("p")) {
            System.out.println("Welcome to the Potion Shop!");
            System.out.println("We have a number of options when it comes to potions.");
            return visitPotionShop(chooseClass);
/**visit weapon shop **/
        } else if (shopChoice.startsWith("W") || shopChoice.startsWith("w")) {
            System.out.println("Welcome to the Weapon Shop!");
            System.out.println("We have plenty of things you can use for stabbing.");
            return visitWeaponShop(chooseClass);
/** visit Inn **/
        } else if (shopChoice.startsWith("I") || shopChoice.startsWith("i")) {
            System.out.println("Welcome to the Inn, wary hero!");
            System.out.println("Please take some time to rest. There is no charge");
            return visitInn(chooseClass);
        }

        return shopChoice;
}

    public static String visitPotionShop(Character chooseClass){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?.");
        System.out.println("BUY ** SELL ** LEAVE");
        String potionChoice = scanner.nextLine();

        if (potionChoice.startsWith("B") || potionChoice.startsWith("b")) {
            buyPotions(chooseClass);

        }else if (potionChoice.startsWith("S") || potionChoice.startsWith("s")) {
            chooseClass.sellPotions(chooseClass);

        } else if (potionChoice.startsWith("L") || potionChoice.startsWith("l")) {
            exploreTown(chooseClass);
        }

        return potionChoice;
    }

    public static void buyPotions(Character chooseClass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many potions are you wanting to buy?");
        System.out.println("1 Potion = 3GP *** 3 Potions = 6GP *** Nevermind");
        String potionBuy = scanner.nextLine();
        if (potionBuy.startsWith("1")){
            if (chooseClass.getCurrency() >= 3) {
                chooseClass.setPotionNum(chooseClass.getPotionNum() + 1);
                chooseClass.setCurrency(chooseClass.getCurrency() - 3);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + chooseClass.getName() + " now has " + chooseClass.getPotionNum() + " potions and " + chooseClass.getCurrency() + " gold coins. **");
                buyPotions(chooseClass);
            } else if (chooseClass.getCurrency() < 3) {
                System.out.println("It looks as though you don't have enough money.");
                visitPotionShop(chooseClass);
            }
        } else if (potionBuy.startsWith("3")) {
            if (chooseClass.getCurrency() >= 6) {
                chooseClass.setPotionNum(chooseClass.getPotionNum() + 3);
                chooseClass.setCurrency(chooseClass.getCurrency() - 6);
                System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                System.out.println("** " + chooseClass.getName() + " now has " + chooseClass.getPotionNum() + " potions and " + chooseClass.getCurrency() + " gold coins. **");
                buyPotions(chooseClass);
            } else if (chooseClass.getCurrency() < 6) {
                System.out.println("It looks as though you don't have enough money.");
                visitPotionShop(chooseClass);
            }
        } else if (potionBuy.startsWith("N") || potionBuy.startsWith("n")) {
            System.out.println("Aw! Maybe next time");
            visitPotionShop(chooseClass);
        }
    }

    public static String visitWeaponShop(Character chooseClass){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want?");
        System.out.println("BUY ** SELL ** LEAVE");
        String weaponChoice = scanner.nextLine();
        if (weaponChoice.startsWith("B") || weaponChoice.startsWith("b")) {
            chooseClass.buyWeapons(chooseClass);

        } else if (weaponChoice.startsWith("S") || weaponChoice.startsWith("s")) {
            System.out.println("We are currently unable to buy items.  Check back soon!");
            visitWeaponShop(chooseClass);

        } else if (weaponChoice.startsWith("L") || weaponChoice.startsWith("l")) {
            exploreTown(chooseClass);
        }
        return weaponChoice;
    }

    public static String visitInn(Character chooseClass){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("REST ** LEAVE");
        String innChoice = scanner.nextLine();
        if (innChoice.startsWith("R") || innChoice.startsWith("r")) {
            chooseClass.rest(chooseClass);
        }else{
            exploreTown(chooseClass);
        }
        return innChoice;
    }

    public static void inspectSelf(Character chooseDifficulty) {
        System.out.println("Your max health is " + chooseDifficulty.getMaxHealth());
        System.out.println("Your health is currently: " + chooseDifficulty.getHealth());
        System.out.println("You have a damage amount of " + chooseDifficulty.getAttack());
        System.out.println("You currently have " + chooseDifficulty.getPotionNum() + " potions");
        System.out.println("You currently have " + chooseDifficulty.getCurrency() + " gold coins");
    }

    public static Character chooseDifficulty(String userDifficulty, Character chooseClass) {
        if (userDifficulty.startsWith("H") || userDifficulty.startsWith("h")) {
            chooseClass.setMaxHealth(chooseClass.getMaxHealth() - 10);
            chooseClass.setHealth(chooseClass.getHealth() - 10);
        } else if (userDifficulty.startsWith("M") || userDifficulty.startsWith("m")) {
            chooseClass.setMaxHealth(chooseClass.getMaxHealth() - 5);
            chooseClass.setHealth(chooseClass.getHealth() - 5);
        } else if (userDifficulty.startsWith("E") || userDifficulty.startsWith("e")) {

        }
        return chooseClass;

    }

    public static Character chooseClass(String userRole, String userName) {
        if(userRole.startsWith("M") || userRole.startsWith("m")){
            return new Mage(userName);
        }else if(userRole.startsWith("W") || userRole.startsWith("w")) {
            return new Warrior(userName);
        }else {
            System.out.println("Select a valid role");
        }
        return null;
    }




}//end of class HeroRPG.HeroRPG

