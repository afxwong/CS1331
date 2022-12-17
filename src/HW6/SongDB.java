package HW6;

import HW6.NotAnArtistException;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Driver class for song program.
 * @author Anthony Wong
 * @version 1.0
 */
public class SongDB {
    /**
     * Creates song objects and places them into ArrayList.
     * @param dir main directory
     * @return ArrayList of songs
     * @throws FileNotFoundException directory cannot be found
     */
    public static ArrayList<Song> load(File dir) throws FileNotFoundException {
        FileNotFoundException error = new FileNotFoundException();
        ArrayList<Song> songlist = new ArrayList<Song>();
        File[] genre;
        try {
            genre = dir.listFiles();
        } catch (Exception e) {
            throw error;
        }
        for (File g : genre) {
            for (File a : g.listFiles()) {
                for (File s : a.listFiles()) {
                    Scanner scan = new Scanner(s);
                    String name = scan.nextLine();
                    songlist.add(new Song(name, a.getName(), g.getName(), s));
                }
            }
        }
        return songlist;
    }

    /**
     * Creates file with all songs from ArrayList.
     * @param songlist ArrayList of songs
     * @throws FileNotFoundException file not found
     */
    public static void outputData(ArrayList<Song> songlist) throws FileNotFoundException {
        File outfile = new File("HW6.SongDB.txt");
        PrintWriter outwriter = new PrintWriter(outfile);
        for (Song s : songlist) {
            outwriter.println(s.getName());
            outwriter.println(s.getArtist());
            outwriter.println(s.getGenre());
            outwriter.println();
        }
        outwriter.close();
    }

    /**
     * Find given song and print first five lines, character count, and longest line.
     * @param s is song to find
     * @param songlist ArrayList of songs
     * @throws SongNotFoundException song not found
     * @throws FileNotFoundException file not found
     */
    public static void readSong(Song s, ArrayList<Song> songlist) throws SongNotFoundException, FileNotFoundException {
        SongNotFoundException error = new SongNotFoundException("HW6.Song " + s.getName()
            + " was not found in the database!");
        boolean found = false;
        for (Song c : songlist) {
            if (s.equals(c)) {
                Scanner scan = new Scanner(c.getFile());
                String longest = "";
                int highest = 0;
                int wordcount = 0;
                int linecount = 1;
                found = true;
                while (scan.hasNext()) {
                    String line = scan.nextLine();
                    if (line.length() > highest) {
                        highest = line.length();
                        longest = line;
                    }
                    if (linecount > 2 && linecount < 8) {
                        System.out.println(line);
                    }
                    wordcount += line.length();
                    linecount++;
                }
                System.out.println();
                System.out.println("Word Count: " + wordcount);
                System.out.println("Longest Line: " + longest);
            }
        }
        if (!found) {
            throw error;
        }
    }

    /**
     * Find songs made by artist.
     * @param name artist name
     * @param songlist ArrayList of songs
     * @throws NotAnArtistException artist not found
     */
    public static void listArtistSongs(String name, ArrayList<Song> songlist) throws NotAnArtistException {
        int count = 0;
        NotAnArtistException error = new NotAnArtistException();
        for (Song s : songlist) {
            if (s.getArtist().equals(name)) {
                System.out.println(s);
                count++;
            }
        }
        if (count == 0) {
            throw error;
        }
    }

    /**
     * Main method.
     * @param args aruments
     * @throws FileNotFoundException file not found
     * @throws SongNotFoundException song not found
     */
    public static void main(String[] args) {
        try {
            File f = new File("database_songs");
            File newf = new File("database_songs\\Pop\\Simply Red\\SoNotOverYou.txt");
            Song s = new Song("So Not Over You", "Simply Red", "Pop", newf);
            System.out.println("No errors");
            System.out.println("--------------------------------------");
            System.out.println("Read HW6.Song");
            System.out.println("--------------------------------------");
            ArrayList<Song> songlist = load(f);
            readSong(s, songlist);
            outputData(songlist);
            System.out.println("--------------------------------------");
            System.out.println("HW8.List Artist Songs");
            System.out.println("--------------------------------------");
            listArtistSongs("Kenny Loggins", songlist);
            System.out.println("--------------------------------------");
            System.out.println("Catch HW6.SongNotFoundException");
            System.out.println("--------------------------------------");
            s = new Song("SoNotOverYou", "Simply Red", "Pop", newf);
            readSong(s, songlist);
        } catch (FileNotFoundException e1) {
            System.out.println("File not found");
        } catch (SongNotFoundException e2) {
            System.out.println("HW6.Song not found");
        } catch (Exception e3) {
            System.out.println("Some other issue");
        }
    }
}
