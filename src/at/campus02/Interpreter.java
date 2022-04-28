package at.campus02;/*
 *@created 09/04/2022 - 11:54
 *@project 07_uebung_top40
 *@author jennifer gassner

 */

import javax.swing.*;
import java.util.List;

public class Interpreter {
    Double avgRat;
    List<Double> singleRat;
    String name;


    public Interpreter(Double avgRat, List<Double> singleRat, String name) {
        this.avgRat = avgRat;
        this.singleRat = singleRat;
        this.name = name;
    }

    public Interpreter() {

    }

    public Double getavgRat() {
        return avgRat;
    }

    public List<Double> singleRat() {
        return singleRat;
    }

    public String getName() {
        return name;
    }


}
