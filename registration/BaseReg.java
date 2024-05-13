package registration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseReg implements IRegistration {
    JFrame frame;
    JLabel label;
    JTextField full_name_field;
    JTextField username_field;
    JTextField email_field;
    JTextField phn_field;
    JPasswordField password;
    JPasswordField re_password;
    Font bold_font = new Font("Arial", Font.BOLD, 20);
    Font normal_font = new Font("Arial", Font.PLAIN, 16);

    public void baseFrame(String title) {
        frame = new JFrame(title);
        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void addLabel(String text, int x, int y, int width, int height, Font font) {
        label = new JLabel(text);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        frame.add(label);
    }

    public void addFullName(int x, int y, int width, int height) {
        full_name_field = new JTextField();
        full_name_field.setBounds(x, y, width, height);
        frame.add(full_name_field);
    }

    public void addUsername(int x, int y, int width, int height) {
        username_field = new JTextField();
        username_field.setBounds(x, y, width, height);
        frame.add(username_field);
    }

    public void addEmail(int x, int y, int width, int height) {
        email_field = new JTextField();
        email_field.setBounds(x, y, width, height);
        frame.add(email_field);
    }

    public void addPhn(int x, int y, int width, int height) {
        phn_field = new JTextField();
        phn_field.setBounds(x, y, width, height);
        frame.add(phn_field);
    }

    public void addPassword(int x, int y, int width, int height) {
        password = new JPasswordField();
        password.setBounds(x, y, width, height);
        frame.add(password);

        JCheckBox show_password = new JCheckBox();
        show_password.setBounds(860, y, 20, 28);
        show_password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                if (show_password.isSelected()) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('•');
                }
            }
        });

        frame.add(show_password);
    }

    public void addRePassword(int x, int y, int width, int height) {
        re_password = new JPasswordField();
        re_password.setBounds(x, y, width, height);
        frame.add(re_password);

        JCheckBox show_re_password = new JCheckBox();
        show_re_password.setBounds(860, y, 20, 28);
        show_re_password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                if (show_re_password.isSelected()) {
                    re_password.setEchoChar((char) 0);
                } else {
                    re_password.setEchoChar('•');
                }
            }
        });

        frame.add(show_re_password);
    }
    
}
