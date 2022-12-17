import java.util.Random;

public class ChocolateBox {
    private static enum Chocolate {CARAMEL, MARSHMELLOW, DARK, NOUGAT, MILK}; 
    
    public static Chocolate[] createBox() {
        Random rand = new Random();
        Chocolate[] chocarr = new Chocolate[6];
        for (int i = 0; i < chocarr.length; i++) {
            int idx = rand.nextInt(5);
            chocarr[i] = Chocolate.values()[idx];
        }
        return chocarr;
    }

    public static void printBox(Chocolate[] arr) {
        System.out.println("Your assortment of chocolates includes:");
        for (Chocolate type : arr) {
            System.out.println(type);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Chocolate[] array1 = createBox();
        printBox(array1);
        Chocolate[] array2 = createBox();
        printBox(array2);
    }
}
