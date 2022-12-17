package HW6;

/**
 * Unchecked exception class for unfound artist.
 * @author Anthony Wong
 * @version 1.0
 */
public class NotAnArtistException extends RuntimeException {
    /**
     * Constructor for Artist Exception.
     */
    public NotAnArtistException() {
        super("That is not an artist we know!");
    }
}
