package HW5;

/**
 * Child class of MagicItem.java and implements Rechargeable.java.
 * @author Anthony Wong
 * @version 1.0
 */
public class Carpet extends MagicItem implements Rechargeable {
    private double height;

    /**
     * Carpet Constructor.
     * @param name is the carpet name
     * @param power is the carpet power
     * @param height is the carpet height
     */
    public Carpet(String name, int power, double height) {
        super(name, power);
        this.height = height;
    }

    /**
     * Activation method for carpets.
     */
    public void invoke() {
        if (this.getPower() < 10) {
            System.out.println("Not enough power");
        } else {
            this.setPower(this.getPower() - 10);
            this.height += 10;
            System.out.println("We're " + this.height + " meters off the ground!");
        }
    }

    /**
     * Landing function for carpets.
     */
    public void land() {
        this.height = 0;
        System.out.println("We landed");
    }

    /**
     * Implementation of Rechargeable.java.
     * @param inppower is power to add
     */
    public void recharge(int inppower) {
        this.setPower(this.getPower() + inppower);
    }

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Carpet: " + this.getName() + " has " + this.getPower() + " power left";
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Carpet c;
        if (obj == null) {
            return false;
        } else if (obj instanceof Carpet) {
            c = (Carpet) obj;
            return super.equals(obj) && this.height == c.height;
        } else {
            return false;
        }
    }
}
