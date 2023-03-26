// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorAvailability extends JFrame implements ActionListener {

    private JPanel c;
    private JLabel title;
    private JLabel date;
    private JLabel stime;
    private JLabel vstime;
    private JLabel vdate;
    private JLabel doc;
    private JLabel dName;
    private JLabel dDate;
    private JLabel dTime;

    private JTextField tdate;
    private JTextField tstime;

    private JComboBox tdoc;
    private JButton btnCheck;


    public DoctorAvailability() {

        c = new JPanel();
        c.setLayout(null);
        c.setBounds(0, 0, 90, 90);
        c.setBackground(Color.pink);
        add(c);

        title = new JLabel("Check Booked Consultation Time slots");
        title.setBounds(250, 24, 400, 100);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.BLACK);
        c.add(title);

        date = new JLabel("Consultation Date");
        tdate = new JTextField();
        vdate = new JLabel();
        stime = new JLabel("Start Time");
        tstime = new JTextField();
        vstime = new JLabel();

        dName = new JLabel("12");
        dDate = new JLabel("12");
        dTime = new JLabel("12");

        date.setBounds(90, 200, 120, 25);
        tdate.setBounds(220, 200, 165, 25);
        vdate.setBounds(420, 200, 165, 25);
        stime.setBounds(90, 230, 120, 25);
        tstime.setBounds(220, 230, 165, 25);
        vstime.setBounds(420, 230, 165, 25);

        vstime.setForeground(Color.RED);
        vdate.setForeground(Color.RED);

        c.add(date);
        c.add(tdate);
        c.add(vdate);
        c.add(stime);
        c.add(tstime);
        c.add(vstime);

        c.add(dName);
        c.add(dDate);
        c.add(dTime);

        doc = new JLabel("Select Doctor");
        doc.setBounds(90, 140, 120, 25);
        c.add(doc);

        tdoc = new JComboBox(WestminsterSkinConsultationManager.doctor.toArray());
        tdoc.setBounds(220, 140, 120, 25);
        DefaultComboBoxModel tdoct = new DefaultComboBoxModel(WestminsterSkinConsultationManager.doctor.toArray());
        for (int i = 0; i < WestminsterSkinConsultationManager.doctor.size(); i++) {
            tdoct.addElement(WestminsterSkinConsultationManager.doctor.get(i).getName());
            tdoct.removeElement(WestminsterSkinConsultationManager.doctor.get(i));
        }
        tdoc.setModel(tdoct);
        c.add(tdoc);

        btnCheck = new JButton("Check");
        btnCheck.setBounds(420, 195, 120, 35);
        ;
        btnCheck.addActionListener(this);
        c.add(btnCheck);


        setTitle("Check Doctor Availability");
        add(c);
        setBounds(300, 90, 950, 600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCheck) {
        }
    }
}
