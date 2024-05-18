package admin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

public class AdminAdd extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1,label2;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf3,tf4,tf5,l,clg,graduation,pass;
    private JButton btn1, btn2, nBtn;
    
    private Cursor cursor;

    AdminAdd() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ADD Doctor");
        this.setSize(800, 780);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
    
         c.setBackground(Color.decode("#00416a"));

        // Icon
        icon = new ImageIcon("./img/doctorreg.png");
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Montserrat", Font.BOLD, 30);
        f2 = new Font("Montserrat", Font.BOLD, 15);
        f3 = new Font("Montserrat", Font.BOLD, 15);
        f4 = new Font("Montserrat", Font.BOLD, 15);
        f5 = new Font("Montserrat", Font.BOLD,15);
        f6 = new Font("Montserrat", Font.BOLD, 15);

        // Title
        label1 = new JLabel();
        label1.setText("ADD DOCTOR");
		label1.setForeground(Color.WHITE);
        label1.setBounds(300, 30, 400, 30);
        label1.setFont(f1);
        c.add(label1);


        ImageIcon image = new ImageIcon("./img/doctorreg.png");
         label2 = new JLabel(image);
         label2.setBounds(0,100,345,545);
         c.add(label2);         
         
        // User Name

label1 = new JLabel();
label1.setText("Name");
label1.setForeground(Color.WHITE);
label1.setBounds(400, 195, 100, 25);
label1.setFont(f4);
c.add(label1);

tf5 = new JTextField();
tf5.setBounds(510, 195, 160, 30);
tf5.setFont(f5);
c.add(tf5);


        label1 = new JLabel();
        label1.setText("User Name");
		label1.setForeground(Color.WHITE);
        label1.setBounds(400, 245, 100, 25);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(510, 245, 160, 30);
        tf1.setFont(f5);
        c.add(tf1);


        // Email
        label1 = new JLabel();
        label1.setText("Email");
		label1.setForeground(Color.WHITE);
        label1.setBounds(400, 290, 100, 25);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JTextField();
        tf2.setBounds(510, 290, 160, 30);
        tf2.setFont(f5);
        c.add(tf2);

        // Phone
        label1 = new JLabel();
		label1.setForeground(Color.WHITE);
        label1.setText("Phone");
        label1.setBounds(400, 335, 100, 25);
        label1.setFont(f4);
        c.add(label1);

        tf3 = new JTextField();
        tf3.setBounds(510,335, 160, 30);
        tf3.setFont(f2);
        c.add(tf3);

//field
        label1 = new JLabel();
        label1.setForeground(Color.WHITE);
        label1.setText("Field");
        label1.setBounds(400, 380, 100, 25);
        label1.setFont(f4);
        c.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(510,380, 160, 30);
        tf4.setFont(f2);
        
        c.add(tf4);
//licence
label1 = new JLabel();
label1.setForeground(Color.WHITE);
label1.setText("License");
label1.setBounds(400, 425, 100, 25);
label1.setFont(f4);
c.add(label1);

l = new JTextField();
l.setBounds(510,425, 160, 30);
l.setFont(f2);

c.add(l);

//clg

label1 = new JLabel();
label1.setForeground(Color.WHITE);
label1.setText("Collage");
label1.setBounds(400, 470, 100, 25);
label1.setFont(f4);
c.add(label1);

clg = new JTextField();
clg.setBounds(510,470, 160, 30);
clg.setFont(f2);

c.add(clg);
//graduation

label1 = new JLabel();
label1.setForeground(Color.WHITE);
label1.setText("Graduation year");
label1.setBounds(400, 515, 100, 25);
label1.setFont(f4);
c.add(label1);

graduation = new JTextField();
graduation.setBounds(510,515, 160, 30);
graduation.setFont(f2);

c.add(graduation);

//passs

label1 = new JLabel();
label1.setForeground(Color.WHITE);
label1.setText("Pass");
label1.setBounds(400, 560, 100, 25);
label1.setFont(f4);
c.add(label1);

pass = new JTextField();
pass.setBounds(510,560, 160, 30);
pass.setFont(f2);

c.add(pass);




    
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(680, 600, 100, 30);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Add");
        btn2.setBounds(480, 600, 100, 30);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Back Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                userdata frame = new userdata();
                frame.setVisible(true);
            }
        });

        // Register Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String textField5 = tf4.getText().toLowerCase(); //field
                String textField1 = tf5.getText().toLowerCase(); //  Name
                String textField2 = tf1.getText(); // User Name
                String textField3 = tf2.getText(); // Email
                String textField4 = tf3.getText(); // Phone
                String textField6=  l.getText();// license
                String textField7=  clg.getText();//
                String textField8=  graduation.getText();
                String textField9=  pass.getText();

                if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty()||textField4.isEmpty()||textField5.isEmpty()||textField6.isEmpty()||textField7.isEmpty()||textField8.isEmpty()||textField9.isEmpty())
                      {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Something Went Wrong!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try {
                        File file = new File("./database/Doctors.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                  

                        pw.println("Specialization: " + textField5);
                        pw.println("Name: " + textField1);
                         pw.println("Username: " + textField2);
                         pw.println("Email: " + textField3);
                         pw.println("Phone: " + textField4);
                         pw.println("License: " + textField6);
                         pw.println("College: " + textField7);
                         pw.println("Graduation Year: " + textField8);
                         pw.println("Password: " + textField9);
                         pw.println("=====================================");
                         pw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    JOptionPane.showMessageDialog(null, "User has been added.", "User Added",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    AdminAdd frame = new AdminAdd();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        AdminAdd frame = new AdminAdd();
        frame.setVisible(true);
    }
}
