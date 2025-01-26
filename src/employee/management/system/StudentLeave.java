package employee.management.system;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {
    Choice choiceRollNo, choTime;
    JDateChooser selDate;
    JButton submit, cancel;

    StudentLeave(){

        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel RollNoSE = new JLabel("Search by Roll Number");
        RollNoSE.setBounds(60,100,100,20);
        RollNoSE.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(RollNoSE);

        choiceRollNo=new Choice();
        choiceRollNo.setBounds(60,130,200,20);
        add(choiceRollNo);

        try {
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from student");
            while(resultSet.next()){
                choiceRollNo.add(resultSet.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel ldate=new JLabel("Date");
        ldate.setBounds(60,180,200,20);
        ldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(ldate);

        selDate=new JDateChooser();
        selDate.setBounds(60,210,200,20);
        add(selDate);

        JLabel ltime=new JLabel("Time Duration");
        ltime.setBounds(60,260,200,20);
        ltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(ltime);

        choTime=new Choice();
        choTime.setBounds(60,290,200,20);
        choTime.add("Full day");
        choTime.add("Half day");
        add(choTime);

        submit=new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500,550);
        setLocation(500,100);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String rollNo=choiceRollNo.getSelectedItem().toString();
            String date=((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time=choTime.getSelectedItem();

            String Q="insert into studentleave values('"+rollNo+"','"+date+"','"+time+"')";
            try{
                Conn c=new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeave();
    }
}
