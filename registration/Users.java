package registration;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.event.ChangeEvent;

import java.io.*;

import java.time.*;



public class Users extends BaseReg {

    public static String username;


    JButton back_button;
    JButton register_button;
    JSpinner weight_field;
    JSpinner height_field;
    JComboBox<String> birth_month;
    JComboBox<String> birth_day;
    JSpinner birth_year;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup gender_group;

    String month[] = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };
    String day_30[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };

    boolean is_success = false;

    public Users() {
        // Font bold_font = new Font("Arial", Font.BOLD, 20);
        // Font normal_font = new Font("Arial", Font.PLAIN, 16);

        // Frame
        baseFrame("USER REGISTRATION");
        // user_frame = new JFrame("USER REGISTRATION");
        // user_frame.setSize(900, 600);
        // user_frame.setLayout(null);
        // user_frame.setVisible(true);
        // user_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // user_frame.setResizable(false);

        // Title
        addLabel("PLEASE ENTER YOUR INFORMATION", 500, 10, 400, 50, bold_font);
        // JLabel title = new JLabel("PLEASE ENTER YOUR INFORMATION");
        // title.setBounds(500, 10, 400, 50);
        // title.setFont(bold_font);
        // user_frame.add(title);

        // Full name
        addLabel("Full Name:", 530, 75, 100, 28, normal_font);
        // JLabel full_name_label = new JLabel("Full Name:");
        // full_name_label.setBounds(530, 75, 100, 28);
        // full_name_label.setFont(normal_font);
        // user_frame.add(full_name_label);

        addFullName(610, 75, 250, 28);
        // full_name_field = new JTextField();
        // full_name_field.setBounds(610, 75, 250, 28);
        // user_frame.add(full_name_field);

        // username
        addLabel("Username:", 530, 115, 100, 28, normal_font);
        // JLabel username_label = new JLabel("Username:");
        // username_label.setBounds(530, 115, 100, 28);
        // username_label.setFont(normal_font);
        // user_frame.add(username_label);

        addUsername(610, 115, 250, 28);
        // username_field = new JTextField();
        // username_field.setBounds(610, 115, 250, 28);
        // user_frame.add(username_field);

        // Email
        addLabel("Email:", 530, 155, 100, 28, normal_font);
        // JLabel email_label = new JLabel("Email:");
        // email_label.setBounds(530, 155, 100, 28);
        // email_label.setFont(normal_font);
        // user_frame.add(email_label);

        addEmail(610, 155, 250, 28);
        // email_field = new JTextField();
        // email_field.setBounds(610, 155, 250, 28);
        // user_frame.add(email_field);
        
        // Phone
        addLabel("Phone Number:", 500, 195, 150, 28, normal_font);
        // JLabel phn_label = new JLabel("Phone:");
        // phn_label.setBounds(530, 195, 100, 28);
        // phn_label.setFont(normal_font);
        // user_frame.add(phn_label);

        addPhn(610, 195, 250, 28);
        // phn_field = new JTextField();
        // phn_field.setBounds(610, 195, 250, 28);
        // user_frame.add(phn_field);

        // Birth date
        JLabel birth_label = new JLabel("Date of Birth:");
        birth_label.setBounds(530, 235, 200, 28);
        birth_label.setFont(normal_font);
        frame.add(birth_label);

        birth_month = new JComboBox<>(month);
        birth_month.setBounds(630, 235, 80, 28);
        birth_month.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                updateDays();
            }
        });
        frame.add(birth_month);

        birth_day = new JComboBox<>(day_30);
        birth_day.setBounds(710, 235, 60, 28);
        frame.add(birth_day);

        SpinnerModel year_model = new SpinnerNumberModel(2000, 1900, 2024, 1);
        birth_year = new JSpinner(year_model);
        birth_year.setBounds(770, 235, 60, 28);
        birth_year.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateDays();
            }
        });
        frame.add(birth_year);

        updateDays();

        // Weight
        JLabel weight_label = new JLabel("Weight:");
        weight_label.setBounds(530, 275, 100, 28);
        weight_label.setFont(normal_font);
        frame.add(weight_label);

        SpinnerModel weight_model = new SpinnerNumberModel(50, 0, 200, 1);
        weight_field = new JSpinner(weight_model);
        weight_field.setBounds(590, 275, 60, 28);
        frame.add(weight_field);

        JLabel kg_text = new JLabel("kg");
        kg_text.setBounds(655, 278, 100, 28);
        kg_text.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(kg_text);

        // Height
        JLabel height_label = new JLabel("Height:");
        height_label.setBounds(710, 275, 100, 28);
        height_label.setFont(normal_font);
        frame.add(height_label);

        SpinnerModel height_model = new SpinnerNumberModel(150, 0, 250, 1);
        height_field = new JSpinner(height_model);
        height_field.setBounds(770, 275, 60, 28);
        frame.add(height_field);

        JLabel cm_text = new JLabel("cm");
        cm_text.setBounds(835, 278, 100, 28);
        cm_text.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(cm_text);

        // Sex
        JLabel sex_label = new JLabel("Sex:");
        sex_label.setFont(normal_font);
        sex_label.setBounds(610, 315, 200, 40);
        frame.add(sex_label);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(650,315,80,40);
        female.setBounds(730,315,80,40);
        gender_group = new ButtonGroup();
        gender_group.add(male);
        gender_group.add(female);
        frame.add(male);
        frame.add(female);

        // Password
        addLabel("Password:", 530, 355, 100, 28, normal_font);
        // JLabel password_label = new JLabel("Password:");
        // password_label.setBounds(530, 355, 100, 28);
        // password_label.setFont(normal_font);
        // frame.add(password_label);

        addPassword(610, 355, 250, 28);
        // password = new JPasswordField();
        // password.setBounds(610, 355, 250, 28);
        // frame.add(password);

        // JCheckBox show_password = new JCheckBox();
        // show_password.setBounds(860, 355, 20, 28);
        // show_password.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent value) {
        //         if (show_password.isSelected()) {
        //             password.setEchoChar((char) 0);
        //         } else {
        //             password.setEchoChar('*');
        //         }
        //     }
        // });

        // frame.add(show_password);

        

        // Re-enter Password
        addLabel("Re-enter Password:", 470, 395, 200, 28, normal_font);
        // JLabel re_password_label = new JLabel("Re-enter Password:");
        // re_password_label.setBounds(470, 395, 200, 28);
        // re_password_label.setFont(normal_font);
        // frame.add(re_password_label);

        addRePassword(610, 395, 250, 28);
        // re_password = new JPasswordField();
        // re_password.setBounds(610, 395, 250, 28);
        // frame.add(re_password);

        // JCheckBox show_re_password = new JCheckBox();
        // show_re_password.setBounds(860, 395, 20, 28);
        // show_re_password.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent value) {
        //         if (show_re_password.isSelected()) {
        //             re_password.setEchoChar((char) 0);
        //         } else {
        //             re_password.setEchoChar('*');
        //         }
        //     }
        // });

        // frame.add(show_re_password);
        


        // Back button
        back_button = new JButton("BACK");
        back_button.setBounds(520, 450, 98, 25);
        frame.add(back_button);
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                frame.dispose();
                new core.connect(); // move to core folder
            }
        
        });

        // Register Button
        register_button = new JButton("REGISTER");
        register_button.setBounds(740, 450, 98, 25);
        frame.add(register_button);

        register_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent value) {
                saveUser();
                if (is_success) {
                    JOptionPane.showMessageDialog(frame, "Registration Successful! \nNow Let us know about you by answering \nsome questions.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new users.qna.Sleep();
                }

            }
        });
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void updateDays() {
        int selected_month = birth_month.getSelectedIndex();
        int selected_year = Integer.parseInt(birth_year.getValue().toString());

        birth_day.removeAllItems();

        if (selected_month == 1) {
            if (isLeapYear(selected_year)) {
                for (int i = 1; i <= 29; i++) {
                    birth_day.addItem(Integer.toString(i));
                }
            } else {
                for (int i = 1; i <= 28; i++) {
                    birth_day.addItem(Integer.toString(i));
                }
            }
        } else if (selected_month == 3 || selected_month == 5 || selected_month == 8 || selected_month == 10) {
            for (int i = 1; i <= 30; i++) {
                birth_day.addItem(Integer.toString(i));
            }
        } else {
            for (int i = 1; i <= 31; i++) {
                birth_day.addItem(Integer.toString(i));
            }
        }
    }

    private int ageCalculate() {
        int day = Integer.parseInt(birth_day.getSelectedItem().toString());
        int month = birth_month.getSelectedIndex() + 1;
        int year = Integer.parseInt(birth_year.getValue().toString());
        LocalDate birth_time = LocalDate.of(year, month, day);

        //current date
        LocalDate current_date = LocalDate.now(); 

        int age = Period.between(birth_time, current_date).getYears();
        return age;   
    }



    private void saveUser() {
        String full_name = full_name_field.getText();
        username = username_field.getText();
        String email = email_field.getText();
        String phone_number = phn_field.getText();
        String weight = weight_field.getValue().toString();
        String height = height_field.getValue().toString();
        String month = birth_month.getSelectedItem().toString();
        String day = birth_day.getSelectedItem().toString();
        String year = birth_year.getValue().toString();
        String gender = male.isSelected() ? "Male" : "Female";
        String pass = new String(password.getPassword());
        String re_pass = new String(re_password.getPassword());

        if (full_name.isEmpty() || username.isEmpty() || email.isEmpty() || phone_number.isEmpty() || weight.isEmpty() || height.isEmpty() || month.isEmpty() || day.isEmpty() ||
        year.isEmpty() || pass.isEmpty() || re_pass.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all the fields", "Error", JOptionPane.WARNING_MESSAGE);
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

        

        try {
            File file = new File("./database/Users.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            File file2 = new File("./database/Doctors.txt");
            if (!file2.exists()) {
                file2.getParentFile().mkdirs();
                file2.createNewFile();
            }

            File file3 = new File("./database/Admins.txt");
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
                file3.createNewFile();
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

            try(BufferedReader read = new BufferedReader(new FileReader(file2))) {
                String line;
                while ((line = read.readLine()) != null) {
                    if (line.contains("Username: " + username) || line.contains("Email: " + email)) {
                        JOptionPane.showMessageDialog(frame, "Username or email already exists. \nPlease use different username or email.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            try(BufferedReader read = new BufferedReader(new FileReader(file3))) {
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
                out.println("Birth: " + day + "." + month + "." + year);
                out.println("Age: " + ageCalculate());
                out.println("Weight: " + weight);
                out.println("Height: " + height);
                out.println("Sex: " + gender);
                out.println("Password: " + pass);
                out.println("Type: patient");
                out.println("=====================================");
            }

            is_success = true;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
