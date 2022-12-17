public class Temperature {
    public static void main(String[] args) {
        double fahr = 450;
        double cels = 5 * (fahr - 32) / 9;
        System.out.println("Fahrenheit: " + fahr);
        System.out.println("Celsius: " + cels);
        double kelv = cels += 293.15;
        System.out.println("Kelvin: " + kelv);
    }
}