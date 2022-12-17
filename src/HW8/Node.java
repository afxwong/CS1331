package HW8;

/**
 * Base HW8.Node class.
 * @author Anthony Wong
 * @version 1.0
 * @param <T> is the generic class
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * 2-args HW8.Node constructor.
     * @param data is node data
     * @param next is the next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 1-arg HW8.Node constructor.
     * @param data is node data
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Getter for data.
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for data.
     * @param data new data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Setter for next.
     * @param next is the new node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Getter for next.
     * @return is the next node
     */
    public Node<T> getNext() {
        return next;
    }
}
