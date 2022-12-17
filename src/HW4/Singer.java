package HW4;

import java.util.Random;

/**
 * Child class of Band Member. Specifically Band Member of type Singer.
 * @author Anthony Wong
 * @version 1.0
 */
public class Singer extends BandMember {
    private Range range;

    /**
     * Possible ranges for singer.
     */
    public enum Range { BASS, BARITONE, TENOR, ALTO, SOPRANO };

    /**
     * Singer Constructor.
     * @param name is the name of singer
     * @param talent is the talent level of singer
     * @param range is the range of singer
     */
    public Singer(String name, int talent, Range range) {
        super(name, talent);
        this.range = range;
    }

    /**
     * Generates performance score for singer.
     * @return the score
     */
    public int perform() {
        Random rand = new Random();
        int score = 0;
        score += rand.nextInt(10) + 1;
        score += super.getTalent();
        int highnote = rand.nextInt(10);
        if (highnote == 0) {
            score *= 2;
        }
        score = (score > 10) ? 10 : score;
        if (score < 5) {
            System.out.println(super.getName() + "'s voice cracked in the middle of their performance! Score: "
                + score + "/10");
        } else {
            System.out.println(super.getName() + " sang their heart out! Score: " + score + "/10");
        }
        return score;
    }

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        return super.toString() + this.range;
    }

    /**
     * Overriden equality method.
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Singer s;
        if (obj instanceof Singer) {
            s = (Singer) obj;
            if (super.equals(obj) && this.range == s.range) {
                return true;
            }
            return false;
        }
        return false;
    }
}
