// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

public class Doctor extends Person{

    //instance variables of Doctor class
    int medLicenceNo;
    String specialisation;

    //constructor
    public Doctor(String name, String sName, String DOB, String mobNo, int medLicenceNo, String specialisation) {
        super(name, sName, DOB, mobNo);
        this.medLicenceNo = medLicenceNo;
        this.specialisation = specialisation;
    }

    //getters and setters
    public int getMedLicenceNo() {
        return medLicenceNo;
    }

    public void setMedLicenceNo(int medLicenceNo) {
        this.medLicenceNo = medLicenceNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

}

