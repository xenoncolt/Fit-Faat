package core;

import java.awt.event.*;
import javax.swing.*;

import registration.Users;

import java.awt.*;

public class connect implements ActionListener {
  private JFrame f;
  private JTextArea about1, about2, about3, about4, about5, about6, about7, click, click2, head_line, head_line2,
      feature;

  private JButton Doctor_button, patient_button, back_button;

  public connect()

  {
    f = new JFrame("registration");

    Color mycolor = new Color(47, 79, 79);
    f.getContentPane().setBackground(mycolor);
    // JTextField tf=new JTextField();

    Font font1 = new Font("SansSerif", Font.BOLD, 23);
    Font font2 = new Font("Verdana", Font.BOLD, 15);
    Font font3 = new Font("SansSerif", Font.BOLD, 14);
    f.setBackground(mycolor);

    about1 = new JTextArea("    Welcome to the Nutritionist and Consulting App");
    about2 = new JTextArea(" Our app is designed to connect you with qualified nutritionists and ");
    about3 = new JTextArea(" dietitians who can provide expert advice tailored to your unique ");
    about4 = new JTextArea(" needs.Whether you're looking to lose weight, manage a healthy life");
    about5 = new JTextArea(", improve athletic performance, or simply adopt a healthier lifestyle,");
    about6 = new JTextArea("  our team of professionals is here to support you every step of the  ");

    about7 = new JTextArea("                   way for your better health care . ");

    click = new JTextArea("     Click Below to   ");
    click.setBounds(1, 262, 200, 50);
    f.add(click);
    click2 = new JTextArea("      Click Below to    ");
    click2.setBounds(410, 262, 200, 50);
    f.add(click2);

    head_line = new JTextArea("   Register as a Doctor  ");
    head_line.setBounds(1, 306, 200, 50);
    f.add(head_line);
    head_line2 = new JTextArea("   Register as a Patient  ");
    head_line2.setBounds(410, 306, 200, 50);
    f.add(head_line2);
    ImageIcon Doctor_buttonpic = new ImageIcon("./img/doctor.png");
    ImageIcon Patient_buttonpic = new ImageIcon("./img/patient.png");

    feature = new JTextArea("   FEATURES");
    feature.setBounds(201, 262, 208, 60);
    f.add(feature);
    feature.setFont(font1);

    ImageIcon featurepic = new ImageIcon("./img/feature.png");
    JLabel feature = new JLabel(featurepic);
    feature.setBounds(205, 320, 200, 245);
    f.add(feature);

    back_button = new JButton("Back");
    back_button.setBounds(550, 1, 70, 30);
    back_button.setBackground(Color.red);
    back_button.setForeground(Color.white);
    f.add(back_button);

    Doctor_button = new JButton(Doctor_buttonpic);
    patient_button = new JButton(Patient_buttonpic);
    Doctor_button.setBounds(1, 360, 200, 213);
    patient_button.setBounds(410, 360, 205, 210);

    about1.setFont(font1);
    about2.setFont(font2);
    about3.setFont(font2);
    about4.setFont(font2);
    about5.setFont(font2);
    about6.setFont(font2);
    click.setFont(font3);
    click2.setFont(font3);
    head_line2.setFont(font3);
    head_line.setFont(font3);
    about7.setFont(font2);

    about1.setForeground(mycolor);
    about1.setBounds(1, 1, 610, 80);
    about2.setBounds(1, 80, 610, 30);
    about3.setBounds(1, 110, 610, 30);
    about4.setBounds(1, 140, 610, 30);
    about5.setBounds(1, 170, 610, 30);
    about6.setBounds(1, 200, 610, 30);
    about7.setBounds(1, 230, 610, 30);

    f.add(Doctor_button);
    f.add(patient_button);
    back_button.addActionListener(this);
    Doctor_button.addActionListener(this);
    patient_button.addActionListener(this);
    f.add(back_button);
    f.add(about1);
    f.add(about2);
    f.add(about2);
    f.add(about3);
    f.add(about4);
    f.add(about5);
    f.add(about6);
    f.add(about7);
    f.setSize(625, 600);
    f.setLayout(null);
    f.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {

    if ((e.getSource()).equals(Doctor_button)) {
      f.setVisible(false);
      new registration.Doctor();
    }

    if ((e.getSource()).equals(patient_button)) {
      f.setVisible(false);
      new registration.Users();
    }

    if ((e.getSource()).equals(back_button)) {
      f.setVisible(false);
      new Login();
    }

  }

}