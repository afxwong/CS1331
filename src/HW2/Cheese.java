package HW2;

public class Cheese {
    private String name;
    private boolean shredded;
    private static double price = 1.50;

    public Cheese(String name, boolean shredded) {
        this.name = name;
        this.shredded = shredded;
    }
    public Cheese(String name) {
        this(name, true);
    }
    public Cheese() {
        this("Cheddar");
    }
    public static void setPrice(double inpprice) {
        price = inpprice;
    }
    public static double getPrice() {
        return price;
    }
}
