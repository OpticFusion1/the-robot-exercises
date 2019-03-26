import java.util.Scanner;

public class HeroRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean market = true;
        boolean leaveTown = true;
        boolean fightinPlay = true;
        boolean redoHero = true;
        boolean shopping = true;
        boolean warrior = false;
        boolean mage = false;
        long enemyHealth = 20;
        long enemyAttack = 5;
        long heroHealth = 20;
        long mediumHealth = 15;
        long hardHealth = 10;
        long heroAttack = 2;
        long heroPotion = 2;
        int potionCount = 3;
        int goldPoint = 100;



        do{
            System.out.println("Hello, hero!  Welcome to Arcadia.  What do I have the pleasure of calling you?");
            String heroName = scanner.nextLine();
            System.out.println("hmm.. " + heroName + ". That is an interesting name, but what is a name after all?");
            System.out.println("Anyway, Arcadia can use all the heroes it can find!  We need a brave hero to take on the monsters around the town!");
            System.out.println("I hope we can count on you!");
            System.out.println("To get started how strong do you think you are? The Strongest|Pretty Strong|Not Strong (difficulty level)");
            String heroStrength = scanner.nextLine();
/** Hero Health **/
            if (heroStrength.equalsIgnoreCase("The Strongest")) {
                heroHealth = hardHealth;
            } else if (heroStrength.equalsIgnoreCase("Pretty Strong")) {
                heroHealth = mediumHealth;
            } else if (heroStrength.equals("Not Strong")) {
                //hero health set to standard 20
            }
            System.out.println("Excellent! Now, let's get you properly equipped.  What is your preferred study of the arts?  Warrior or Mage?");
            String heroSpec = scanner.nextLine();
/** Warrior Spec **/
            if (heroSpec.startsWith("W") || heroSpec.startsWith("w")) {
                System.out.println("Ah.  A warrior.  I should have known from your huge battle axe.  Let's get you something a little nicer though.");
                System.out.println("** " + heroName + " has received the Hero's Axe **");
                System.out.println("** Attack has increased from " + heroAttack + " to 5");
                System.out.println("Here are a few potions to help you as well");
                System.out.println("** " + heroName + " has received " + potionCount + " potions ***");
                warrior = true;
                heroAttack = heroAttack + 3;
                heroPotion = heroPotion + 2;
                heroHealth = heroHealth + 5;
/** Mage Spec **/
            }else if (heroSpec.startsWith("M") || heroSpec.startsWith("m")) {
//                    System.out.println(heroAttack);
                System.out.println("Ah of course.  Who doesn't love a good spell?  You need a good staff to go with your spells though.");
                System.out.println("** " + heroName + " has received the Hero's Staff **");
                System.out.println("** Attack has increased from " + heroAttack + " to 3");
                System.out.println("You also have the knowledge to use these more potent Health Potions");
                System.out.println("** " + heroName + " has received the ability to use Mage Health Potions **");
                System.out.println("** " + heroName + " received 2 extra potions **");
                mage = true;
                heroAttack = heroAttack + 1;
                heroPotion = heroPotion + 5;
                potionCount = potionCount + 2;
            }
            System.out.println("Here are some gold coins to get you started around town.");
            System.out.println("** " + heroName + " received " + goldPoint + " gold coins. **");
            System.out.println();

            System.out.println("Perfect!  Let's take a look at you!");
            System.out.println("Your health is currently: " + heroHealth);
            System.out.println("You have a damage amount of " + heroAttack);
            System.out.println("You currently have " + potionCount + " potions");
            System.out.println("You currently have " + goldPoint + " gold coins");

            System.out.println();
            System.out.println("Now that you are ready, you can explore the town and hopefully save Arcadia!");
            System.out.println("Good Luck " + heroName + "!");

            System.out.println("Are you ready to continue?");
            System.out.println("CONTINUE *** START OVER");
            String leaveArea = scanner.nextLine();
            if (leaveArea.startsWith("C") || leaveArea.equalsIgnoreCase("Continue")) {
                System.out.println("*** " + heroName + " has left the castle of Arcadia and is now in the Market Square. ***");
                do {
                    market = true;
                    System.out.println("*** There are a number of shops here, however, there are three that catch your eye. ***");
                    System.out.println("*** Potion Shop, Weapon Shop, Inn.  You may also leave town  Where would you like to go? ***");

/** Potion Shop **/
                    String heroChoice = scanner.nextLine();
                    if (heroChoice.startsWith("Potion Shop") || heroChoice.equalsIgnoreCase("potion shop")) {
                        System.out.println("Welcome to the Potion Shop!");
                        System.out.println("We have a number of options when it comes to potions.");
                        do {
                            System.out.println("What would you like to do?.");
                            System.out.println("BUY ** SELL ** LEAVE");

                            String potionChoice = scanner.nextLine();
/** BUYING POTIONS **/
                            if (potionChoice.startsWith("Buy") || potionChoice.startsWith("buy")) {
                                System.out.println("Ah! Great! How many potions are you wanting to buy?");
                                System.out.println("1 Potion = 3GP *** 3 Potions = 6GP *** Nevermind");
                                String potionBuy = scanner.nextLine();
                                if (potionBuy.startsWith("1 Potion") || potionBuy.equalsIgnoreCase("1 potion")) {
                                    if (goldPoint >= 3) {
                                        potionCount = potionCount + 1;
                                        goldPoint = goldPoint - 3;
                                        System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                                        System.out.println("** " + heroName + " now has " + potionCount + " potions and " + goldPoint + " gold coins. **");
                                    } else if (goldPoint < 3) {
                                        System.out.println("It looks as though you don't have enough money. I have kids to feed!");
                                    }
                                } else if (potionBuy.startsWith("3 Potions") || potionBuy.equalsIgnoreCase("3 potions")) {
                                    if (goldPoint >= 6) {
                                        potionCount = potionCount + 3;
                                        goldPoint = goldPoint - 6;
                                        System.out.println("Great! Here you are.  Good luck with those! Hopefully you won't need them.");
                                        System.out.println("** " + heroName + " now has " + potionCount + " potions and " + goldPoint + " gold coins. **");
                                    } else if (goldPoint < 6) {
                                        System.out.println("It looks as though you don't have enough money. I have kids to feed!");
                                    }
                                } else if (potionBuy.startsWith("N") || potionBuy.equalsIgnoreCase("nevermind")) {
                                    System.out.println("Aw! Maybe next time");
//                                        shopping = false;
                                }
/** SELLING POTIONS **/
                            } else if (potionChoice.startsWith("Sell") || potionChoice.startsWith("sell")) {
                                System.out.println("What do you have to sell?");
                                System.out.println("1 Potion = 2GP ** 3 Potions ** 6GP ** Nevermind");
                                String potionSell = scanner.nextLine();
                                if (potionSell.startsWith("1 Potion") || potionSell.equalsIgnoreCase("1 potion")) {
                                    if (potionCount >= 1) {
                                        goldPoint = goldPoint + 2;
                                        potionCount = potionCount - 1;
                                        System.out.println("Hey thanks!  Here is your money");
                                        System.out.println("** " + heroName + " received 2GP.  You now have a total of: " + goldPoint + " gold coins. **");
                                    } else if (potionCount < 1) {
                                        System.out.println("Hey! What are you trying to pull.  You don't have any potions!");
                                    }
                                } else if (potionSell.startsWith("3 Potions") || potionSell.equalsIgnoreCase("3 potions")) {
                                    if (potionCount >= 3) {
                                        goldPoint = goldPoint + 6;
                                        potionCount = potionCount - 3;
                                        System.out.println("Hey thanks!  Here is your money");
                                        System.out.println("** " + heroName + " received 2GP.  You now have a total of " + goldPoint + " gold coins. **");
                                    }
                                } else if (potionSell.startsWith("N") || potionSell.equalsIgnoreCase("nevermind")) {
                                    System.out.println("Aw! Maybe next time");
//                                        shopping = false;
                                }

                            } else if (potionChoice.startsWith("Leave") || potionChoice.equalsIgnoreCase("leave")) {
                                market = false;
                            }
                        } while (market);
/** end of Pot Shop Options **/
/** start of Weapon Shop **/
                    } else if (heroChoice.startsWith("Weapon Shop") || heroChoice.equalsIgnoreCase("weapon shop")) {
                        System.out.println("Welcome to the Weapon Shop!");
                        System.out.println("We have plenty of things you can use for stabbing.");
                        do {
                            System.out.println("What do you want?");
                            System.out.println("BUY ** SELL ** LEAVE");
                            String weaponChoice = scanner.nextLine();
                            if (weaponChoice.startsWith("Buy") || weaponChoice.startsWith("buy")) {
                                System.out.println("Ah! Here is our selection of wonderful killing devices.");
                                System.out.println("Double Sided Battle Axe = 15GP (+5 Attack) *** Magical Magic Stick of Magic = 15GP (+3 Attack & +5 Health) ** Nevermind");
                                String weaponBuy = scanner.nextLine();
                                if (weaponBuy.startsWith("Double Sided Battle Axe") || weaponBuy.equalsIgnoreCase("double sided battle axe")) {
                                    if (goldPoint >= 15 && warrior) {
                                        heroAttack = heroAttack + 5;
                                        goldPoint = goldPoint - 15;
                                        System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                                        System.out.println("** " + heroName + " now has a Double Sided Battle Axe.  Attack Damage is now: " + heroAttack + "You have a total of " + goldPoint + " gold coins. **");
                                    } else if (goldPoint < 15 || !warrior) {
                                        System.out.println("I'm afraid you are unable to handle this weapon.");
                                    }
                                } else if (weaponBuy.startsWith("Magical Magic Stick of Magic") || weaponBuy.equalsIgnoreCase("magical magic stick of magic")) {
                                    if (goldPoint >= 15 && mage) {
                                        heroAttack = heroAttack + 3;
                                        heroHealth = heroHealth + 5;
                                        goldPoint = goldPoint - 15;
                                        System.out.println("Great! Here you are.  Careful with that!  Make sure to put out plenty of eyes.");
                                        System.out.println("** " + heroName + " received the Magical Magic Stick of Magic. **");
                                        System.out.println("** Attack Damage is now: " + heroAttack + ". You have a total of " + goldPoint + " gold coins. **");
                                        System.out.println("** " + heroName + "'s health is now at " + heroHealth + " **");
                                    } else if (goldPoint < 15 || !mage) {
                                        System.out.println("I'm afraid you cannot handle this weapon.");
                                    }
                                } else if (weaponBuy.startsWith("N") || weaponBuy.equalsIgnoreCase("nevermind")) {
                                    System.out.println("Aw! Maybe next time");
//                                        shopping = false;
                                }
/** Sell Weapons **/
                            } else if (weaponChoice.startsWith("Sell") || weaponChoice.equalsIgnoreCase("sell")) {
                                System.out.println("We are currently unable to buy items.  Check back soon!");

                            } else if (weaponChoice.startsWith("Leave") || weaponChoice.equalsIgnoreCase("leave")) {
                                market = false;
                            }

                        } while (market);
/** end of weapon shop **/
                    } else if (heroChoice.startsWith("I") || heroChoice.equalsIgnoreCase("INN")) {
                        System.out.println("Hello wary traveler!  Welcome to the Inn!");
                        System.out.println("There is nothing here yet. Sorry!");
                        do {
                            System.out.println("What can we do for you?");
                            System.out.println("REST ** LEAVE");
                            String innChoice = scanner.nextLine();
                            if (innChoice.startsWith("R") || innChoice.equalsIgnoreCase("REST")) {
                                System.out.println("Come and lay down.  A hero like you needs all the rest they can get.  Do not worry about payment.");
                                heroHealth = 20;
                                System.out.println("ZZZ");
                                System.out.println("ZZZZZZZZ");
                                System.out.println("** " + heroName + "'s health is now at " + heroHealth);
//
//                                    shopping = false;
                            } else if (innChoice.startsWith("L") || innChoice.equalsIgnoreCase("LEAVE")) {
                                market = false;
                            }
                        } while (market);

/**end of INN Options **/
                    } else if(heroChoice.startsWith("L") || heroChoice.equalsIgnoreCase("leave town")){
                        leaveTown = false;
                    }
                }while(leaveTown);

//                else{
//                    System.out.println("What would you like to do?");
//                    System.out.println("Hero Stats ** Inventory ** Continue");
//                }

//                System.out.println("Explore Arcadia");
//                String heroChoice = scanner.nextLine();
//                if(heroChoice.startsWith("Explore Arcadia")){
//                    System.out.println("Welcome to Arcadia!  You");
//                }


                System.out.println();
                System.out.println("** Enemy Monster has appeared! **");

                do {
                    System.out.println();
                    System.out.println("What would you like to do?");
                    System.out.println("** Attack ** ** Potion **");
                    String battleChoice = scanner.nextLine();
                    if (battleChoice.equalsIgnoreCase("Attack") || battleChoice.startsWith("a")) {
                        int randomNum = (int) (Math.random() * 6);
/** attacking the enemy **/
//                        System.out.println(randomNum);
                        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
                            System.out.println();
                            System.out.println("** You hit the enemy for " + heroAttack + " **");
                            enemyHealth = enemyHealth - heroAttack;
                            System.out.println("Enemy health is now at " + enemyHealth);
                        } else if (randomNum == 4) {
                            System.out.println("** You hit the enemy for a critical attack of " + heroAttack * 2 + " **");
                            enemyHealth = enemyHealth - (heroAttack * 2);
                            System.out.println("Enemy health is now at " + enemyHealth);
                        } else if (randomNum == 1) {
                            System.out.println("** The Enemy dodged the attack! **");
                            System.out.println("Enemy health is still at " + enemyHealth);
                        }

                    } else if (battleChoice.equalsIgnoreCase("Potion")) {
                        if (heroHealth < 20 && potionCount > 0) {
                            potionCount = potionCount - 1;
                            heroHealth = heroHealth + heroPotion;
                            System.out.println(heroName + " drank a health potion. Health has increased by " + heroPotion + ". Health is now at " + heroHealth);
                            System.out.println("You now have " + potionCount + " left.");
                            System.out.println("The enemies health is at " + enemyHealth);
                        } else if (heroHealth == 100) {
                            System.out.println("You may want to slow down on those potions, you are already at " + heroHealth + " health.");
                            System.out.println("The enemies health is at " + enemyHealth);
                        } else if (potionCount == 0) {
                            System.out.println("You are out of potions!");
                            System.out.println("The enemies health is at " + enemyHealth);
                        }
                    }
/** enemy attack **/
                    if (enemyHealth <= 0) {
                        System.out.println("Enemy has been defeated!");
                        int randomNum = (int) (Math.random() * 6);
                        if (randomNum == 1 || randomNum == 3) {
                            System.out.println("** Enemy has dropped 3 Gold **");
                            goldPoint = goldPoint + 2;
                        } else if (randomNum == 2 || randomNum == 4) {
                            System.out.println("** Enemy has dropped 5 Gold **");
                            goldPoint = goldPoint + 5;
                        } else if (randomNum == 0) {
                            System.out.println("** Enemy has dropped NEW ITEM **");
                        }
                        fightinPlay = false;
                    } else {
                        int randomNum = (int) (Math.random() * 6);
                        //                        System.out.println(randomNum);
                        System.out.println();
                        if (randomNum == 0 || randomNum == 2 || randomNum == 3 || randomNum == 5) {
                            System.out.println();
                            System.out.println("** The enemy hit " + heroName + " for " + enemyAttack + " **");
                            heroHealth = heroHealth - enemyAttack;
                            System.out.println(heroName + "'s health is now at " + heroHealth);
                        } else if (randomNum == 4) {
                            System.out.println("** The enemy hit " + heroName + " for a critical attack of " + enemyAttack * 2 + " **");
                            heroHealth = heroHealth - (enemyAttack * 2);
                            System.out.println(heroName + "'s health is now at " + heroHealth);
                        } else if (randomNum == 1) {
                            System.out.println("** " + heroName + " dodged the attack! **");
                            System.out.println(heroName + "'s health is still at " + heroHealth);
                        }
                        if (heroHealth <= 0) {
                            System.out.println(heroName + " has been defeated!");
                            System.out.println("GAME OVER");
//                            dead = true;
                            fightinPlay = false;

                        }
                    }
                } while (fightinPlay);

//do{
//    heroHealth = heroHealth + 20;
//    System.out.println("Welcome back dumbass");
//    if(heroHealth > 0) {
//        dead = false;
//    }
//}while(dead);
            } else if (leaveArea.startsWith("S") || leaveArea.equalsIgnoreCase("Start Over")) {
                System.out.println("Let's give this another try");
            }

        }while(redoHero);







    } /** THIS IS THE MAIN **/


}

