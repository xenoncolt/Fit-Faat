package users;

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Dashboard {

    private JFrame frame;
    private JButton search_button, book_button, logout, profile;
    private JLabel welcome;

    public Dashboard() {

        Color mycolor = new Color(153, 204, 255);

        frame = new JFrame("Dashboard");
        frame.setSize(900, 800);
        frame.getContentPane().setBackground(mycolor);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel heading = new JPanel();
        heading.setBounds(0, 0, 900, 100);
        heading.setBackground(Color.GRAY);
        frame.add(heading);

        JPanel side = new JPanel();
        side.setBounds(5, 150, 260, 800);
        side.setBackground(Color.GRAY);
        frame.add(side);

        String user_name;

        if(registration.Users.username != null) {
            user_name = registration.Users.username;
        } else {
        user_name = core.Login.username;
        }

        JLabel welcome_text = new JLabel("Welcome " + user_name);
        welcome_text.setBounds(10, 10, 200, 50);
        heading.add(welcome_text);
        frame.add(welcome_text);

        JTextField search_bar = new JTextField();
        search_bar.setBounds(200, 10, 400, 50);
        // frame.add(search_bar);

        ImageIcon beg_image = new ImageIcon("./img/beg_7.png");
        JButton beg_label = new JButton(beg_image);
        beg_label.setBounds(270, 280, 550, 60);
        frame.add(beg_label);

        ImageIcon inte_image = new ImageIcon("./img/inte_15.png");
        JButton inte_label = new JButton(inte_image);
        inte_label.setBounds(270, 350, 550, 60);
        frame.add(inte_label);

        ImageIcon advan_image = new ImageIcon("./img/advan_30.png");
        JButton advan_label = new JButton(advan_image);
        advan_label.setBounds(270, 420, 550, 60);
        frame.add(advan_label);

        // font
        Font font1 = new Font("Montserrat", Font.PLAIN, 20);

        // title
        welcome = new JLabel("FEATURES");
        welcome.setBounds(490, 220, 200, 30);
        welcome.setFont(font1);
        frame.add(welcome);

        ImageIcon image_icon = new ImageIcon("./img/doc_con2.png");
        JLabel image_label = new JLabel(image_icon);
        image_label.setBounds(270, 480, 550, 120);
        frame.add(image_label);

        // button
        profile = new JButton("PROFILE");
        profile.setBounds(450, 40, 100, 30);
        frame.add(profile);
        profile.setBackground(mycolor);
        profile.setForeground(Color.white);

        logout = new JButton("LOGOUT");
        logout.setBounds(80, 560, 100, 30);
        frame.add(logout);
        logout.setBackground(mycolor);
        logout.setForeground(Color.white);

        book_button = new JButton("BOOK APPOINMENT");
        book_button.setBounds(20, 420, 200, 80);
        book_button.setBackground(mycolor);
        book_button.setForeground(Color.white);

        frame.add(book_button);

        search_button = new JButton("SEARCH DOCTOR");
        search_button.setBounds(20, 300, 200, 80);

        search_button.setBackground(mycolor);
        search_button.setForeground(Color.white);
        frame.add(search_button);

    }

}