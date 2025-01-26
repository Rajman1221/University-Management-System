package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login;
    JButton back;

    Login(){

        JLabel labelName=new JLabel("Username");
        labelName.setBounds(40,20,100,20);
        add(labelName);

        textFieldName=new JTextField();
        textFieldName.setBounds(150,20,150,20);
        add(textFieldName);

        JLabel labelPass=new JLabel("Password");
        labelPass.setBounds(40,70,100,20);
        add(labelPass);

        passwordField=new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        add(passwordField);

        login =new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(200,140,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i22=i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image=new JLabel(i33);
        image.setBounds(350,20,600,300);
        add(image);

        setSize(600,300);
        setVisible(true);
        setLocation(500,250);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //getting data from mysql server

        if (e.getSource()==login){
            String username=textFieldName.getText();
            String password=passwordField.getText();

            String query="select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Conn c=new Conn();
                ResultSet resultSet=c.statement.executeQuery(query);

                //to check whether data is in result set or not
                if(resultSet.next()){
                    setVisible(false);
                    //next class
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
