package HW2;

public class Cart {
    private Cheese[] cheeselist;
    private Turkey[] turkeylist;
    private Store store;

    public Cart(Store store) {
        this.store = store;
        this.cheeselist = new Cheese[3];
        this.turkeylist = new Turkey[3];
    }
    public void addToCart(String item) {
        if(item.equals("Cheese")) {
            Cheese removed = store.removeCheese();
            for(int i = 0; i < this.cheeselist.length; i++) {
                if(this.cheeselist[i] == null) {
                    this.cheeselist[i] = removed;
                    break;
                }
            }
        } else if (item.equals("Turkey")) {
            Turkey removed = store.removeTurkey();
            for(int i = 0; i < this.turkeylist.length; i++) {
                if(this.turkeylist[i] == null) {
                    this.turkeylist[i] = removed;
                    break;
                }
            }
        }
    }
    public double calcTotal() {
        double total = 0.0;
        int cheesenum = 0;
        for(int i = 0; i < this.cheeselist.length; i++) {
            if(this.cheeselist[i] != null) {
                cheesenum++;
            }
        }
        total += (cheesenum * Cheese.getPrice());
        for(int i = 0; i < this.turkeylist.length; i++) {
            if(this.turkeylist[i] != null) {
                total += (turkeylist[i].calcPrice());
            }
        }
        return total;
    }
    public double checkout(double total, double money){
        if(money >= total) {
            this.cheeselist = new Cheese[3];
            this.turkeylist = new Turkey[3];
            return Math.round((money - total) * 100) / 100.0;
        } else {
            return -1.0;
        }
    }
}
