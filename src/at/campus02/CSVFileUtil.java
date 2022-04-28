package at.campus02;
/*
 *@created 09/04/2022 - 11:54
 *@project 07_uebung_top40
 *@author jennifer gassner

 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFileUtil {
    public static ArrayList<Song> readSongs(String path) {
        ArrayList<Song> songs = new ArrayList<Song>();
        ArrayList<Interpreter> interpreters = new ArrayList<Interpreter>();
        //interpreters.add(new Interpreter(3.7, Arrays.asList(1.0, 3.7), "Penis"));


        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                //System.out.println("Debug: CSVFileUtil");
                //System.out.println("Line: " + line);
                String header = "\uFEFFDW;LW;WW;Titel;Interpret;Bewertung";
                if (!line.equals(header)) {
                    String[] fields = line.split(";");
                    int dw = strToInt(fields[0]);
                    int lw = strToInt(fields[1]);
                    int ww = strToInt(fields[2]);
                    String title = fields[3];
                    String interpret = fields[4];
                    double rating = Double.parseDouble(fields[5].replace(',', '.'));
                    Song song = new Song(dw, lw, ww, title, interpret, rating);
                    songs.add(song);

                    for (String i : interpret.split(",|\\/")) {
                        String name = i.strip();

                        boolean isNewInterpreter = true;
                        Interpreter interpreterToModify = null;

                        for (Interpreter existingInterpreter : interpreters) {
                            if (existingInterpreter.getName().equals(name)) {
                                interpreterToModify = existingInterpreter;
                                isNewInterpreter = false;
                                break;
                            }
                        }
                        if (isNewInterpreter) {
                            interpreters.add(new Interpreter(rating, Arrays.asList(rating), name));
                        } else {
                            interpreterToModify.singleRat.add(rating);
                            interpreterToModify.avgRat = interpreterToModify.singleRat.stream().
                                    mapToDouble(Double::doubleValue).sum() / interpreterToModify.singleRat.size();

                        }
                        System.out.println(i.strip());
                    }
                }
            }
            return songs;
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found");
            fnf.printStackTrace();
            return songs;
        } catch (IOException e) {
            //for handling readline exceptions
            throw new RuntimeException(e);
        }
    }

    public static void generateCSV(String path, String title, ArrayList<Song> songs, ArrayList<Interpreter> interpreters) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(path));
            //for (int i = 0; i < songs.size(); i++) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer strToInt(String in) {
        if (in.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(in);
        }
    }
}

