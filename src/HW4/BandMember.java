package HW4;

/**
 * Abstract Parent class for Singer.java and Guitarist.java.
 * @author Anthony Wong
 * @version 1.0
 */
public abstract class BandMember {
    private String name;
    private int talent;

    /**
     * Band Member Constuctor.
     * @param name is the name of the band member
     * @param talent is the talent level of the band member
     */
    public BandMember(String name, int talent) {
        this.name = name;
        if (talent < 1) {
            this.talent = 1;
        } else if (talent > 5) {
            this.talent = 5;
        } else {
            this.talent = talent;
        }
    }

    /**
     * Abtract method tht must be defined by the child classes.
     */
    abstract int perform();

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        return this.name + ": " + this.talent + "/5 ";
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        BandMember b;
        if (obj instanceof BandMember) {
            b = (BandMember) obj;
            if (this.name.equals(b.name) && this.talent == b.talent) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Getter for name.
     * @return name of band member
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for name.
     * @param newname is new name for band member
     */
    public void setName(String newname) {
        this.name = newname;
    }

    /**
     * Getter for talent level.
     * @return talent level of band member
     */
    public int getTalent() {
        return this.talent;
    }

    /**
     * Setter for talent level.
     * @param newtalent is new talent level of band member
     */
    public void setTalent(int newtalent) {
        if (newtalent < 1) {
            this.talent = 1;
        } else if (newtalent > 5) {
            this.talent = 5;
        } else {
            this.talent = newtalent;
        }
    }
}
