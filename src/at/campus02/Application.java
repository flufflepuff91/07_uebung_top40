package at.campus02;
/*
 *@created 09/04/2022 - 11:54
 *@project 07_uebung_top40
 *@author jennifer gassner

 */
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // write your code here
        if (args.length != 1) {
            System.out.println("Usage: <Please provide Path to CSV in args>");
            System.exit(0);
        }
        String path = args[0];
        ArrayList<Song> songs = createSongs(path);


        /*public static ArrayList<Song> createSongList(String path){
            ArrayList<Song> songs = new CSVFileUtil(path);*/
        //}
    }


    public static ArrayList<Song> createSongs(String path) {
        ArrayList<Song> songs = CSVFileUtil.readSongs(path);
        return songs;
    }
}