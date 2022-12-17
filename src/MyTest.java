import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MyTest<T,S> {
    public static int howOften(String tofind, String sentence) {
        Scanner scan = new Scanner(sentence);
        int count = 0;
        while (scan.hasNext()) {
            if (scan.next().equals(tofind)) {
                count++;
            }
        }
        return count;
    }
    public static int howOften(int[][] arr, int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == val) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void filereverse() {
        try {
            File file = new File("SongDB.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                System.out.println(scan.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        String f = "hi";
//        String s = "hi hi hi n d a hi";
//        System.out.println(howOften(f, s));

//        int[][] arr = { {10, 20, 30, 40, 50, 60, 70, 80, 90},
//                        {15, 25, 35, 45},
//                        {27, 29, 37, 10},
//                        {32, 33, 39, 50, 51, 89},
//        };
//        System.out.println(howOften(arr, 10));

//        filereverse();

    }
}

