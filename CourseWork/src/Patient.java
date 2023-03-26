// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import java.util.ArrayList;

public class Patient extends Person{

    //instance variables of Patient class
    String patientId;
    String notes;
    String cost;
    static ArrayList<Patient> patDet = new ArrayList<>(); //arraylist used to store patient information

    //constructor
    public Patient(String patientId, String name, String sName, String DOB, String mobNo,String notes,String cost) {
        super(name, sName, DOB, mobNo);
        this.patientId = patientId;
        this.notes = notes;
        this.cost = cost;
    }


    //getters and setters
    public String  getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getCost() { return cost;}

    public void setCost(String cost) {this.cost = cost; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
