package HW2;

public class Turkey {
    private double weight;
    private static double priceperoz = 1.99;

    public Turkey(double weight) {
        this.weight = weight;
    }
    public double calcPrice() {
        double total = this.weight * priceperoz;
        return Math.round(total * 100.0) / 100.0;
    }
    public static void setPricePerOz(double inpprice) {
        priceperoz = inpprice;
    }
}
