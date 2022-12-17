package HW8;

/**
 * HW8.LinkedList class based on Nodes.
 * @author Anthony Wong
 * @version 1.0
 * @param <T> is the generic class
 */
public class LinkedList<T> implements List<T>, Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * HW8.LinkedList constructor.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Check if empty.
     * @return if empty
     */
    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * Get size of HW8.LinkedList.
     * @return size of HW8.LinkedList
     */
    @Override
    public int size() {
        int count = 0;
        if (head == null && tail == null) {
            return 0;
        } else {
            Node<T> temp = head;
            while (temp != null) {
                count++;
                temp = temp.getNext();
            }
            return count;
        }
    }

    /**
     * Add nodes to data structs.
     * @param index The index at which data will be added
     * @param data  the data to add
     */
    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (data == null) {
            throw new NullPointerException("Data passed in is null!");
        } else if (isEmpty()) {
            Node<T> newnode = new Node<>(data);
            head = newnode;
            tail = newnode;
        } else if (index == 0) {
            Node<T> newnode = new Node<>(data);
            newnode.setNext(head);
            head = newnode;
        } else if (index == size()) {
            addToBack(data);
        } else {
            Node<T> newnode = new Node<>(data);
            int pos = 1;
            Node<T> prev = head;
            Node<T> cur = prev.getNext();
            while (pos != index) {
                pos++;
                cur = cur.getNext();
                prev = prev.getNext();
            }
            prev.setNext(newnode);
            newnode.setNext(cur);
            if (index == size() - 1) {
                tail = newnode;
            }
        }
    }

    /**
     * Add to back of data struct.
     * @param data the data to add
     */
    @Override
    public void addToBack(T data) {
        if (size() == 0) {
            Node<T> newnode = new Node<>(data);
            head = newnode;
            tail = newnode;
        } else {
            Node<T> newnode = new Node<>(data);
            tail.setNext(newnode);
            tail = newnode;
        }
    }

    /**
     * Remove from data struct.
     * @param index the index to remove from
     * @return the data removed
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (head == null && tail == null) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (size() == 1) {
            Node<T> ret = new Node<>(head.getData());
            head = null;
            tail = null;
            return ret.getData();
        } else if (index == 0) {
            Node<T> ret = new Node<>(head.getData());
            head = head.getNext();
            return ret.getData();
        } else {
            int pos = 1;
            Node<T> prev = head;
            Node<T> cur = head.getNext();
            while (pos != index) {
                pos++;
                prev = prev.getNext();
                cur = cur.getNext();
            }
            if (index == size() - 1) {
                tail = prev;
            }
            prev.setNext(cur.getNext());
            return cur.getData();
        }
    }

    /**
     * Get data from index.
     * @param index the index to return from
     * @return data at the index
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (head == null && tail == null) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (index == 0) {
            return head.getData();
        } else if (index == size() - 1) {
            return tail.getData();
        } else {
            Node<T> temp = head.getNext();
            int pos = 1;
            while (pos != index) {
                pos++;
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

    /**
     * Overwrite data at an index.
     * @param index The index at which data will be added
     * @param data the data to add
     * @return the old data
     */
    @Override
    public T set(int index, T data) {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (head == null && tail == null) {
            throw new IllegalArgumentException("Invalid Index!");
        } else if (data == null) {
            throw new NullPointerException("Data passed in is null!");
        } else if (index == 0) {
            T ret = head.getData();
            head.setData(data);
            return ret;
        } else if (index == size() - 1) {
            T ret = tail.getData();
            tail.setData(data);
            return ret;
        } else {
            int pos = 1;
            Node<T> cur = head.getNext();
            while (pos != index) {
                pos++;
                cur = cur.getNext();
            }
            T ret = cur.getData();
            cur.setData(data);
            return ret;
        }
    }

    /**
     * Check if data is in HW8.LinkedList.
     * @param data the data to look for
     * @return is data is in HW8.LinkedList
     */
    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new NullPointerException("Null data cannot be in list");
        } else if (isEmpty()) {
            return false;
        } else if (head.getData().equals(data)) {
            return true;
        } else if (tail.getData().equals(data)) {
            return true;
        } else {
            Node<T> cur = head.getNext();
            while (cur.getNext() != null) {
                if (cur.getData().equals(data)) {
                    return true;
                }
                cur = cur.getNext();
            }
            return false;
        }
    }

    /**
     * Clear the HW8.LinkedList.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Get sublist of Nodes at odd indices.
     * @return new HW8.LinkedList
     */
    @Override
    public List<T> subOddList() {
        LinkedList<T> ret = new LinkedList<>();
        if (head == null && tail == null) {
            throw new IllegalArgumentException("HW8.List is empty");
        } else {
            int pos = 0;
            Node<T> cur = head;
            while (cur != null) {
                if (pos % 2 == 1) {
                    ret.addToBack(cur.getData());
                }
                pos++;
                cur = cur.getNext();
            }
        }
        return ret;
    }

    /**
     * Add to queue.
     * @param data the data to add to the queue.
     */
    @Override
    public void enqueue(T data) {
        Node<T> newnode = new Node<>(data);
        if (data == null) {
            throw new NullPointerException("Data passed in is null!");
        }
        if (isEmpty()) {
            head = newnode;
            tail = newnode;
        } else {
            addToBack(data);
        }
    }

    /**
     * Remove from queue.
     * @return data of HW8.Node removed
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Empty queue.");
        }
        return remove(0);
    }

    /**
     * Overridden toString method.
     * @return string rep of HW8.LinkedList objects
     */
    @Override
    public String toString() {
        String ret = "";
        if (isEmpty()) {
            return "";
        } else {
            ret += "[" + head.getData() + "]";
            Node<T> cur = head.getNext();
            while (cur != null) {
                ret += " --> [" + cur.getData() + "]";
                cur = cur.getNext();
            }
        }
        return ret;
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<String> linkedlist = new LinkedList<>();
        System.out.println("----------------------------------");
        System.out.println("HW8.LinkedList");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("Adding...");
        System.out.println("----------------------------------");
        linkedlist.add(0, "Anthony");
        linkedlist.add(1, "Samay");
        linkedlist.add(2, "Chance");
        linkedlist.addToBack("Will");
        linkedlist.addToBack("Ben");
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());
        System.out.println("----------------------------------");
        System.out.println("Removing...");
        System.out.println("----------------------------------");
        System.out.println(linkedlist.remove(4));
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());
        System.out.println("----------------------------------");
        System.out.println("Adding to back...");
        System.out.println("----------------------------------");
        linkedlist.addToBack("Ben");
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());
        System.out.println("----------------------------------");
        System.out.println("Insertion adding...");
        System.out.println("----------------------------------");
        linkedlist.add(4, "Alex");
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());
        System.out.println("----------------------------------");
        System.out.println("Get index 0...");
        System.out.println("----------------------------------");
        System.out.println(linkedlist.get(0));
        System.out.println("----------------------------------");
        System.out.println("Set name...");
        System.out.println("----------------------------------");
        System.out.println(linkedlist.set(4, "Alec"));
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());
        System.out.println("----------------------------------");
        System.out.println("Checking contains...");
        System.out.println("----------------------------------");
        System.out.println(linkedlist.contains("Anthon"));
        System.out.println("----------------------------------");
        System.out.println("Getting sublist...");
        System.out.println("----------------------------------");
        System.out.println(linkedlist.subOddList());
        System.out.println("----------------------------------");
        System.out.println("Clearing and checking if empty...");
        System.out.println("----------------------------------");
        linkedlist.clear();
        System.out.println(linkedlist.isEmpty());
        System.out.println(linkedlist);
        System.out.println(linkedlist.size());
        System.out.println("----------------------------------");
        System.out.println("HW8.Queue");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("Queuing...");
        System.out.println("----------------------------------");
        Queue<String> queue = new LinkedList<>();
        queue.enqueue("Anthony");
        queue.enqueue("Samay");
        queue.enqueue("Rohith");
        System.out.println(queue);
        System.out.println("----------------------------------");
        System.out.println("Dequeuing...");
        System.out.println("----------------------------------");
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println("----------------------------------");
        System.out.println("Check if empty...");
        System.out.println("----------------------------------");
        System.out.println(queue.isEmpty());
    }
}
