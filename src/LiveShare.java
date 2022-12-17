public class LiveShare {
    private int a;
    public void inc(int b) {
        a++;
        System.out.println(a);
        a += b;
        System.out.println(a);
    }
    public LiveShare ind(int a){
        if (a == 1){
            return new LiveShare();
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        LiveShare test = new LiveShare();
        System.out.println(test.a);
        test.inc(5);
        System.out.println(test.a);
        test.ind(1);
        System.out.println(test.a);
    }
}
