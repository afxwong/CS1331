package HW4;

import java.util.ArrayList;

/**
 * Houses methods and variables for Band objects.
 * @author Anthony Wong
 * @version 1.0
 */
public class Band {
    private String bandname;
    private String genre;
    private ArrayList<BandMember> members = new ArrayList<BandMember>();

    /**
     * Band Constructor.
     * @param bandname is the name of the band.
     * @param genre is the type of music
     * @param members is the ArrayList of members in the band
     */
    public Band(String bandname, String genre, ArrayList<BandMember> members) {
        this.bandname = bandname;
        this.genre = genre;
        this.members = members;
    }

    /**
     * Calculates average talent of people in the band.
     * @return the average talent
     */
    public double talentRating() {
        int score = 0;
        if (members.size() == 0) {
            return 1;
        } else {
            for (int i = 0; i < members.size(); i++) {
                score += members.get(i).getTalent();
            }
        }
        return (double) score / members.size();
    }

    /**
     * Calculates performance score of the band.
     * @return the performance score
     */
    public double perform() {
        int score = 0;
        for (int i = 0; i < members.size(); i++) {
            score += members.get(i).perform();
        }
        double average = (double) score / members.size();
        System.out.println(this.bandname + "'s Performance Score: " + average + "/10");
        return average;
    }

    /**
     * Adds members to the band.
     * @param bm BandMember object
     */
    public void addMembers(BandMember bm) {
        this.members.add(bm);
    }

    /**
     * Overidden print object method.
     * @return string representation of object
     */
    @Override
    public String toString() {
        String toreturn = "";
        toreturn += this.bandname + " (" + genre + ")" + ": " + talentRating() + "/5\n";
        for (int i = 0; i < members.size(); i++) {
            toreturn += members.get(i).toString() + "\n";
        }
        return toreturn;
    }

    /**
     * Getter for band name.
     * @return band name
     */
    public String getName() {
        return this.bandname;
    }

    /**
     * Getter for members.
     * @return Array list of band members
     */
    public ArrayList<BandMember> getMembers() {
        return this.members;
    }
}
