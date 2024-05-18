package doctor;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Dashboard {
    JFrame frame;
    JPanel editable_area;
    public Dashboard() {
        frame = new JFrame("PATIENT DASHBOARD");
        frame.setSize(900, 700);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel heading = new JPanel();
        heading.setBounds(0, 0, 900, 70);
        heading.setLayout(null);
        heading.setBackground(Color.GRAY);
        frame.add(heading);

        // System.out.println(core.LoginInfo.getUsername());

        JLabel title = new JLabel("Welcome, " + core.LoginInfo.getUsername());
        title.setBounds(10, 30, 400, 20);
        title.setForeground(Color.ORANGE);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        heading.add(title);
        
        JButton profile_btn = new JButton("Profile");
        profile_btn.setBackground(new Color(135, 206, 235));
        profile_btn.setForeground(Color.WHITE);
        heading.add(profile_btn);
        profile_btn.setBounds( 420, 25, 100, 30);

        profile_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                // System.err.println("Button clicked");
                // profile();
            }
        });



        // JLabel title1 = new JLabel("Welcome, awd");
        // title.setBounds(100, 30, 200, 20);
        // title.setForeground(Color.ORANGE);
        // title.setFont(new Font("Arial", Font.BOLD, 20));
        // heading.add(title1);

        JPanel side_panel = new JPanel();
        side_panel.setBounds(0, 70, 200, 630);
        side_panel.setBackground(new Color(0, 102, 102));
        side_panel.setLayout(null);
        frame.add(side_panel);

        editable_area = new JPanel();
        editable_area.setBounds(200, 70, 700, 630);
        editable_area.setBackground(Color.BLACK);
        editable_area.setLayout(null);
        frame.add(editable_area);

        JButton search_doc = new JButton();
        search_doc.setText("Search Doctor");
        search_doc.setBounds(25, 110, 150, 50);
        search_doc.setBackground(new Color(135, 206, 235));
        search_doc.setForeground(Color.WHITE);
        side_panel.add(search_doc);

        search_doc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                
            }
        
        });

        // JButton book_appointment = new JButton();
        // book_appointment.setText("Book Appointment");
        // book_appointment.setBounds(25, 180, 150, 50);
        // book_appointment.setBackground(new Color(135, 206, 235));
        // book_appointment.setForeground(Color.WHITE);
        // side_panel.add(book_appointment);

        JButton view_appointment = new JButton();
        view_appointment.setText("View Appointment");
        view_appointment.setBounds(25, 270, 150, 50);
        view_appointment.setBackground(new Color(135, 206, 235));
        view_appointment.setForeground(Color.WHITE);
        side_panel.add(view_appointment);

        view_appointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                
            }
        });

        // JButton view_prescription = new JButton();
        // view_prescription.setText("View Prescription");
        // view_prescription.setBounds(25, 320, 150, 50);
        // view_prescription.setBackground(new Color(135, 206, 235));
        // view_prescription.setForeground(Color.WHITE);
        // side_panel.add(view_prescription);

        // JButton view_report = new JButton();
        // view_report.setText("View Report");
        // view_report.setBounds(25, 390, 150, 50);
        // view_report.setBackground(new Color(135, 206, 235));
        // view_report.setForeground(Color.WHITE);
        // side_panel.add(view_report);

        JButton logout = new JButton();
        logout.setText("Logout");
        logout.setBounds(25, 460, 150, 50);
        logout.setBackground(new Color(135, 206, 235));
        logout.setForeground(Color.WHITE);
        side_panel.add(logout);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                frame.dispose();
                new core.LoginStuff.Login();
            }
        });
    }
}