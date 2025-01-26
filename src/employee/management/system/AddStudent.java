package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JTextField textname,textfathername,textaddress,textphone,textemail,textM10,textM12,textaadharNo ;
    JLabel emptext;
    JDateChooser cdob;
    JComboBox courseBox,departmentBox;
    JButton submit, cancel;

    Random ran=new Random();
    long f4=Math.abs((ran.nextLong()%9000L)+ 1000L);

    AddStudent() {
        getContentPane().setBackground(new Color(128,166,255));

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //name textfeild
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textname = new JTextField();
        textname.setBounds(200,150,150,30);
        add(textname);

        //fathers name textfield
        JLabel fname = new JLabel("Fathers Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textfathername = new JTextField();
        textfathername.setBounds(600,150,150,30);
        add(textfathername);

        //rollnumber
        JLabel empID = new JLabel("Roll Number");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);

        emptext=new JLabel("22410"+f4);
        emptext.setBounds(200,200,150,30);
        emptext.setFont(new Font("serif",Font.BOLD,20));
        add(emptext);

        //Dob
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

        //address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textaddress = new JTextField();
        textaddress.setBounds(200,250,150,30);
        add(textaddress);

        //phone
        JLabel phone = new JLabel("Phone No");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600,250,150,30);
        add(textphone);

        //email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);

        //marks 10
        JLabel m10 = new JLabel("Class X (%)");
        m10.setBounds(400,300,200,30);
        m10.setFont(new Font("serif",Font.BOLD,20));
        add(m10);

        textM10 = new JTextField();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        //marks 12
        JLabel m12 = new JLabel("Class XII (%)");
        m12.setBounds(50,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        textM12 = new JTextField();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        //Aadhar card
        JLabel aadharNo = new JLabel("Aadhar Number");
        aadharNo.setBounds(400,350,200,30);
        aadharNo.setFont(new Font("serif",Font.BOLD,20));
        add(aadharNo);

        textaadharNo = new JTextField();
        textaadharNo.setBounds(600,350,150,30);
        add(textaadharNo);

        //Qualication
        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        //course
        String course[]={"B-Tech","BBA","BSC","MSC","MBA","MCA","MCom","MA","BA"};
        courseBox=new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        //Department
        JLabel Department = new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String department[]={"Computer Science","Electronic","Mechanical","Civil","IT"};
        departmentBox=new JComboBox(department);
        departmentBox.setBounds(600,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        //submit
        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        //cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String name=textname.getText();
            String fname=textfathername.getText();
            String empid=emptext.getText();
            String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String address=textaddress.getText();
            String phone=textphone.getText();
            String email=textemail.getText();
            String x=textM10.getText();
            String xii=textM12.getText();
            String aadhar=textaadharNo.getText();
            String education=(String)courseBox.getSelectedItem();
            String department=(String)departmentBox.getSelectedItem();
            try{
                String q="Insert into student values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+education+"','"+department+"')";
                Conn c=new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Data Inserted");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
