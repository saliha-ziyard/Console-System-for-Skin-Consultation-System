// I hereby declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//  Any code taken from other sources is referenced within my code solution.
//  Student ID: w1867445
//  Date: 9/1/2023

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DocTableModel extends AbstractTableModel {
    private String[] columnNames = {"First Name", "Sur Name", "Date of Birth","Mobile Number", "Medical Licence No", "Specialisation"};
    private ArrayList<Doctor> list;

    public DocTableModel(ArrayList<Doctor> docList) {
        this.list = docList;
    }

    @Override
    public int getRowCount() { return list.size(); }

    @Override
    public int getColumnCount() {return columnNames.length;}
    public String getColumnName(int col){return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object temp = null;
        if(colIndex == 0){
            temp = list.get(rowIndex).getName();
        }
        else if (colIndex == 1){
            temp = list.get(rowIndex).getsName();
        }
        else if (colIndex == 2){
            temp = list.get(rowIndex).getDOB();
        }
        else if (colIndex == 3){
            temp = list.get(rowIndex).getMobNo();
        }
        else if (colIndex == 4){
            temp = list.get(rowIndex).getMedLicenceNo();
        }
        else if (colIndex == 5){
            temp = list.get(rowIndex).getSpecialisation();
        }
        return temp;
    }

}