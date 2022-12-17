import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args){
        System.out.println("Welcome to a Guessing Game!\n");
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        boolean needsToRunAgain;
        do {
            int sequencenum = rand.nextInt(3);
            if (sequencenum == 0) {

                // Geometric

                int start = rand.nextInt(5) + 1;
                int factor = rand.nextInt(11) - 5;
                System.out.println(start);
                System.out.println(start * factor);
                System.out.println((int) (start * Math.pow(factor, 2)));
                int ans = (int) (start * Math.pow(factor, 3));
                System.out.print("What is the next number? ");
                int input = scan.nextInt();
                if (ans == input) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The next number was " + ans);
                }


            } else if (sequencenum == 1) {

                // Square Root

                int start = rand.nextInt(101) + 100;
                System.out.println(start);
                System.out.println((int) Math.sqrt(start));
                System.out.println((int) Math.sqrt(Math.sqrt(start)));
                int ans = (int) (Math.sqrt(Math.sqrt(Math.sqrt(start))));
                System.out.print("What is the next number? ");
                int input = scan.nextInt();
                if (ans == input) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The next number was " + ans);
                }
            } else {

                // Exponential

                int start = rand.nextInt(10) + 1;
                System.out.println((int) Math.pow(start, 0));
                System.out.println((int) Math.pow(start, 1));
                System.out.println((int) Math.pow(start, 2));
                int ans = (int) Math.pow(start, 3);
                System.out.print("What is the next number? ");
                int input = scan.nextInt();
                if (ans == input) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The next number was " + ans);
                }
            }
        System.out.print("Would you like to try again? (Y/N): ");
        String yorn = scan.next();
        while (!yorn.equals("Y") && !yorn.equals("N")){
            System.out.println("Invalid Entry");
            System.out.print("Would you like to try again? (Y/N): ");
            yorn = scan.next();
        }
        needsToRunAgain = yorn.equals("Y") ? true : false;
        } while (needsToRunAgain);
    }
}
