package RPG;

public class Warrior extends Character {
    private boolean warrior;


    public Warrior() {
//        super(name);
        this.setAttack(6);
        this.setHealth(25);
        this.warrior = true;
    }

    public static void rage(){
        //    -Rage(every % of health missing = + % damage dealt)
    }

//    -Improved defense(reduce all incoming damage by 25%)


    public boolean isWarrior() {
        return warrior;
    }

    public void setWarrior(boolean warrior) {
        this.warrior = warrior;
    }
}
