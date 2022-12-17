public class Quiz {
    private int alpha=0;
    private static int beta=0;

    public void inc() {
        alpha++;
        beta++;
    }
    public String toString() {
        return alpha+" "+beta;
    }
    public static void main(String[] args) {
        Quiz x = new Quiz();
        Quiz y = new Quiz();

        x.inc();
        y.inc();
        x.inc();

        System.out.println(x);
        System.out.println(y);

        x = y;
        x.inc();

        System.out.println(x);
        System.out.println(y);
    }
}
