// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import java.io.*;
import java.text.ParseException;
import java.util.*;

interface SkinConsultationManager{
    default void addDoctor(Doctor name){
    };
    default void removeDoctor(int medLicenceNum){
    };
    default void printDoctor(){
    };
    default void saveDoctor(){
    };
    default void gui(){
    }
    default  void menu(){
    };
    default  void loadDoctor(){
    };
}

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
     //static no need to create objects
    static String option;
    static Scanner input = new Scanner(System.in);
    static ArrayList<Doctor> doctor = new ArrayList<>();


    public static void main(String[] args) throws ParseException {

        WestminsterSkinConsultationManager use = new WestminsterSkinConsultationManager(); //create object for the class WestminsterSkinConsultationManager

        //calling the load functions to read back all the information saved in the file
        use.loadDoctor();
        Form.loadPatient();
        Form.loadConsultation();


        System.out.println();
        do{
            use.menu();
            System.out.println("Select an option: ");
            option = input.next().toLowerCase(Locale.ROOT);
            switch (option){
                case "a" -> addDoctor(); //calling the addDoctor method
                case "r" -> removeDoctor(); //calling the removeDoctor method
                case "p" -> use.printDoctor(); //calling the printDoctor method
                case "s" -> use.saveDoctor(); //calling the saveDoctor method
                case "b" -> use.gui(); ////calling the JFrame to add patient
            };
        }
        while (!option.equals("e"));
    }


    public void menu(){
        System.out.println("A - Add a Doctor\n"+
                "R - Remove a Doctor\n"+
                "P - Print the list of Doctors\n"+
                "S - Save the list of Doctors in a file\n"+
                "B - Book Appointment\n"+
                        "E - End the program\n"
                );
    }

    //checks if slot is full
    public void addDoctor(Doctor name){
        if(doctor.size()==10){
            System.out.println("Slot is full");
        }
        else doctor.add(name);
    }

    public static void addDoctor() throws ParseException {
        WestminsterSkinConsultationManager call = new WestminsterSkinConsultationManager();

        String fName;
        do {
            System.out.println("Enter First Name:");
            fName = input.next().toLowerCase(Locale.ROOT);
            if ((fName.matches("^[a-zA-Z\\s]+$")) ){
                break;
            } else {
                System.out.println("Invalid Name. Please try again.");
            }
        } while (true);

        String sName;
        do {
            System.out.println("Enter Sur Name: ");
            sName = input.next().toLowerCase(Locale.ROOT);
            if ((sName.matches("^[a-zA-Z\\s]+$")) ){
                break;
            } else {
                System.out.println("Invalid Name. Please try again.");
            }
        } while (true);

        String dob;
        do {
            System.out.println("Enter Date of Birth (dd/mm/yyyy): ");
            dob = input.next();
            if ((dob.matches("^((?:0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)[0-9][0-9]))$")) ){
                break;
            } else {
                System.out.println("Invalid Date. Please try again.");
            }
        } while (true);

        String mobNo;
        do {
            System.out.println("Enter Mobile Number: ");
            mobNo = input.next();
            if ((mobNo.length() == 10) && (mobNo.matches("[0-9]+")) ){
                break;
            } else {
                System.out.println("Invalid phone number. Please try again.");
            }
        } while (true);

        int medLicenceNo = 0;
        try {
            System.out.println("Enter Medical License Number: ");
            medLicenceNo = input.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Doctor doctor : doctor) {
            if (medLicenceNo == doctor.getMedLicenceNo()) {
                while (true) {
                    System.out.println("\n--ID already exists, re-enter the license ID:");
                    medLicenceNo = input.nextInt();
                    if (medLicenceNo != doctor.getMedLicenceNo())
                        break;
                }
            }
        }

        System.out.println("Enter Specialization: ");
        String specialisation = input.nextLine().toLowerCase(Locale.ROOT);
        specialisation += input.nextLine();

        System.out.println("Dr."+fName+" has been added to the system");

        Doctor doc = new Doctor(fName, sName, dob, mobNo, medLicenceNo, specialisation);
        call.addDoctor(doc);
    }

    //medical number validation, deletion and tot number of doctors
    public void removeDoctor(int medLicenceNum){

        if (!doctor.isEmpty()) {

            int have = 0;
            for (Doctor q :doctor){
                if (q.getMedLicenceNo() == medLicenceNum) {
                    doctor.remove(q);  //remove a specific doctor from the arrayList named doctor
                    System.out.println("Dr."+q.name+" "+q.sName+" with medical licence number "+q.medLicenceNo+ " has been removed from the system");

                    System.out.println("Total number of Doctors remaining: "+doctor.size());
                    have=1;
                    break;
                }
            }
            if(have==0){
                System.out.println("Invalid Input");
            }
        } else {
            System.out.println("\nPlease appoint a doctor to the center prior removing.\n");
            return;
        }
    }

    public static void removeDoctor(){

        System.out.println("Enter Medical Licence Number: ");
        int medLicenceNo = input.nextInt();

        WestminsterSkinConsultationManager call = new WestminsterSkinConsultationManager();
        call.removeDoctor(medLicenceNo);
    }

    public void printDoctor() {

        ArrayList<Doctor> doc = doctor;
        doc.sort(Comparator.comparing(Doctor::getsName));

        if (!doc.isEmpty()) {
            for ( Doctor a : doc) {

            System.out.println("first name: "+a.getName()+
                    "\nsur name: "+a.getsName()+
                    "\nDOB: "+a.getDOB()+
                    "\nmobNo: "+a.getMobNo()+
                    "\nMedLicenceNo: "+a.getMedLicenceNo()+
                    "\nSpecialisation: "+a.getSpecialisation());
            System.out.println();
        }
        }
        else
        {
            System.out.println("\nPlease appoint a doctor to the center prior display info\n");
        }
    }

    public void saveDoctor() {
        try {
            File object1 = new File("DoctorDetails.txt");
            FileWriter writer = new FileWriter("DoctorDetails.txt");
            for (Doctor str : doctor) {

                writer.write("first name: " + str.getName() + "\n"+
                        "sur name: " + str.getsName() + "\n"+
                        "DOB: " + str.getDOB() + "\n"+
                        "mobNo: "+ str.getMobNo()+ "\n"+
                        "MedLicenceNo: " + str.getMedLicenceNo() + "\n"+
                        "Specialisation: " + str.getSpecialisation() +"\n") ; // + System.lineSeparator()
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        System.out.println("Doctor details saved");
    }

    public void loadDoctor(){

        String[] load = new String[6];
        try {
            File object = new File("DoctorDetails.txt");
            Scanner reader = new Scanner(object);
            int n = 0;
            while (reader.hasNextLine())
            {
                String info = reader.nextLine();
                String[] ee = info.split(":");

                if(n == load.length){
                    int num = Integer.parseInt(load[4].trim());
                    Doctor doc = new Doctor(load[0],load[1],load[2],load[3],num,load[5]);
                    doctor.add(doc);
                    n =0;
                }
                else{
                    load[n] = ee[1];
                    n++;
                }
            }
            //reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Text file not created");
            //e.printStackTrace();
        }
    }

    public void gui() {
        Form frame = new Form();

    }
}

