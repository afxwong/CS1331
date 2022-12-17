package HW4;

import java.util.Random;

/**
 * Child class of Band Member. Specifically Band Member of type Guitarist.
 * @author Anthony Wong
 * @version 1.0
 */
public class Guitarist extends BandMember {
    private Specialty specialization;

    /**
     * Possible specialities for guitarists.
     */
    public enum Specialty { ACOUSTIC, ELECTRIC };

    /**
     * Guitarist Constructor.
     * @param name is the name of guitarist
     * @param talent is the talent level of guitarist
     * @param specialization is the specialty of guitarist
     */
    public Guitarist(String name, int talent, Specialty specialization) {
        super(name, talent);
        this.specialization = specialization;
    }

    /**
     * Generates performance score for guitarist.
     * @return the score
     */
    public int perform() {
        Random rand = new Random();
        int score = 0;
        score += rand.nextInt(10) + 1;
        score += super.getTalent();
        int solo = rand.nextInt(10);
        if (solo < 3) {
            score *= 2;
        }
        score = (score > 10) ? 10 : score;
        if (score < 5) {
            System.out.println(super.getName() + "s fingers slipped and hit the wrong note! Score: " + score + "/10");
        } else {
            System.out.println(super.getName() + " captured everyone’s attention! Score: " + score + "/10");
        }
        return score;
    }

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        return super.toString() + this.specialization;
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Guitarist g;
        if (obj instanceof Guitarist) {
            g = (Guitarist) obj;
            if (super.equals(obj) && this.specialization == g.specialization) {
                return true;
            }
            return false;
        }
        return false;
    }
}
