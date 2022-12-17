package HW4;

import java.util.Scanner;
import java.util.ArrayList;

public class BattleSimulator {
    static ArrayList<Band> bands = new ArrayList<Band>();
    static Scanner scan = new Scanner(System.in);

    public static void printBands() {
        for (int i = 1; i < bands.size() + 1; i++) {
            System.out.println(i + ". " + bands.get(i - 1).getName());
        }
    }
    public static void addArtist() {
        printBands();
        System.out.print("Which band would you like to add a member to? ");
        int bandnum = scan.nextInt();
        while (bandnum < 0 || bandnum > bands.size()) {
            System.out.print("Which band would you like to add a member to? ");
            bandnum = scan.nextInt();
        }
        System.out.print("What is the Artist's name? ");
        String artistname = scan.nextLine();
        System.out.print("Talent Rating from 1 to 5: ");
        int talent = scan.nextInt();
        System.out.print("Guitarist or Singer");
        String type = scan.nextLine();
        while (!type.equals("Guitarist") && !type.equals("Singer")) {
            System.out.print("Guitarist or Singer");
            type = scan.nextLine();
        }
        if (type.equals("Guitarist")) {
            System.out.println("1. ACOUSTIC\n2. ELECTRIC\n");
            System.out.print("Which specialization: ");
            int specialization = scan.nextInt();
            while (specialization < 1 && specialization > 2) {
                System.out.println("1. ACOUSTIC\n2. ELECTRIC\n");
                System.out.print("Which specialzation: ");
                specialization = scan.nextInt();
            }
            Guitarist newg;
            if (specialization == 1) {
                newg = new Guitarist(artistname, talent, Guitarist.Specialty.ACOUSTIC);
            } else {
                newg = new Guitarist(artistname, talent, Guitarist.Specialty.ELECTRIC);
            }
            bands.get(bandnum - 1).addMembers(newg);
            System.out.println("Added guitarist" + artistname + " to " + bands.get(bandnum - 1).getName());
        } else {
            System.out.println("1. BASS\n2. BARITONE\n3. TENOR\n4. ALTO\n5. SOPRANO");
            System.out.print("Which range: ");
            int range = scan.nextInt();
            while (range < 1 && range > 5) {
                System.out.println("1. BASS\n2. BARITONE\n3. TENOR\n4. ALTO\n5. SOPRANO");
                System.out.print("Which range: ");
                range = scan.nextInt();
            }
            Singer news;
            if (range == 1) {
                news = new Singer(artistname, talent, Singer.Range.BASS);
            } else if (range == 2) {
                news = new Singer(artistname, talent, Singer.Range.BARITONE);
            } else if (range == 3) {
                news = new Singer(artistname, talent, Singer.Range.TENOR);
            } else if (range == 4) {
                news = new Singer(artistname, talent, Singer.Range.ALTO);
            } else {
                news = new Singer(artistname, talent, Singer.Range.SOPRANO);
            }
            bands.get(bandnum - 1).addMembers(news);
            System.out.println("Added singer" + artistname + " to " + bands.get(bandnum - 1).getName());
        }
    }
    public static void addBand() {
        System.out.print("Name of the Band: ");
        String name = scan.nextLine();
        System.out.print("Band Genre: ");
        String genre = scan.nextLine();
        ArrayList<BandMember> members = new ArrayList<BandMember>();
        Band b = new Band(name, genre, members);
        bands.add(b);
        System.out.println("\nAdded band named " + name + "\n");
    }
    public static void changeRating() {
        printBands();
        System.out.print("Select a band: ");
        int bandnum = scan.nextInt();
        while (bandnum < 0 || bandnum > bands.size()) {
            System.out.print("Which band would you like to edit? ");
            bandnum = scan.nextInt();
        }
        ArrayList<BandMember> temp = bands.get(bandnum - 1).getMembers();
        for (int i = 1; i < temp.size() + 1; i++) {
            System.out.println(i + ". " + temp.get(i - 1).getName());
        }
        System.out.print("Who to edit: ");
        int editnum = scan.nextInt();
        System.out.print("Set talent: ");
        int newtalent = scan.nextInt();
        temp.get(editnum - 1).setTalent(newtalent);
        System.out.println("Talent for " + temp.get(editnum - 1).getName() + " set to " + newtalent);
    }
    public static void simulate() {
        System.out.println("Setting up simulation...");
        printBands();
        System.out.print("Select the first band: ");
        int bandnum1 = scan.nextInt();
        while (bandnum1 < 0 || bandnum1 > bands.size()) {
            System.out.print("Select the first band: ");
            bandnum1 = scan.nextInt();
        }
        System.out.print("Select the second band: ");
        int bandnum2 = scan.nextInt();
        while (bandnum2 < 0 || bandnum2 > bands.size()) {
            System.out.print("Select the second band: ");
            bandnum2 = scan.nextInt();
        }
        System.out.println("\nBeginning simuation...");
        double score1 = bands.get(bandnum1 - 1).perform();
        double score2 = bands.get(bandnum2 - 1).perform();
        if (score1 == score2) {
            System.out.println("It's a tie");
        } else if (score1 >= score2) {
            System.out.println("The winner is " + bands.get(bandnum2 - 1).getName());
        } else {
            System.out.println("The winner is " + bands.get(bandnum1 - 1).getName());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int select;
        System.out.println("Welcome to the Battle of the Bands Simulator!\n");
        do {
            System.out.println("Would you like to:\n1. View Bands\n2. Add new Artist\n" + 
            "3. Add new Band\n4. Change Artist rating\n5. Perform Simulation\n" + 
            "6. Exit Program\nPlease enter one of the options above:");
            select = scan.nextInt();
            if (select == 1) {
                if (bands.size() == 0) {
                    System.out.println("\nNo bands to view\n");
                } else {
                    printBands();
                }
            } else if (select == 2) {
                if (bands.size() == 0) {
                    System.out.println("\nNo band to add to\n");
                } else {
                    addArtist();
                }
            } else if (select == 3) {
                addBand();
            } else if (select == 4) {
                if (bands.size() == 0) {
                    System.out.println("\nNo band to edit\n");
                } else {
                    changeRating();
                }
            } else if (select == 5) {
                if (bands.size() < 2) {
                    System.out.println("\nNot enough bands\n");
                } else {
                    simulate();
                }
            }
        } while (select != 6);
    }
}
