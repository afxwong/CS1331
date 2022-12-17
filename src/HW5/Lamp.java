package HW5;

/**
 * Child class of MagicItem.java.
 * @author Anthony Wong
 * @version 1.0
 */
public class Lamp extends MagicItem {
    private boolean genieHome;

    /**
     * Constructor for Lamps.
     * @param name is the lamp name.
     * @param power is the lamp power.
     * @param genieHome is if the genie is home.
     */
    public Lamp(String name, int power, boolean genieHome) {
        super(name, power);
        this.genieHome = genieHome;
    }

    /**
     * Activation method for lamp.
     */
    public void invoke() {
        if (!this.genieHome) {
            System.out.println("Genie away, come back later");
        } else if (this.genieHome && this.getPower() > 50) {
            System.out.println("Wish granted!");
            this.setPower(this.getPower() - 50);
        } else {
            System.out.println("Not enough power");
        }
    }

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Lamp:  " + this.getName() + " has " + this.getPower() + " power left";
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Lamp l;
        if (obj == null) {
            return false;
        } else if (obj instanceof Lamp) {
            l = (Lamp) obj;
            return super.equals(obj) && this.genieHome == l.genieHome;
        } else {
            return false;
        }
    }
}
