//  I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import javax.swing.*;
import java.awt.*;

public class Form1 extends JFrame{

    private JPanel c;
    private JLabel title;
    private JTextArea tPDetails;
    private JTextField tcost;


    public Form1(){

        c = new JPanel();
        c.setLayout(null);
        c.setBounds(0, 0, 90, 90);
        c.setBackground(Color.pink);
        add(c);


        title = new JLabel("Consultation Confirmation");
        title.setBounds(250,24, 400,100);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        c.add(title);


        tPDetails = new JTextArea();
        tPDetails.setBounds(150,120,600,400);
        tPDetails.setEditable(false);
        tPDetails.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        c.add(tPDetails);

        tcost = new JTextField();
        c.add(tcost);

        setTitle("Consultation Confirmation");
        add(c);
        setBounds(300,90,950,600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    public void appointmentConfirm(String str1) {
        tPDetails.setText(str1);
    }
}
