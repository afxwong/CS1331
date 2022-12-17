package HW6;

import java.io.File;

/**
 * Main file for creating song objects.
 * @author Anthony Wong
 * @version 1.0
 */
public class Song {
    private String name;
    private String artist;
    private String genre;
    private File file;

    /**
     * Constructor for HW6.Song objects.
     * @param name is song name
     * @param artist is song artist
     * @param genre is song genre
     * @param file is song file location
     */
    public Song(String name, String artist, String genre, File file) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.file = file;
    }

    /**
     * Getter for name.
     * @return song name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for artist.
     * @return artist
     */
    public String getArtist() {
        return this.artist;
    }

    /**
     * Getter for genre.
     * @return genre
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Getter for file.
     * @return file location
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Overriden toString.
     * @return string rep of object
     */
    @Override
    public String toString() {
        return this.name + " by " + this.artist + "\nGenre: " + this.genre + "\nFile: "
            + this.file.getName();
    }

    /**
     * Overriden equals.
     * @return whether objects are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Song s;
        if (obj == null) {
            return false;
        } else {
            s = (Song) obj;
            return this.getName().equals(s.getName()) && this.getArtist().equals(s.getArtist())
                && this.getGenre().equals(s.getGenre());
        }
    }
}
