// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import java.util.ArrayList;

public class Consultation {

    //private variables of Consultation class
    String name;
    String date;
    String sTime;
    String eTime;

    //ArrayList used to store doctor details
    static ArrayList<Consultation> docDet = new ArrayList<>();

    //constructor
    public Consultation(String name, String date, String sTime, String eTime) {
        this.name = name;
        this.date = date;
        this.sTime = sTime;
        this.eTime = eTime;
    }

    //getters and setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getsTime() { return sTime; }

    public void setsTime(String sTime) { this.sTime = sTime; }

    public String geteTime() { return eTime; }

    public void seteTime(String eTime) { this.eTime = eTime; }

}


