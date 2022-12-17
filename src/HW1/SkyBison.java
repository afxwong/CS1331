package HW1;

public class SkyBison {
    private String name;
    private int fluffiness;
    private int health;

    public SkyBison(String name, int fluffiness, int health) {
        this.health = (health < 0) ? 0 : health;
        this.name = name;
        this.fluffiness = fluffiness;
    }
    public SkyBison(String name) {
        this(name, 100, 100);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String inpname){
        this.name = inpname;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int inphealth) {
        this.health = (inphealth < 0) ? 0 : inphealth;
    }
    public int getFluffiness() {
        return this.fluffiness;
    }
    public void setFluffiness(int inpfluffiness) {
        this.fluffiness = inpfluffiness;
    }
    public void eatSnack(int[] foodarr) {
        int added = 0;
        for (int food : foodarr) {
            added += food;
        }
        this.health += added;
    }
    public void eatSnack(int foodnum) {
        this.health += foodnum;
    }
    public void fly(int hours) {
        int newhealth = this.health - (10 * hours);
        this.health = (newhealth < 0) ? 0 : newhealth;
    }
    public static void main(String[] args) {
        SkyBison b1 = new SkyBison("Bison 1", 5, -5);
        SkyBison b2 = new SkyBison("Bison 2");

        // Bison 1 calls

        System.out.println("----------------------------------------");
        System.out.println("GET METHODS");
        System.out.println("----------------------------------------");
        System.out.println("B1 name: " + b1.getName());
        System.out.println("B1 health: " + b1.getHealth());
        System.out.println("B1 fluffiness: " + b1.getFluffiness());
        System.out.println("----------------------------------------");
        System.out.println("SET METHODS");
        System.out.println("----------------------------------------");
        b1.setName("Anthony");
        b1.setFluffiness(20);
        b1.setHealth(50);
        System.out.println("B1 name: " + b1.getName());
        System.out.println("B1 health: " + b1.getHealth());
        System.out.println("B1 fluffiness: " + b1.getFluffiness());
        System.out.println("----------------------------------------");
        System.out.println("EAT METHODS");
        System.out.println("----------------------------------------");
        int[] healtharray = {10, 5, 3, 2};
        b1.eatSnack(healtharray);
        System.out.println("B1 health: " + b1.getHealth());
        b1.eatSnack(5);
        System.out.println("B1 health: " + b1.getHealth());
        System.out.println("----------------------------------------");
        System.out.println("FLY METHOD");
        System.out.println("----------------------------------------");
        b1.fly(3);
        System.out.println("B1 health: " + b1.getHealth());

        System.out.println("\n\n");
        //Bison 2 calls
        
        System.out.println("----------------------------------------");
        System.out.println("GET METHODS");
        System.out.println("----------------------------------------");
        System.out.println("B2 name: " + b2.getName());
        System.out.println("B2 health: " + b2.getHealth());
        System.out.println("B2 fluffiness: " + b2.getFluffiness());
        System.out.println("----------------------------------------");
        System.out.println("SET METHODS");
        System.out.println("----------------------------------------");
        b1.setName("Wong");
        b1.setFluffiness(5);
        b1.setHealth(-5);
        System.out.println("B2 name: " + b1.getName());
        System.out.println("B2 health: " + b1.getHealth());
        System.out.println("B2 fluffiness: " + b1.getFluffiness());
        System.out.println("----------------------------------------");
        System.out.println("EAT METHODS");
        System.out.println("----------------------------------------");
        int[] healtharray2 = {5, 5, 3, 2};
        b1.eatSnack(healtharray2);
        System.out.println("B2 health: " + b1.getHealth());
        b1.eatSnack(10);
        System.out.println("B2 health: " + b1.getHealth());
        System.out.println("----------------------------------------");
        System.out.println("FLY METHOD");
        System.out.println("----------------------------------------");
        b1.fly(30);
        System.out.println("B2 health: " + b1.getHealth());
    }
}
