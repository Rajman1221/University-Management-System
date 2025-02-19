package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){
        //background image main menu page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        //Menubar  main menu page
        JMenuBar mb = new JMenuBar();

        //new information
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        //faculty info
        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        //student info
        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);


        //details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);


        //leave
        JMenu leave = new JMenu("Apply leave");
        leave.setForeground(Color.black);
        mb.add(leave);

        JMenuItem facultyleave =new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave =new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);


        //leave details
        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.black);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails =new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.white);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails =new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.white);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);


        //Exams
        JMenu exams = new JMenu("Examination");
        exams.setForeground(Color.black);
        mb.add(exams);

        JMenuItem Examinationdetails =new JMenuItem("Examination Result");
        Examinationdetails.setBackground(Color.white);
        Examinationdetails.addActionListener(this);
        exams.add(Examinationdetails);

        JMenuItem Entermarks =new JMenuItem("Enter marks");
        Entermarks.setBackground(Color.white);
        Entermarks.addActionListener(this);
        exams.add(Entermarks);


        //update info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.black);
        mb.add(updateInfo);

        JMenuItem updatefacultyInfo =new JMenuItem("Update Faculty Details");
        updatefacultyInfo.setBackground(Color.white);
        updatefacultyInfo.addActionListener(this);
        updateInfo.add(updatefacultyInfo);

        JMenuItem updatestudentInfo =new JMenuItem("Update Student Details");
        updatestudentInfo.setBackground(Color.white);
        updatestudentInfo.addActionListener(this);
        updateInfo.add(updatestudentInfo);


        //fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.black);
        mb.add(fee);

        JMenuItem feestructure =new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeForm=new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.white);
        feeForm.addActionListener(this);
        fee.add(feeForm);


        //utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        mb.add(utility);

        JMenuItem ca =new JMenuItem("Calculator");
        ca.setBackground(Color.white);
        ca.addActionListener(this);
        utility.add(ca);

        JMenuItem Notepad=new JMenuItem("Notepad");
        Notepad.setBackground(Color.white);
        Notepad.addActionListener(this);
        utility.add(Notepad);


        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.black);
        mb.add(about);

        JMenuItem About =new JMenuItem("About");
        About.setBackground(Color.white);
        About.addActionListener(this);
        about.add(About);


        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);

        JMenuItem Exit =new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);



        setJMenuBar(mb);

        setSize(1540,850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")){
            System.exit(15);
        } else if (sm.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        }else if (sm.equals("New Student Information")){
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        }else if (sm.equals("Student Fee Form")){
            new StudentFeeForm();
        } else if (sm.equals("About")) {
            new About();
        }


    }

    public static void main(String[] args) {
        new main_class();
    }
}
