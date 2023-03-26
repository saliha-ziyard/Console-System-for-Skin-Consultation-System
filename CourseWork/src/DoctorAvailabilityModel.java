// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DoctorAvailabilityModel extends AbstractTableModel {

    private String[] columnNames = {"First Name", "Start Time", "End Time"};
    private ArrayList<Doctor> list;

    public DoctorAvailabilityModel(ArrayList<Doctor> docList){
        this.list = docList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int col){return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if(columnIndex == 0){
            temp = list.get(rowIndex).getName();
        }
        return temp;
    }
}
