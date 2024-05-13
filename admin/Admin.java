package admin;

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Admin {
    private JFrame f;
    private JLabel title, click2, head_line, head_line2, feature, name, pass;
    private JTextArea admin_name;
    private JPasswordField pass_field;
    private JButton back, login;

    public Admin() {
        f = new JFrame("ADMIN");
        f.setSize(800, 600);
        f.setVisible(true);
        f.setLayout(null);

        Color mycolor = new Color(0, 102, 102);
        f.getContentPane().setBackground(mycolor);

        // Title
        title = new JLabel("ADMIN LOGIN");
        title.setBounds(500, 100, 200, 50);
        // title.setForeGround(Color.black);

        name = new JLabel("Admin email");
        pass = new JLabel("Password");

        pass.setBounds(450, 190, 100, 70);
        // pass.setForeGround(Color.white);
        name.setBounds(450, 150, 100, 70);
        // name.setForeGround(Color.white);

        // button
        login = new JButton("LOGIN");
        login.setBounds(520, 295, 96, 25);
        login.setBackground(Color.white);
        login.setForeground(Color.black);

        back = new JButton("Back");
        back.setBounds(1, 2, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        // field
        admin_name = new JTextArea();
        pass_field = new JPasswordField();
        pass_field.setBounds(550, 220, 150, 30);
        admin_name.setBounds(550, 170, 150, 30);

        f.add(title);
        f.add(admin_name);
        f.add(pass);
        f.add(pass_field);
        f.add(name);
        f.add(login);
        f.add(back);
        f.setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new core.Login(); // move to core folder
            }
        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminlogin();
            }
        });

    }

    private void adminlogin() {
        String email = admin_name.getText();
        String password = new String(pass_field.getPassword());

        // Adminuser user = null;

        // try {

        //     // File file = new File("Admins.txt");
        //     // if (!file.exists()) {
        //     //     JOptionPane.showMessageDialog(f, "No user registered yet!");
        //     //     return;
        //     // }

        //     // BufferedReader reader = new BufferedReader(new FileReader(file)); // ?
        //     // String line; // ?
        //     // boolean loggedIn = false;
        //     // while ((line = reader.readLine()) != null) {
        //     //     String[] parts = line.split(",");
        //     //     if (parts[0].equals(email) && parts[1].equals(password)) {
        //     //         loggedIn = true;

        //     //         user = new Adminuser(parts[0], parts[1]);
        //     //         break;
        //     //     }
        //     // }
        //     // reader.close();

        //     // if (loggedIn) {
        //     //     JOptionPane.showMessageDialog(f, "Login Successful!");
        //     //     f.dispose();
        //     //     new Admindashboard();
        //     // } else {
        //     //     JOptionPane.showMessageDialog(f, "Invalid email or password!");
        //     // }
        // } catch (IOException ex) {
        //     ex.printStackTrace(); // ??
        // }
    }

}