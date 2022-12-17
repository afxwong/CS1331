package HW5;

import java.util.ArrayList;

/**
 * Driver class for MagicItem.java. Houses chests of MagicItems.
 * @author Anthony Wong
 * @version 1.0
 */
public class Chest {
    private ArrayList<MagicItem> itemsInside;

    /**
     * Chest Constructor.
     * @param itemsInside is intial list of MagicItems
     */
    public Chest(ArrayList<MagicItem> itemsInside) {
        this.itemsInside = itemsInside;
    }

    /**
     * No-args Chest Constructor.
     */
    public Chest() {
        this(new ArrayList<MagicItem>());
    }

    /**
     * Selection sort for chest object based on power.
     */
    public void sortChest() {
        for (int i = 0; i < itemsInside.size(); i++) {
            int minidx = i;
            for (int j = i + 1; j < itemsInside.size(); j++) {
                if (itemsInside.get(j).compareTo(itemsInside.get(minidx)) <= 0) {
                    minidx = j;
                }
            }
            MagicItem temp = itemsInside.get(minidx);
            itemsInside.set(minidx, itemsInside.get(i));
            itemsInside.set(i, temp);
        }
    }

    /**
     * Add item to chest.
     * @param m is item to add
     */
    public void addItem(MagicItem m) {
        this.itemsInside.add(m);
    }

    /**
     * Binary Search on chest ArrayList to find item with same power.
     * @param m is item to match with
     * @return matched item
     */
    public MagicItem findItem(MagicItem m) {
        this.sortChest();
        int left = 0, right = itemsInside.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (itemsInside.get(middle).compareTo(m) == 0) {
                System.out.println(itemsInside.get(middle).getName());
                return itemsInside.get(middle);
            } else if (itemsInside.get(middle).compareTo(m) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null;
    }

    /**
     * Binary Search on chest ArrayList to find item with same power.
     * @param m is item to match with
     * @return is position of matching item
     */
    public int findItemLoc(MagicItem m) {
        this.sortChest();
        int left = 0, right = itemsInside.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (itemsInside.get(middle).compareTo(m) == 0) {
                return middle;
            } else if (itemsInside.get(middle).compareTo(m) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * Remove certain item from chest based on power.
     * @param m is item to match
     * @return is item removed
     */
    public MagicItem removeItem(MagicItem m) {
        int res = findItemLoc(m);
        if (res == -1) {
            return null;
        } else {
            MagicItem ret = itemsInside.get(res);
            itemsInside.remove(res);
            return ret;
        }
    }

    /**
     * Removes the lowest power item from chest.
     * @return item removed
     */
    public MagicItem removeJunk() {
        this.sortChest();
        MagicItem ret = itemsInside.get(0);
        itemsInside.remove(0);
        return ret;
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        Lamp l1 = new Lamp("Lamp 1", 40, false);
        Carpet c1 = new Carpet("Carpet 1", 50, 5);
        Carpet c2 = new Carpet("Carpet 2", 5, 0);
        Wand w1 = new Wand("Wand 1", 30, "Anthony");
        Lamp l2 = new Lamp("Lamp 2", 60, true);
        Wand w2 = new Wand("Wand 2", 10, "Wong");
        Chest c = new Chest();
        // Adding Items
        c.addItem(l1);
        c.addItem(l2);
        c.addItem(c1);
        c.addItem(c2);
        c.addItem(w1);
        c.addItem(w2);
        System.out.println("Checking ArrayList");
        System.out.println("------------------------");
        System.out.println(c.itemsInside);
        System.out.println("------------------------");
        System.out.println("Invoking");
        System.out.println("------------------------");
        l1.invoke();
        c1.invoke();
        l2.invoke();
        c2.invoke();
        c2.recharge(10);
        c2.invoke();
        w1.invoke();
        c2.land();
        System.out.println("------------------------");
        System.out.println("Checking ArrayList");
        System.out.println("------------------------");
        System.out.println(c.itemsInside);
        System.out.println("------------------------");
        System.out.println("Sorting ArrayList");
        System.out.println("------------------------");
        c.sortChest();
        System.out.println(c.itemsInside);
        System.out.println("------------------------");
        System.out.println("Find Item");
        System.out.println("------------------------");
        Wand w3 = new Wand("Dummy Wand", 5, "Dummy Owner");
        System.out.println(c.findItem(w3));
        System.out.println("------------------------");
        System.out.println("Remove Item");
        System.out.println("------------------------");
        System.out.println(c.removeItem(w3));
        System.out.println("------------------------");
        System.out.println("Checking ArrayList");
        System.out.println("------------------------");
        System.out.println(c.itemsInside);
        System.out.println("------------------------");
        System.out.println("Remove Junk");
        System.out.println("------------------------");
        System.out.println(c.removeJunk());
        System.out.println("------------------------");
        System.out.println("Checking ArrayList");
        System.out.println("------------------------");
        System.out.println(c.itemsInside);
        System.out.println("------------------------");
    }
}
