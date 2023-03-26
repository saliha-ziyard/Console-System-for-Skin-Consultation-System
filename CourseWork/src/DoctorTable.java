// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class DoctorTable extends JFrame  {

    JTable myTable;
    DocTableModel tableModel;
    ArrayList<Doctor> list;

    public DoctorTable(ArrayList<Doctor> list) {


        super("Skin Consultation");
        this.list = list;

        tableModel = new DocTableModel(list);

        myTable = new JTable(tableModel);
        myTable.setGridColor(Color.black);
        myTable.setBackground(Color.GRAY);
        myTable.setForeground(Color.white);



        myTable.setAutoCreateRowSorter(true);

        myTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            Color originalColor = null;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                return renderer;
            }
        });


        //container for a table
        JScrollPane scrollPane = new JScrollPane(myTable);


        setTitle("Consultation Center Doctor Details");
        add(scrollPane);
        setSize(700, 200);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}