package HeroRPG;

public class Mage {
//    private String heroName;
    private int mageHealth;
    private int mageAttack;
//    private int heroPotion;
//    private int potionCount;
//    private int goldPoint;
    private boolean warrior;
    private boolean mage;

    public static void castFire(){

    }

    public static void castIce(){

    }

    public Mage(int mageHealth, int mageAttack, boolean warrior, boolean mage) {
        this.mageHealth = mageHealth;
        this.mageAttack = mageAttack;
        this.warrior = warrior;
        this.mage = mage;
    }

    public int getMageHealth() {
        return mageHealth;
    }

    public int getMageAttack() {
        return mageAttack;
    }

    public boolean isWarrior() {
        return warrior;
    }

    public boolean isMage() {
        return mage;
    }

    public void setMageHealth(int mageHealth) {
        this.mageHealth = mageHealth;
    }

    public void setMageAttack(int mageAttack) {
        this.mageAttack = mageAttack;
    }

    public void setWarrior(boolean warrior) {
        this.warrior = warrior;
    }

    public void setMage(boolean mage) {
        this.mage = mage;
    }
}
