package HW5;

import java.util.Scanner;

/**
 * Child class of MagicItem.java and implements Rechargeable.java.
 * @author Anthony Wong
 * @version 1.0
 */
public class Wand extends MagicItem implements Rechargeable {
    private String owner;

    /**
     * Wand Constructor.
     * @param name is the wand name
     * @param power is the wand power
     * @param owner is the wand owner
     */
    public Wand(String name, int power, String owner) {
        super(name, power);
        this.owner = owner;
    }

    /**
     * Activation method for wands.
     */
    public void invoke() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String inp = scan.nextLine();
        if (!inp.equals(this.owner)) {
            System.out.println("I’m sorry, you are not the true owner");
        } else {
            if (this.getPower() > 25) {
                this.setPower(this.getPower() - 25);
                System.out.println("FIREBALL!");
            } else {
                System.out.println("Not enough power");
            }
        }
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
        return "Wand: " + this.getName() + " has " + this.getPower() + " power left";
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Wand w;
        if (obj == null) {
            return false;
        } else if (obj instanceof Wand) {
            w = (Wand) obj;
            return super.equals(obj) && this.owner == w.owner;
        } else {
            return false;
        }
    }
}
