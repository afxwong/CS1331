package HW6;

/**
 * Unchecked exception class for unfound song.
 * @author Anthony Wong
 * @version 1.0
 */
public class SongNotFoundException extends Exception {
    /**
     * Constructor for HW6.Song Exception.
     * @param message to print
     */
    public SongNotFoundException(String message) {
        super(message);
    }
}
