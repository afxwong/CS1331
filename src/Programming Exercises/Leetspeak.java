import java.util.Scanner;

public class Leetspeak {
    public static void main(String[] args) {
        Scanner txtinput = new Scanner(System.in);
        System.out.println("Enter Leet text: ");
        String leettxt = txtinput.nextLine();
        String leettxt_lower = leettxt.toLowerCase();
        String replacestring = leettxt_lower.replace("a", "@");
        replacestring = replacestring.replace("e", "3");
        replacestring = replacestring.replace("i", "1");
        replacestring = replacestring.replace("o", "0");
        replacestring = replacestring.replace("s", "$");
        replacestring = replacestring.replace("t", "7");

        System.out.println("Converted text: " + replacestring);
    }
}
