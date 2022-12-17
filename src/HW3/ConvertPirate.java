package HW3;

import java.util.Scanner;
/**
 * This is an added class to PirateFudd.java that converts a given sentence to Pirate talk.
 * @author Anthony Wong
 * @version 1.0
 * Georgia Institute of Technology
 * CS 1331
 * Professor Stasko
 */
public class ConvertPirate {
    /**
     * This method takes in the user inputted string and translates it into Pirate talk.
     * @param inp the user inputted string
     * @return the inputted string translated into Pirate talk
     */
    public static String toPirate(String inp) {
        Scanner scannedsentence = new Scanner(inp);
        String returnstring = "Yarr! ";
        while (scannedsentence.hasNext()) {
            String nextstr = scannedsentence.next();
            char firstchar = nextstr.charAt(0);
            char endchar = nextstr.charAt(nextstr.length() - 1);
            boolean uppcasepresent = (Character.isUpperCase(firstchar));
            boolean edited = false;
            nextstr = nextstr.toLowerCase();
            if (nextstr.contains("you") && firstchar == 'y') {
                String tempstring = "";
                tempstring += "ye";
                if (nextstr.length() != 3) {
                    tempstring += nextstr.substring(3);
                }
                if (uppcasepresent) {
                    tempstring = tempstring.substring(0).toUpperCase() + tempstring.substring(1);
                }
                returnstring += tempstring;
                edited = true;
            }
            if (nextstr.contains("ing")) {
                if (nextstr.substring(nextstr.length() - 3).equals("ing")) {
                    String tempstring = "";
                    int idx = nextstr.length() - 3;
                    tempstring += nextstr.substring(0, idx) + "in'";
                    returnstring += tempstring;
                    edited = true;
                } else if (!Character.isLetter(endchar)
                    && nextstr.substring(nextstr.length() - 4, nextstr.length() - 1).equals("ing")) {
                    String tempstring = "";
                    int idx = nextstr.length() - 4;
                    tempstring += nextstr.substring(0, idx) + "in'" + endchar;
                    returnstring += tempstring;
                    edited = true;
                }
            }
            switch (nextstr) {
            case "and":
                returnstring += "'n";
                break;
            case "my":
                returnstring += (uppcasepresent) ? "Me" : "me";
                break;
            case "is":
                returnstring += (uppcasepresent) ? "Be" : "be";
                break;
            case "are":
                returnstring += (uppcasepresent) ? "Be" : "be";
                break;
            case "am":
                returnstring += (uppcasepresent) ? "Be" : "be";
                break;
            default:
                if (!edited) {
                    if (uppcasepresent) {
                        nextstr = nextstr.substring(0, 1).toUpperCase() + nextstr.substring(1);
                    }
                    returnstring += nextstr;
                }
                break;
            }
            returnstring += " ";
        }
        return returnstring;
    }
}
