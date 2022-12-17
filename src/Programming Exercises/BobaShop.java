import java.util.Scanner;

public class BobaShop {
    public static void main(String[] args) {
        System.out.println("Welcome to the Boba Shop Finder!\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your zip code: ");
        int zipcode = input.nextInt();
        boolean run = true;
        switch (zipcode) {
            case 30309:
                {
                System.out.println("There is a bubble tea shop called Sweet Hut here!");
            }
                break;
            case 30308:
                {
                System.out.println("There is a bubble tea shop called Tea Corner here!");
            }
                break;
            case 30306:
                {
                System.out.println("There is a bubble tea shop called Honey Bubble here!");
            }
                break;
            case 30360:
                {
                System.out.println("There is a bubble tea shop called Tea Top here!");
            }
                break;
            default:
                {
                System.out.println("Sorry, no shops found.");
                run = false;
            }
                break;

        }
        if (run) {
        System.out.println("Enter your budget: ");
        int budget = input.nextInt();

        if (budget > 40) {
            System.out.println("You can purchase 20 drinks.");
        } else if (budget > 21) {
            System.out.println("You can purchase 8 drinks.");
        } else if (budget > 11) {
            System.out.println("You can purchase 4 drinks.");
        } else if (budget > 1) {
            System.out.println("You can purchase 2 drinks.");
        } else {
            System.out.println("Invalid.");
        }
    }
    }
}