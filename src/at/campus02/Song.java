package at.campus02;/*
 *@created 09/04/2022 - 11:54
 *@project 07_uebung_top40
 *@author jennifer gassner

 */

public class Song implements Comparable {
    int dw;
    int lw;
    int ww;
    String title;
    String interpret;
    Double ranking;

    public Song(int dw, int lw, int ww, String title, String interpret, Double ranking) {
        this.dw = dw;
        this.lw = lw;
        this.ww = ww;
        this.title = title;
        this.interpret = interpret;
        this.ranking = ranking;

    }

    public int getDw() {
        return dw;
    }

    public int getLW() {
        return lw;
    }

    public int getWW() {
        return ww;
    }

    public String getTitle() {
        return title;
    }

    public String getInterpret() {
        return interpret;
    }

    public Double getRanking() {
        return ranking;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
