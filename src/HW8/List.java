package HW8;

/**
 * Represents the HW8.List Abstract Data type.
 * @author Melanie
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface List<T> {
    /**
     * Checks to see this HW8.List is empty.
     * If it is empty, throw an IllegalArgumentException
     * @return true if HW8.List is empty, false if not
     */
    boolean isEmpty();
    /**
     * Returns the size of the HW8.List.
     * Must be implemented by iterating through the nodes.
     * Do not use a private size instance variable
     * @return the number of items in this list
     */
    int size();
    /**
     * Adds data to the HW8.List at the specified index.
     * If the index is less than 0 or greater than size(), throw
     * an IllegalArgumentException. If the passed in data is null,
     * throw a NullPointerException
     * @param index The index at which data will be added
     * @param data  the data to add
     */
    void add(int index, T data);
    /**
     * Adds data to the back of the HW8.List.
     * If the passed in data is null, throw a NullPointerException
     * @param data  the data to add
     */
    void addToBack(T data);
    /**
     * Removes the object at the specified index and returns the data that object holds.
     * If the HW8.List is empty, throw an IllegalArgumentException.
     * @param index the index to remove from
     * @return the removed piece of data
     */
    T remove(int index);
    /**
     * Retrieves the data from the specified index and returns it.
     * If the HW8.List is empty or the index is less than 0 or greater than
     * or equal size(), throw an IllegalArgumentException.
     * @param index the index to return from
     * @return the data at the specified index
     */
    T get(int index);
    /**
     * Adds data to the HW8.List at the specified index.
     * If the index is less than 0 or greater than size(), throw
     * an IllegalArgumentException. If the passed in data is null,
     * throw a NullPointerException
     * @param index The index at which data will be added
     * @param data  the data to add
     * @return the data originally at the specified index
     */
    T set(int index, T data);
    /**
     * Checks to see if the HW8.List contains the passed in data.
     * If the passed in data is null, throw a NullPointerException
     * @param data the data to look for
     * @return true if the HW8.List contains the passed in data, false if not
     */
    boolean contains(T data);
    /**
     * Removes all elements from the HW8.List.
     */
    void clear();
    /**
     * Returns a new HW8.List object containing every odd element in this HW8.List.
     * For example, if our HW8.List contains [“a”, “b”, “c”, “d”], then
     * subOddList() should return a new HW8.List containing [“b”, “d”]. This
     * method should not modify the original HW8.List in any way and the new
     * HW8.List should not have overlapping elements with the original HW8.List. If
     * the original HW8.List is empty, throw an IllegalArgumentException
     * @return a new HW8.List object containing the odd elements in the current list, as described above
     */
    List<T> subOddList();
}
