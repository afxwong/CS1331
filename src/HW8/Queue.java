package HW8;

/**
 * Represents the HW8.Queue Abstract Data type.
 * @author Melanie
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface Queue<T> {
    /**
     * Checks to see this HW8.Queue is empty.
     * If it is empty, throw an IllegalArgumentException
     * @return true if HW8.Queue is empty, false if not
     */
    boolean isEmpty();
    /**
     * Adds data to the HW8.Queue. Think about what kind of object
     * this data should reside in and where it should go to satisfy
     * the FIFO (first in first out) characteristic of a HW8.Queue.
     * If data is null, throw an NullPointerException
     * @param data the data to add to the queue.
     */
    void enqueue(T data);
    /**
     * Removes an object from the HW8.Queue and returns the data that
     * object holds. Remember the FIFO characteristic of a HW8.Queue.
     * If the HW8.Queue is empty, utilize a previous method to handle this case
     * @return the dequeued item
     */
    T dequeue();
}