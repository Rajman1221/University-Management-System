package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice choiceEmpID;
    JTable table;
    JButton search,cancel,print;

    StudentLeaveDetails(){
        getContentPane().setBackground(new Color(250, 172, 206));


        JLabel heading = new JLabel("Search by RollNo");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180,20,150,20);
        add(choiceEmpID);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from student");
            while(resultSet.next()){
                choiceEmpID.addItem(resultSet.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //table for showing leave details
        table = new JTable();
        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);
        //search btton
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        //print btn
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        //cancel btn
        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //to search empleave in table
        if(e.getSource()==search) {
            String q = "select * from studentleave where rollno='" + choiceEmpID.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==print){  //print
            try{
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==cancel){ //cancel
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
