package registration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class Doctor extends BaseReg {
    JComboBox<String> specialization;
    JTextField license;
    JTextField college;
    JTextField year;
    JButton registerButton;
    JButton backButton;

    String specializations[] = { "Cardiologist", "Dermatologist", "Endocrinologist", "Gastroenterologist",
            "Preventive Medicine", "Sports Medicine", "Hematologist", "Nephrologist", "Neurologist", "Oncologist",
            "Nutrition and Dietetics", "Ophthalmologist", "Endocrinology", "Pediatrician", "Preventive Medicine",
            "Psychiatrist", "Pulmonologist", "Radiologist", "Rheumatologist", "Obesity and Weight Management",
            "Gastroenterology", "Urologist" };

    public Doctor() {
        baseFrame("DOCTOR REGISTRATION");

        addLabel("PLEASE ENTER YOUR INFORMATION", 500, 10, 400, 50, bold_font);

        addLabel("Full Name:", 530, 75, 100, 28, normal_font);

        addFullName(610, 75, 250, 28);

        addLabel("Username:", 530, 115, 100, 28, normal_font);

        addUsername(610, 115, 250, 28);

        addLabel("Email:", 530, 155, 100, 28, normal_font);

        addEmail(610, 155, 250, 28);

        addLabel("Phone Number:", 500, 195, 150, 28, normal_font);

        addPhn(610, 195, 250, 28);

        addLabel("Specialization: ", 500, 235, 150, 28, normal_font);

        specialization = new JComboBox<>(specializations);
        specialization.setBounds(610, 235, 250, 28);
        frame.add(specialization);

        addLabel("Medical License:", 490, 275, 150, 28, normal_font);

        license = new JTextField();
        license.setBounds(610, 275, 250, 28);
        frame.add(license);

        addLabel("Medical College:", 490, 315, 150, 28, normal_font);

        college = new JTextField();
        college.setBounds(610, 315, 250, 28);
        frame.add(college);

        addLabel("Year of Graduation:", 490, 355, 150, 28, normal_font);

        year =  new JTextField();
        year.setBounds(640, 355, 100, 28);
        frame.add(year);

        addLabel("Password:", 530, 395, 100, 28, normal_font);

        addPassword(610, 395, 250, 28);

        addLabel("Re-Enter Password:", 470, 435, 150, 28, normal_font);

        addRePassword(610, 435, 250, 28);

        registerButton = new JButton("REGISTER");
        registerButton.setBounds(740, 490, 98, 25);
        frame.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                //TO DO
                saveDoctor();
            }
        });


        backButton = new JButton("BACK");
        backButton.setBounds(520, 490, 98, 25);
        frame.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                new Users();
                frame.dispose();
            }
        });
    }

    private void saveDoctor() {
        String full_name = full_name_field.getText();
        String username = username_field.getText();
        String email = email_field.getText();
        String phone_number = phn_field.getText();
        String better_sub = specialization.getSelectedItem().toString();
        String license_number = license.getText();
        String college_name = college.getText();
        String graduation_year = year.getText();
        String pass = new String(password.getPassword());
        String re_pass = new String(re_password.getPassword());

        if (full_name.isEmpty() || username.isEmpty() || email.isEmpty() || phone_number.isEmpty() || better_sub.isEmpty()
                || license_number.isEmpty() || college_name.isEmpty() || graduation_year.isEmpty() || pass.isEmpty()
                || re_pass.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 

        if (!pass.equals(re_pass)) {
            JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!username.matches("[A-Za-z0-9_]+")) {
            JOptionPane.showMessageDialog(frame, "Username should only contain letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            JOptionPane.showMessageDialog(frame, "Email is not valid. \nMake sure you use proper mail address. \nExample: address@example.com", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!phone_number.matches("\\+880\\d{10}")) {
            JOptionPane.showMessageDialog(frame, "Phone number is not valid. It should be start with '+880' and followed by exactly 10 digits. \nOther country's phone number is not available right now.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!license_number.matches("\\d{5}")) {
            JOptionPane.showMessageDialog(frame, "License number is not valid. It should be exactly 5 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!graduation_year.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(frame, "Graduation year is not valid. It should be exactly 4 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            File file = new File("./database/Users.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            try(BufferedReader read = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = read.readLine()) != null) {
                    if (line.contains("Username: " + username) || line.contains("Email: " + email)) {
                        JOptionPane.showMessageDialog(frame, "Username or email already exists. \nPlease use different username or email.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
                out.println("Name: " + full_name);
                out.println("Username: " + username);
                out.println("Email: " + email);
                out.println("Phone: " + phone_number);
                out.println("Specialization: " + better_sub);
                out.println("License: " + license_number);
                out.println("College: " + college_name);
                out.println("Graduation Year: " + graduation_year);
                out.println("Password: " + pass);
                out.println("Type: doctor");
                out.println("=====================================");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
