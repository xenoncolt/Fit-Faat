package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.PageAttributes.ColorType;
import java.awt.event.*;
import java.io.*;

public class Adminupdate {
    private JFrame frame;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton, Back, clearButton;
    private JLabel R, E, G, I, S, T, r, A, t, i, O, N, home;

    public Adminupdate() {

        Color mycolor = new Color(5, 141, 82);
        Color mycolor2 = new Color(59, 68, 75);
        Font font1 = new Font("Montserrat", Font.BOLD, 25);

        frame = new JFrame("Admin");
        frame.setSize(650, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(mycolor);

        R = new JLabel("R");
        R.setBounds(45, 20, 30, 20);
        R.setFont(font1);
        frame.add(R);

        E = new JLabel("E");
        E.setBounds(45, 50, 30, 20);
        E.setFont(font1);
        frame.add(E);

        G = new JLabel("G");
        G.setBounds(45, 80, 30, 20);
        G.setFont(font1);
        frame.add(G);

        I = new JLabel("I");
        I.setBounds(50, 110, 30, 20);
        I.setFont(font1);
        frame.add(I);

        S = new JLabel("S");
        S.setBounds(45, 140, 30, 20);
        S.setFont(font1);
        frame.add(S);

        T = new JLabel("T");
        T.setBounds(45, 170, 30, 20);
        T.setFont(font1);
        frame.add(T);

        r = new JLabel("R");
        r.setBounds(45, 200, 30, 20);
        r.setFont(font1);
        frame.add(r);

        A = new JLabel("A");
        A.setBounds(45, 230, 30, 20);
        A.setFont(font1);
        frame.add(A);

        t = new JLabel("T");
        t.setBounds(45, 260, 30, 20);
        t.setFont(font1);
        frame.add(t);

        i = new JLabel("I");
        i.setBounds(50, 290, 30, 20);
        i.setFont(font1);
        frame.add(i);

        O = new JLabel("O");
        O.setBounds(45, 320, 30, 20);
        O.setFont(font1);
        frame.add(O);

        N = new JLabel("N");
        N.setBounds(45, 350, 30, 20);
        N.setFont(font1);
        frame.add(N);

        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(150, 50, 100, 30);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(250, 50, 200, 30);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Admin Email:");
        emailLabel.setBounds(140, 100, 100, 30);
        frame.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(250, 100, 200, 30);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 150, 100, 30);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 150, 200, 30);
        frame.add(passwordField);

        // gif
        ImageIcon homepic = new ImageIcon("./img/homegif.gif");
        home = new JLabel(homepic);
        home.setBounds(480, 100, 130, 130);
        frame.add(home);
        // button

        registerButton = new JButton("Register");
        registerButton.setBounds(200, 250, 100, 30);
        registerButton.setBackground(mycolor2);
        registerButton.setForeground(mycolor);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        frame.add(registerButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(310, 250, 100, 30);
        clearButton.setBackground(mycolor2);
        clearButton.setForeground(mycolor);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        frame.add(clearButton);

        Back = new JButton("Back");

        Back.setBounds(270, 300, 80, 30);
        Back.setForeground(mycolor);
        Back.setBackground(mycolor2);

        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Admindashboard();
            }
        });
        frame.add(Back);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void register() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Check for empty fields
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            return;
        }

        // validemail
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            JOptionPane.showMessageDialog(frame, "Email is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for existing email
        if (EmailExists(email)) {
            JOptionPane.showMessageDialog(frame, "User with this email already exists!");
            return;
        }

        Adminuser newUser = new Adminuser(name, password, email);// why?

        try {
            FileWriter writer = new FileWriter("./database/Admins.txt", true);
            writer.write(newUser.getUsername() + "," + newUser.getPass() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(frame, "Registration Successful!");
            frame.dispose();
            new core.LoginStuff.Login();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean EmailExists(String email) {
        try {
            File file = new File("./database/Admins.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(email)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");

    }
}
