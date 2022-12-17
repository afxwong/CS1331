package HW3;

import java.util.Scanner;
/**
 * This is an added class to PirateFudd.java that converts a given sentence to Elmer Fudd talk.
 * @author Anthony Wong
 * @version 1.0
 * Georgia Institute of Technology
 * CS 1331
 * Professor Stasko
 */
public class ConvertElmerFudd {
    /**
     * This method takes in the user inputted string and translates it into Elmer Fudd talk.
     * @param inp the user inputted string
     * @return the inputted string translated into Elmer Fudd talk
     */
    public static String toElmerFudd(String inp) {
        Scanner scannedsentence = new Scanner(inp);
        String returnstring = "";
        while (scannedsentence.hasNext()) {
            String nextstr = scannedsentence.next();
            char firstchar = nextstr.charAt(0);
            boolean uppcasepresent = (Character.isUpperCase(firstchar));
            nextstr = nextstr.toLowerCase();
            while (nextstr.contains("ith")) {
                nextstr = convertIth(nextstr);
            }
            while (nextstr.contains("th")) {
                nextstr = convertTh(nextstr);
            }
            while (nextstr.contains("l")) {
                nextstr = convertL(nextstr);
            }
            while (nextstr.contains("r")) {
                nextstr = convertR(nextstr);
            }
            String capital = (uppcasepresent) ? nextstr.substring(0, 1).toUpperCase() + nextstr.substring(1) + " "
                : nextstr + " ";
            returnstring += capital;
        }
        return returnstring;
    }
    /**
     * This method finds occurences of "ith" in the input and replaces it with "if".
     * @param inp the string that needs to be searched
     * @return the string with the substring replaced
     */
    private static String convertIth(String inp) {
        String tempstring = "";
        int idx = inp.indexOf("ith");
        tempstring += inp.substring(0, idx) + "if" + inp.substring(idx + 3);
        return tempstring;
    }
    /**
     * This method finds occurences of "th" in the input and replaces it with "d".
     * @param inp the string that needs to be searched
     * @return the string with the substring replaced
     */
    private static String convertTh(String inp) {
        String tempstring = "";
        int idx = inp.indexOf("th");
        tempstring += inp.substring(0, idx) + "d" + inp.substring(idx + 2);
        return tempstring;
    }
    /**
     * This method finds occurences of "l" in the input and replaces it with "w".
     * @param inp the string that needs to be searched
     * @return the string with the substring replaced
     */
    private static String convertL(String inp) {
        String tempstring = "";
        int idx = inp.indexOf("l");
        tempstring += inp.substring(0, idx) + "w" + inp.substring(idx + 1);
        return tempstring;
    }
    /**
     * This method finds occurences of "r" in the input and replaces it with "w".
     * @param inp the string that needs to be searched
     * @return the string with the substring replaced
     */
    private static String convertR(String inp) {
        String tempstring = "";
        int idx = inp.indexOf("r");
        tempstring += inp.substring(0, idx) + "w" + inp.substring(idx + 1);
        return tempstring;
    }
}
