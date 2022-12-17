package HW3;

import java.util.Scanner;
/**
 * This is the driver for a program that takes in a user inputted sentence and converts it to
 * Pirate talk and Elmer Fudd talk.
 * @author Anthony Wong
 * @version 1.0
 * Georgia Institute of Technology
 * CS 1331
 * Professor Stasko
 */
public class PirateFudd {
    /**
     * I was running into issues with .nextLine() getting skipped on iterations after the first one.
     * To fix it I portioned out the scanning functionality of getting the english sentence
     * into its own method.
     * @return english sentence inputted by the user
     */
    private static String scanner() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input English Sentence: ");
        String inp = scan.nextLine();
        return inp;
    }
    /**
     * This is the main method, the program's driver.
     * @param args any arguments passed in by the user in command line
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean needsToRunAgain;
        boolean historypushed = false;
        do {
            String inp = scanner();
            System.out.print("Pirate (Y/N): ");
            String piratebool = scan.next();
            while (!piratebool.equals("Y") && !piratebool.equals("N")) {
                System.out.println("Invalid Entry");
                System.out.print("Pirate (Y/N): ");
                piratebool = scan.next();
            }
            if (piratebool.equals("Y")) {
                String out = ConvertPirate.toPirate(inp);
                System.out.println(out);
                History.toHistory(inp, out);
                historypushed = true;
            }

            System.out.print("Elmer Fudd (Y/N): ");
            String elmerbool = scan.next();
            while (!elmerbool.equals("Y") && !elmerbool.equals("N")) {
                System.out.println("Invalid Entry");
                System.out.print("Elmer Fudd (Y/N): ");
                elmerbool = scan.next();
            }
            if (elmerbool.equals("Y")) {
                String out = ConvertElmerFudd.toElmerFudd(inp);
                System.out.println(out);
                if (!historypushed) {
                    History.toHistory(inp, out);
                }
            }
            historypushed = false;
            History.printHistory();
            System.out.print("Would you like to try again? (Y/N): ");
            String yorn = scan.next();
            while (!yorn.equals("Y") && !yorn.equals("N")) {
                System.out.println("Invalid Entry");
                System.out.print("Would you like to try again? (Y/N): ");
                yorn = scan.next();
            }
            needsToRunAgain = yorn.equals("Y") ? true : false;
        } while (needsToRunAgain);
    }
}
