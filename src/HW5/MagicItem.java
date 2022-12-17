package HW5;

/**
 * Abstract Parent Class for Lamp.java, Carpet.java, and Wand.java.
 * @author Anthony Wong
 * @version 1.0
 */
public abstract class MagicItem implements Comparable<MagicItem> {
    private int power;
    private String name;

    /**
     * Constructor for MagicItems.
     * @param name is name of item
     * @param power is power of item
     */
    public MagicItem(String name, int power) {
        this.power = power;
        this.name = name;
    }

    /**
     * Abstract method that child classes must implement.
     */
    public abstract void invoke();

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        return this.name + " has " + this.power + " power left";
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        MagicItem m;
        if (obj == null) {
            return false;
        } else if (obj instanceof MagicItem) {
            m = (MagicItem) obj;
            return this.power == m.power && this.name.equals(m.name);
        } else {
            return false;
        }
    }

    /**
     * Implements compareTo method from Comparable interface. Compares powers of two objects.
     * @param m is the item
     * @return 1, -1, or 0 depending on comparison outcome
     */
    public int compareTo(MagicItem m) {
        if (this.power > m.power) {
            return 1;
        } else if (this.power < m.power) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Getter for name.
     * @return the item name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for item power.
     * @return the item power
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Setter for item power.
     * @param newpower new power of item
     */
    public void setPower(int newpower) {
        this.power = newpower;
    }
}
