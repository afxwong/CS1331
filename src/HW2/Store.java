package HW2;

public class Store {
    private String name;
    private Cheese[] cheesestock;
    private Turkey[] turkeystock;

    public Store(String name) {
        this.name = name;
        this.cheesestock = new Cheese[5];
        this.turkeystock = new Turkey[5];
    }
    public String getStock() {
        int countcheese = 0;
        int countturkey = 0;
        for (Cheese item : cheesestock) {
            if (item != null) {
                countcheese++;
            }
        }
        for (Turkey item : turkeystock) {
            if (item != null) {
                countturkey++;
            }
        }
        return String.format("Current Stock of: %1$s%nCheese: %2$s%nTurkey: %3$s", this.name, countcheese, countturkey);
    }
    public void addStock(Cheese inpcheese) {
        for(int i = cheesestock.length - 1; i >= 0; i--) {
            if (cheesestock[i] == null) {
                cheesestock[i] = inpcheese;
                break;
            }
        }
    }
    public void addStock(Turkey inpturkey) {
        for(int i = turkeystock.length - 1; i >= 0; i--) {
            if (turkeystock[i] == null) {
                turkeystock[i] = inpturkey;
                break;
            }
        }
    }
    public Cheese removeCheese() {
        int count = 0;
        for(Cheese j : cheesestock) {
            if(j == null) {
                count++;
            }
        }
        if(count == cheesestock.length) {
            for(int i = 0; i < cheesestock.length - 1; i++) {
                cheesestock[i] = new Cheese("Filler Cheese");
            }
            return new Cheese("Filler Cheese");
        } else {
            for(int i = cheesestock.length - 1; i >= 0; i--) {
                if(cheesestock[i] != null) {
                    Cheese toreturn = cheesestock[i];
                    cheesestock[i] = null;
                    return toreturn;
                }
            }
        }
        return null;
    }
    public Turkey removeTurkey() {
        int count = 0;
        for(Turkey j : turkeystock) {
            if(j == null) {
                count++;
            }
        }
        if(count == turkeystock.length) {
            for(int i = 0; i < turkeystock.length - 1; i++) {
                turkeystock[i] = new Turkey(1.50);
            }
            return new Turkey(1.50);
        } else {
            for(int i = turkeystock.length - 1; i > 0; i--) {
                if(turkeystock[i] != null) {
                    Turkey toreturn = turkeystock[i];
                    turkeystock[i] = null;
                    return toreturn;
                }
            }
        }
        return null;
    }
}
