import java.util.Scanner;

public class GridPrinter {
    public static void main(String[] args) {
        boolean needsToRunAgain;
        Scanner scan = new Scanner(System.in);
        do {
            needsToRunAgain = false;
            System.out.print("Enter the number of rows: ");
            int rows = scan.nextInt();
            System.out.print("Enter the number of columns: ");
            int cols = scan.nextInt();
            for (int i=0; i<rows; i++) {
                String line = "";
                for (int j=0; j<cols; j++) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            line += "X";
                        } else {
                            line += "O";
                        }
                } else if (i % 2 == 1) {
                    if (j % 2 == 0) {
                        line += "O";
                    } else {
                        line += "X";
                    }
                }
            }
            System.out.println(line);
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
