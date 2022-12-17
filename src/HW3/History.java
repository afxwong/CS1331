package HW3;

/**
 * This is an added class to PirateFudd.java that saves past translations and is able
 * to output them.
 * @author Anthony Wong
 * @version 1.0
 * Georgia Institute of Technology
 * CS 1331
 * Professor Stasko
 */
public class History {
    private static String[] history = new String[3];
    /**
     * This method takes the input and the corresponding translated text and places it into an array
     * for retrieval. Old entries are also overwritten by new ones.
     * @param inp string inputted by the user
     * @param out inputted string's corresponsing translated text
     */
    public static void toHistory(String inp, String out) {
        String entry = inp + " -> " + out;
        for (int i = 0; i <= 1; i++) {
            history[i] = history[i + 1];
        }
        history[2] = entry;
    }
    /**
     * This method prints out up to three of the last translations made.
     */
    public static void printHistory() {
        System.out.print("Past Translations: \n");
        for (String entry : history) {
            if (entry != null) {
                System.out.println(entry);
            }
        }
    }
}
