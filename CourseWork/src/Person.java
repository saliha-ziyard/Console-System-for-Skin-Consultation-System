// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

public class Person {

    //instance variables of Person class
    String name;
    String sName;
    String DOB;
    String mobNo;

    //constructor
    public Person(String name, String sName, String DOB, String mobNo) {
        this.name = name;
        this.sName = sName;
        this.DOB = DOB;
        this.mobNo = mobNo;
    }

    //Getters and setters of Person class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}


