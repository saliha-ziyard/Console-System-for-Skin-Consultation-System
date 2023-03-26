// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Form extends JFrame implements ActionListener {

    private JPanel c;
    private JLabel title, fName, sName, mob, dob, Id, date, stime, etime, note, doc, cost, picLabel;
    private JTextField tFname, tSname, tDob, tmob, tId, tdate, tstime, tetime;
    private JLabel vFname, vSname, vdob, vmob, vId, vdate, vstime, vetime;
    private JTextArea tnote;
    private JComboBox tdoc;
    private JButton btnDoc, btnSub, btnImg, btnCheckA;
    private String str, a;
    static int num = 0;


    //constructor
    public Form() {

        //Panel
        c = new JPanel();
        c.setLayout(null);
        c.setBounds(0, 0, 90, 90);
        c.setBackground(Color.pink);
        add(c);
        addLabelText();
        setBounds();
        setFont();
        addActionListener();
        addComponents();


        //Combo box
        tdoc = new JComboBox(WestminsterSkinConsultationManager.doctor.toArray());
        tdoc.setBounds(220, 415, 165, 25);
        DefaultComboBoxModel tdoct = new DefaultComboBoxModel(WestminsterSkinConsultationManager.doctor.toArray());
        for (int i = 0; i < WestminsterSkinConsultationManager.doctor.size(); i++) {
            tdoct.addElement(WestminsterSkinConsultationManager.doctor.get(i).getName());
            tdoct.removeElement(WestminsterSkinConsultationManager.doctor.get(i));
        }
        tdoc.setModel(tdoct);
        c.add(tdoc);


        //frame
        setTitle("Westminster Skin Consultation Unit");
        add(c);
        setBounds(300, 90, 950, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    //Add labels and text fields
    public void addLabelText() {
        title = new JLabel("Book A Consultation at Westminster Skin Consultation");
        Id = new JLabel("Patient ID");
        tId = new JTextField();
        vId = new JLabel();
        fName = new JLabel("First Name");
        tFname = new JTextField(20);
        vFname = new JLabel();
        sName = new JLabel("Sur Name");
        tSname = new JTextField(20);
        vSname = new JLabel();
        dob = new JLabel("DOB (dd/MM/yyyy)");
        tDob = new JTextField();
        vdob = new JLabel();
        mob = new JLabel("Mobile Number");
        tmob = new JTextField();
        vmob = new JLabel();
        date = new JLabel("Consultation Date");
        tdate = new JTextField();
        vdate = new JLabel();
        stime = new JLabel("Start Time");
        tstime = new JTextField();
        vstime = new JLabel();
        etime = new JLabel("End Time");
        tetime = new JTextField();
        vetime = new JLabel();
        note = new JLabel("Enter Note ");
        tnote = new JTextArea();
        btnImg = new JButton("Add Image");

        picLabel = new JLabel();
        doc = new JLabel("Select Doctor");
        btnDoc = new JButton("Check Doctor Details");
        btnSub = new JButton("Submit");
        cost = new JLabel();
        btnCheckA = new JButton("Check Doctor Availability");
    }

    //Set location and size using bound
    public void setBounds() {

        title.setBounds(200, 10, 500, 30);
        Id.setBounds(90, 50, 80, 25);
        tId.setBounds(220, 50, 165, 25);
        vId.setBounds(420, 50, 165, 25);
        fName.setBounds(90, 80, 80, 25);
        tFname.setBounds(220, 80, 165, 25);
        vFname.setBounds(420, 80, 165, 25);
        sName.setBounds(90, 110, 80, 25);
        tSname.setBounds(220, 110, 165, 25);
        vSname.setBounds(420, 110, 165, 25);
        dob.setBounds(90, 140, 120, 25);
        tDob.setBounds(220, 140, 165, 25);
        vdob.setBounds(420, 140, 165, 25);
        mob.setBounds(90, 170, 120, 25);
        tmob.setBounds(220, 170, 165, 25);
        vmob.setBounds(420, 170, 165, 25);
        date.setBounds(90, 200, 120, 25);
        tdate.setBounds(220, 200, 165, 25);
        vdate.setBounds(420, 200, 165, 25);
        stime.setBounds(90, 230, 120, 25);
        tstime.setBounds(220, 230, 165, 25);
        vstime.setBounds(420, 230, 165, 25);
        etime.setBounds(90, 260, 120, 25);
        tetime.setBounds(220, 260, 165, 25);
        vetime.setBounds(420, 260, 165, 25);
        note.setBounds(90, 300, 120, 25);
        tnote.setBounds(220, 300, 200, 100);
        btnImg.setBounds(450, 300, 200, 25);

        picLabel.setBounds(580, 80, 300, 200);   //(420, 80, 165, 25);
        doc.setBounds(90, 415, 120, 25);
        btnDoc.setBounds(450, 330, 200, 25);
        btnCheckA.setBounds(450, 360, 200, 25);
        btnSub.setBounds(240, 465, 120, 25);
        cost.setBounds(600, 450, 120, 25);
    }

    //Set Font
    public void setFont() {
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        vId.setForeground(Color.RED);
        vFname.setForeground(Color.RED);
        vSname.setForeground(Color.RED);
        vdob.setForeground(Color.RED);
        vmob.setForeground(Color.RED);
        vdate.setForeground(Color.RED);
        vstime.setForeground(Color.RED);
        vetime.setForeground(Color.RED);
    }

    //Action listeners for buttons
    public void addActionListener() {
        btnDoc.addActionListener(this);
        btnSub.addActionListener(this);
        btnImg.addActionListener(this);
        btnCheckA.addActionListener(this);
    }

    //Add Components
    public void addComponents() {
        c.add(title);
        c.add(Id);
        c.add(tId);
        c.add(vId);
        c.add(fName);
        c.add(tFname);
        c.add(vFname);
        c.add(sName);
        c.add(tSname);
        c.add(vSname);
        c.add(dob);
        c.add(tDob);
        c.add(vdob);
        c.add(mob);
        c.add(tmob);
        c.add(vmob);
        c.add(date);
        c.add(tdate);
        c.add(vdate);
        c.add(stime);
        c.add(tstime);
        c.add(vstime);
        c.add(etime);
        c.add(tetime);
        c.add(vetime);
        c.add(note);
        c.add(tnote);
        c.add(btnImg);

        c.add(picLabel);
        c.add(doc);
        c.add(btnDoc);
        c.add(btnCheckA);
        c.add(btnSub);
        c.add(cost);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSub) {
            a = tdoc.getSelectedItem().toString();
            idValidate(tId.getText());
            fnameValidate(tFname.getText());
            snameValidate(tSname.getText());
            dobValidate(tDob.getText());
            mobValidate(tmob.getText());
            cDateValidate(tdate.getText());
            stimeValidate(tstime.getText());
            try {
                etimeValidate(tetime.getText());
            } catch (ParseException ex) {
                //ex.printStackTrace();
            }
            encryptText();


            //random doctor generation if the time slot is occupied
            if (num == 8) {
                for (Consultation d : Consultation.docDet) {
                    if (d.getName().equals(a)) {
                        if (d.getDate().equals(tdate.getText()) && d.getsTime().equals(tstime.getText())) { //checking if date and time are the same
                            Random ran = new Random();
                            int num = ran.nextInt(WestminsterSkinConsultationManager.doctor.size());
                            a = WestminsterSkinConsultationManager.doctor.get(num).getName();
                        }
                    }
                }

                Patient pat = new Patient(tId.getText(), tFname.getText(), tSname.getText(), tDob.getText(), tmob.getText(), tnote.getText(), cost.getText());
                Consultation doc = new Consultation(a, tdate.getText(), tstime.getText(), tetime.getText());

                Patient.patDet.add(pat);
                Consultation.docDet.add(doc);
                print();
                print1();
            }
            num = 0;

        }
        // Doctor Table Button
        if (e.getSource() == btnDoc) {
            new DoctorTable(WestminsterSkinConsultationManager.doctor).setVisible(true);
        }
        //Check Doctor Availability button
        if (e.getSource() == btnCheckA) {
            new DoctorAvailability();

        }
        //Add Image Button
        if (e.getSource() == btnImg) {
            addImg();
        }
    }


    //patient info validate
    // ID validation
    public void idValidate(String id) {
        if (id.isEmpty()) {
            vId.setText("Enter ID!");
        } else{
            num++;
            vId.setText(" ");
        }
    }

    //First validation
    public void fnameValidate(String name) {
        // define a regular expression for a valid name
        String pattern = "^[a-zA-Z\\s]+$";
        // create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // create a Matcher object
        Matcher m = r.matcher(name);

        if (name.isEmpty()) {
            vFname.setText("Enter First Name!");
        } else if (name.matches(pattern)) {
            num++;
            vFname.setText(" ");
        } else vFname.setText("Invalid Name!");
    }

    //Sur name validation
    public void snameValidate(String name) {
        String pattern = "^[a-zA-Z\\s]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(name);

        if (name.isEmpty()) {
            vSname.setText("Enter Sur Name!");
        } else if (name.matches(pattern)) {
            num++;
            vSname.setText(" ");

        } else
            vSname.setText("Invalid Name!");
    }

    //Date of birth validation
    public void dobValidate(String dob) {

        //dd/MM/uuuu
        if (dob.isEmpty()) {
            vdob.setText("Enter date of birth!");
        } else if (dob.matches("^((?:0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)[0-9][0-9]))$")) {

//            (20|21)[0-9][0-9]
//                    0?[1-9]|1[012]
//                    0?[1-9]|[12][0-9]|3[01]
                    /*
                    year (19|20)[0-9][0-9]
                    * 19 [0-9] [0-9] 1900 - 1999
                    * 20 [0-9][0-9] 2000 - 2099
                    *
                    month 0?[1-9]|1[012]
                    * 0?[1-9] 01-09 or 1-9
                    * 1[012] 10,11,12
                    *
                    day 0?[]
                    0?[1-9] 01-09 or 1-9
                    [12][0-9] 10-19 or 20-29
                    3[01] 30,31

                    combine - dd/MM/uuuu
                    (0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)[0-9][0-9])

                    *  */
            num++;
            vdob.setText(" ");

        } else vdob.setText("Invalid Date");
    }

    //Mobile Number validation
    public void mobValidate(String mob) {
        if (mob.isEmpty()) {
            vmob.setText("Enter Mobile number!");
        } else if (mob.matches("[0-9]+") && (mob.length() != 10)) {
            vmob.setText("Max number of integers 10");
        } else if (mob.matches("^[a-zA-Z\\s]+$")) {
            vmob.setText("Invalid Number");
        } else{
            num++;
            vmob.setText(" ");
        }



    }

    //consultation detail validate
    public void cDateValidate(String cDate) {

        //dd/MM/uuuu
        if (cDate.isEmpty()) {
            vdate.setText("Enter consultation date!");
        } else if (cDate.matches("^((?:0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((20|21)[2-9][2-9]))$")) {

//            (20|21)[0-9][0-9]
//                    0?[1-9]|1[012]
//                    0?[1-9]|[12][0-9]|3[01]
                    /*
                    year (20|21)[0-9][0-9]
                    *20 [2-9][2-9] 2022 - 2099
                    * 21 [0-9][0-9] 2100 - 2199
                    *
                    month 0?[1-9]|1[012]
                    * 0?[1-9] 01-09 or 1-9
                    * 1[012] 10,11,12
                    *
                    day 0?[]
                    0?[1-9] 01-09 or 1-9
                    [12][0-9] 10-19 or 20-29
                    3[01] 30,31

                    combine - dd/MM/uuuu
                    (0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((20|21)[0-9][0-9])

                    *  */
            num++;
            vdate.setText(" ");

        } else vdate.setText("Invalid Date");
    }

    //Consultation Start time validation
    public void stimeValidate(String time) {
        if (time.isEmpty()) {
            vstime.setText("Enter Start time!");
        } else if (time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            num++;
            vstime.setText(" ");

        } else
            vstime.setText("Invalid Time");
    }

    //Consultation End time validation and finding cost
    public void etimeValidate(String time) throws ParseException {

        if (time.isEmpty()) {
            vetime.setText("Enter End time!");
        } else if (time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {

            num++;
            vetime.setText(" ");


            String time1 = tstime.getText();
            String time2 = tetime.getText();

            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            long difference = date2.getTime() - date1.getTime();
            long diffHours = difference / (60 * 60 * 1000); //% 24;

            double fee = ((diffHours - 1) * 25) + 15;

            cost.setText("Payment: £" + fee);

        } else
            vetime.setText("Invalid Time");
    } //includes finding cost

    //checks if all the validations have been achieved and necessary fields have been filled if so returns true
    public boolean print() {

        if (tId.getText().isEmpty()) {
            return false;
        } else if (tFname.getText().isEmpty()) {
            return false;
        } else if (tSname.getText().isEmpty()) {
            return false;
        } else if (tDob.getText().isEmpty()) {
            return false;
        } else if (tmob.getText().isEmpty()) {
            return false;
        } else if (tdate.getText().isEmpty()) {
            return false;
        } else if (tstime.getText().isEmpty()) {
            return false;
        } else if (tetime.getText().isEmpty()) {
            return false;
        }

        return true;


    }

    //if above  print() returns all the data are sent to Form1 as confirmation
    public void print1() {
        if (print() == true) {

            str = "\n" +
                    "\n  Appointment Details" + "\n" +
                    "\n  Patient ID:  " + tId.getText() +
                    "\n  First Name:  " + tFname.getText() +
                    "\n  Sur Name:  " + tSname.getText() +
                    "\n  Date of Birth:  " + tDob.getText() +
                    "\n  Mobile No:  " + tmob.getText() +
                    "\n  Appointment with:  Dr." + a +
                    "\n  Appointment Date:  " + tdate.getText() +
                    "\n  Appointment start time:  " + tstime.getText() +
                    "\n  Appointment end time:  " + tetime.getText() +
                    "\n  Note:  " + tnote.getText() +
                    "\n  Consultation Payment:  " + cost.getText() +
                    "\n";
            Form1 obj = new Form1();
            obj.appointmentConfirm(str);
            obj.setVisible(true);


            storePatient();
            storeConsultation();
            EmptyingTextFields();
            //encryptImage();
        }
    }

    //Emptying text field
    public void EmptyingTextFields(){
        tId.setText("");
        tFname.setText("");
        tSname.setText("");
        tDob.setText("");
        tmob.setText("");
        tdate.setText("");
        tstime.setText("");
        tetime.setText("");
        tnote.setText("");
        picLabel.setIcon(null);
        cost.setText("");
    }

    //Add Image
    public void addImg() {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            picLabel.setIcon(ResizeImage(path));

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }
    }

    //resize image to set given in label
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    //Store patient details
    public void storePatient() {
        try {
            File object1 = new File("PatientDetails.txt");
            FileWriter writer = new FileWriter("PatientDetails.txt");
            for (Patient str : Patient.patDet) {

                writer.write( "Patient ID: " + str.getPatientId()+ "\n"+
                        "first name: " + str.getName() + "\n"+
                        "sur name: " + str.getsName() +"\n"+
                        "DOB: " + str.getDOB() +"\n"+
                        "mobNo: "+ str.getMobNo() + "\n"+
                        "notes: "+str.getNotes()+ "\n"+
                        "cost: "+str.getCost()+ "\n");
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        //System.out.println(" details saved");
    }

    //load patient details
    public static void loadPatient(){

        String[] load = new String[7];
        try {
            File object = new File("PatientDetails.txt");
            Scanner reader = new Scanner(object);
            int n = 0;
            while (reader.hasNextLine())
            {
                String info = reader.nextLine();
                String[] use = info.split(":");

                if(n == load.length){
                    Patient pats = new Patient(load[0],load[1],load[2],load[3],load[4],load[5],load[6]);
                    Patient.patDet.add(pats);
                    n =0;
                }
                else{
                    load[n] = use[1];
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

    //store consultation details
    public void storeConsultation() {
        try {
            File object1 = new File("ConsultationDetails.txt");
            FileWriter writer = new FileWriter("ConsultationDetails.txt");
            for (Consultation str : Consultation.docDet) {

                writer.write("Name: " + str.getName()+ "\n"+
                        "Date:" + str.getDate()+ "\n"+
                        "Start Time: "+str.getsTime()+ "\n"+
                        "End Time: "+str.geteTime() +"\n");
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        //System.out.println(" details saved");
    }

    //load consultation details
    public static void loadConsultation(){

        String[] load = new String[4];
        try {
            File object = new File("ConsultationDetails.txt");
            Scanner reader = new Scanner(object);
            int n = 0;
            while (reader.hasNextLine())
            {
                String info = reader.nextLine();
                String[] use = info.split(":");

                if(n == load.length){
                    Consultation consult = new Consultation(load[0],load[1],load[2],load[3]);
                    Consultation.docDet.add(consult);
                    n =0;
                }
                else{
                    load[n] = use[1];
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

    //Encrypt note
    public void encryptText() {

        String input = tnote.getText();
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int asciiValue = (int) c;

            if (asciiValue >= 97 && asciiValue <= 122) {
                asciiValue += 10;
                if (asciiValue > 122) {
                    asciiValue -= 26;
                }
            }
            output += (char) asciiValue;
        }
        tnote.setText(output);
    }


}





