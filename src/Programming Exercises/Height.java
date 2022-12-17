public class Height {
    public static void main(String[] args) {
        double height = 180;
        int feet;
        double inches;
        feet = (int) (height / 2.54 / 12);
        inches = ((height / 2.54 / 12.0) - feet) * 12;
        System.out.println(height + " cm is " + feet + " feet and " + inches + " inches.");
    }
}
