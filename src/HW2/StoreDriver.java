package HW2;

public class StoreDriver {
    public static void main(String[] args) {
        Store s = new Store("Target");
        Cart c = new Cart(s);
        System.out.println("---------------------------------");
        System.out.println(s.getStock());
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("ADDING STOCK");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        Cheese swiss = new Cheese("Swiss", false);
        Cheese ched = new Cheese();
        s.addStock(ched);
        s.addStock(swiss);
        Turkey t1 = new Turkey(1.0);
        s.addStock(t1);
        System.out.println("CHECK STOCK");
        System.out.println("---------------------------------");
        System.out.println(s.getStock());
        System.out.println("---------------------------------");
        System.out.println("ADDING TO CART");
        System.out.println("---------------------------------");
        c.addToCart("Cheese");
        c.addToCart("Cheese");
        c.addToCart("Turkey");
        c.addToCart("Turkey");
        c.addToCart("Cheese");
        System.out.println("TOTAL: " + c.calcTotal());
        System.out.println("---------------------------------");
        System.out.println("UNSUCCESSFUL CHECKOUT");
        System.out.println("---------------------------------");
        double remaining = c.checkout(c.calcTotal(), 1.0);
        System.out.println("REMAINING MONEY: " + remaining);
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("SUCCESSFUL CHECKOUT");
        System.out.println("---------------------------------");
        remaining = c.checkout(c.calcTotal(), 50.0);
        System.out.println("REMAINING MONEY: " + remaining);
        System.out.println("---------------------------------");
        System.out.println("CHECK STOCK");
        System.out.println("---------------------------------");
        System.out.println(s.getStock());
        System.out.println("---------------------------------");


        Store s2 = new Store("Publix");
        Cart c2 = new Cart(s2);
        System.out.println("---------------------------------");
        System.out.println("NEW STORE, SETTING NEW PRICE");
        System.out.println("---------------------------------");
        Cheese.setPrice(2.00);
        Turkey.setPricePerOz(1.00);
        System.out.println("---------------------------------");
        System.out.println(s2.getStock());
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("ADDING STOCK");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        Cheese swiss2 = new Cheese("Swiss", false);
        Cheese ched2 = new Cheese();
        s2.addStock(ched2);
        s2.addStock(swiss2);
        Turkey t2 = new Turkey(2.0);
        s2.addStock(t2);
        System.out.println("CHECK STOCK");
        System.out.println("---------------------------------");
        System.out.println(s2.getStock());
        System.out.println("---------------------------------");
        System.out.println("ADDING TO CART");
        System.out.println("---------------------------------");
        c2.addToCart("Cheese");
        c2.addToCart("Cheese");
        c2.addToCart("Turkey");
        c2.addToCart("Turkey");
        c2.addToCart("Cheese");
        c2.addToCart("Cheese");
        c2.addToCart("Cheese");
        c2.addToCart("Turkey");
        System.out.println("TOTAL: " + c2.calcTotal());
        System.out.println("---------------------------------");
        System.out.println("UNSUCCESSFUL CHECKOUT");
        System.out.println("---------------------------------");
        double remaining2 = c.checkout(c2.calcTotal(), 1.0);
        System.out.println("REMAINING MONEY: " + remaining2);
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("SUCCESSFUL CHECKOUT");
        System.out.println("---------------------------------");
        remaining2 = c2.checkout(c2.calcTotal(), 40.0);
        System.out.println("REMAINING MONEY: " + remaining2);
        System.out.println("---------------------------------");
        System.out.println("CHECK STOCK");
        System.out.println("---------------------------------");
        System.out.println(s2.getStock());
        System.out.println("---------------------------------");

    }
}
