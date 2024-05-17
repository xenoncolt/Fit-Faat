package users;

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

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
                profile();
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

        healthSuggestion();

        JButton search_doc = new JButton();
        search_doc.setText("Search Doctor");
        search_doc.setBounds(25, 110, 150, 50);
        search_doc.setBackground(new Color(135, 206, 235));
        search_doc.setForeground(Color.WHITE);
        side_panel.add(search_doc);

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

    private boolean is_editable = false;

        private void toggleEditable() {
            is_editable = !is_editable;
        }

    private String getName(String filePath, String username) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                String nameLine = null;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().equals("Username: " + username)) {
                        if (nameLine != null && nameLine.startsWith("Name: ")) {
                            return nameLine.split(": ")[1].trim();
                        }
                    }
                    nameLine = line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public void profile() {
        // System.err.println("method called");
        editable_area.removeAll();
        editable_area.repaint();
        editable_area.revalidate();

        String username = core.LoginInfo.getUsername();
        String file_path = "./database/Users.txt";
        String[] user_data = getUserData(file_path, username);


        JButton edit = new JButton("Edit");
        edit.setBounds(250, 500, 100, 30);
        edit.setBackground(new Color(135, 206, 235));
        edit.setForeground(Color.WHITE);
        editable_area.add(edit);

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleEditable();
                profile();
            }
        });

        // System.out.println(is_editable);
        
        JLabel profile = new JLabel("Profile");
        profile.setBounds(300, 110, 100, 20);
        profile.setForeground(Color.WHITE);
        profile.setFont(new Font("Arial", Font.BOLD, 20));
        editable_area.add(profile);

        JLabel name = new JLabel("Name: ");
        name.setBounds(50, 150, 100, 20);
        name.setForeground(Color.WHITE);
        editable_area.add(name);

        

        JTextArea name_text = new JTextArea(getName(file_path, username));
        name_text.setBounds(190, 150, 200, 20);
        name_text.setBackground(Color.BLACK);
        name_text.setForeground(Color.WHITE);
        name_text.setFont(new Font("Arial", Font.PLAIN, 16));
        name_text.setEditable(is_editable);
        editable_area.add(name_text);
        
        

        JLabel email = new JLabel("Email: ");
        email.setBounds(50, 200, 100, 20);
        email.setForeground(Color.WHITE);
        editable_area.add(email);

        JTextArea email_text = new JTextArea(user_data[0]);
        email_text.setBounds(190, 200, 200, 20);
        email_text.setBackground(Color.BLACK);
        email_text.setForeground(Color.WHITE);
        email_text.setFont(new Font("Arial", Font.PLAIN, 16));
        email_text.setEditable(is_editable);
        editable_area.add(email_text);
        

        JLabel phn = new JLabel("Phone: ");
        phn.setBounds(50, 250, 100, 20);
        phn.setForeground(Color.WHITE);
        editable_area.add(phn);

        JTextArea phn_text = new JTextArea(user_data[1]);
        phn_text.setBounds(190, 250, 200, 20);
        phn_text.setBackground(Color.BLACK);
        phn_text.setForeground(Color.WHITE);
        phn_text.setFont(new Font("Arial", Font.PLAIN, 16));
        phn_text.setEditable(is_editable);
        editable_area.add(phn_text);

        JLabel username_label = new JLabel("Username: ");
        username_label.setBounds(50, 300, 100, 20);
        username_label.setForeground(Color.WHITE);
        editable_area.add(username_label);

        JTextArea username_text = new JTextArea(username);
        username_text.setBounds(190, 300, 200, 20);
        username_text.setBackground(Color.BLACK);
        username_text.setForeground(Color.WHITE);
        username_text.setFont(new Font("Arial", Font.PLAIN, 16));
        username_text.setEditable(is_editable);
        editable_area.add(username_text);

        JLabel password = new JLabel("Password: ");
        password.setBounds(50, 350, 100, 20);
        password.setForeground(Color.WHITE);
        editable_area.add(password);

        JTextArea password_text = new JTextArea(user_data[7]);
        password_text.setBounds(190, 350, 200, 20);
        password_text.setBackground(Color.BLACK);
        password_text.setForeground(Color.WHITE);
        password_text.setFont(new Font("Arial", Font.PLAIN, 16));
        password_text.setEditable(is_editable);
        editable_area.add(password_text);

        JLabel weight = new JLabel("Weight: ");
        weight.setBounds(50, 400, 100, 20);
        weight.setForeground(Color.WHITE);
        editable_area.add(weight);

        JTextArea weight_text = new JTextArea(user_data[4]);
        weight_text.setBounds(190, 400, 200, 20);
        weight_text.setBackground(Color.BLACK);
        weight_text.setForeground(Color.WHITE);
        weight_text.setFont(new Font("Arial", Font.PLAIN, 16));
        weight_text.setEditable(is_editable);
        editable_area.add(weight_text);

        JLabel height = new JLabel("Height: ");
        height.setBounds(50, 450, 100, 20);
        height.setForeground(Color.WHITE);
        editable_area.add(height);

        JTextArea height_text = new JTextArea(user_data[5]);
        height_text.setBounds(190, 450, 200, 20);
        height_text.setBackground(Color.BLACK);
        height_text.setForeground(Color.WHITE);
        height_text.setFont(new Font("Arial", Font.PLAIN, 16));
        height_text.setEditable(is_editable);
        editable_area.add(height_text);

        JButton save = new JButton("Save");
        save.setBounds(450, 500, 100, 30);
        save.setBackground(new Color(135, 206, 235));
        save.setVisible(is_editable);
        save.setForeground(Color.WHITE);
        editable_area.add(save);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                String new_name = name_text.getText();
                String new_email = email_text.getText();
                String new_phn = phn_text.getText();
                String new_username = username_text.getText();
                String new_password = password_text.getText();
                String new_weight = weight_text.getText();
                String new_height = height_text.getText();

                if (!new_username.matches("[A-Za-z0-9_]+")) {
                    JOptionPane.showMessageDialog(frame, "Username should only contain letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!new_email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                    JOptionPane.showMessageDialog(frame, "Email is not valid. \nMake sure you use proper mail address. \nExample: address@example.com", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!new_phn.matches("\\+880\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "Phone number is not valid. It should be start with '+880' and followed by exactly 10 digits. \nOther country's phone number is not available right now.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                updateUser(file_path, "Name: " + getName(file_path, username),"Name: " + new_name);
                updateUser(file_path, "Email: " + user_data[0],"Email: " + new_email);
                updateUser(file_path, "Phone: " + user_data[1],"Phone: " + new_phn);
                updateUser(file_path, "Username: " + username,"Username: " + new_username);
                updateUser(file_path, "Password: " + user_data[7],"Password: " + new_password);
                updateUser(file_path, "Weight: " + user_data[4],"Weight: " + new_weight); 
                updateUser(file_path, "Height: " + user_data[5],"Height: " + new_height); 
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(50, 500, 100, 30);
        back.setBackground(new Color(135, 206, 235));
        back.setForeground(Color.WHITE);
        editable_area.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                editable_area.removeAll();
                editable_area.repaint();
                editable_area.revalidate();

                healthSuggestion();
            }
        });
    }

    public void updateUser(String file_path, String old_value, String new_value) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            StringBuilder content = new StringBuilder();
            String line;
            boolean updated = false;
            
            while ((line = reader.readLine()) != null) {
                if (line.contains(old_value)) {
                    line = line.replace(old_value, new_value);
                    updated = true;
                }
                content.append(line).append(System.lineSeparator());
            }
            
            if (updated) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
                    writer.write(content.toString());
                }
                
            } else {

                JOptionPane.showMessageDialog(frame, "User not found or name not updated.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void healthSuggestion() {
        ImageIcon banner_img = new ImageIcon("./img/doc_con2.png");
        JLabel banner = new JLabel(banner_img);
        banner.setBounds(0, 217, 683, 630);
        editable_area.add(banner);

        JLabel suggestion = new JLabel("Health Suggestion");
        suggestion.setBounds(50, 50, 200, 20);
        suggestion.setForeground(Color.WHITE);
        suggestion.setFont(new Font("Arial", Font.BOLD, 20));
        editable_area.add(suggestion);

        double bmi = bmiCalculator();
        String condition = healthCondition(bmi);
        String username = core.LoginInfo.getUsername();
        String file_path = "./database/Users.txt";
        String[] user_data = getUserData(file_path, username);
        String advice = generateAdvice(bmi, user_data[11]);

        JLabel bmi_label = new JLabel("Your BMI: " + bmi);
        bmi_label.setBounds(50, 100, 200, 20);
        bmi_label.setForeground(Color.WHITE);
        editable_area.add(bmi_label);

        JLabel health_condition = new JLabel("Health Condition: " + condition);
        health_condition.setBounds(50, 150, 200, 20);
        health_condition.setForeground(Color.WHITE);
        editable_area.add(health_condition);

        JLabel health_advice = new JLabel("Health Advice: ");
        health_advice.setBounds(50, 200, 200, 20);
        health_advice.setForeground(Color.WHITE);
        editable_area.add(health_advice);
        
        JTextArea advice_area = new JTextArea(advice);
        advice_area.setBounds(50, 250, 600, 200);
        advice_area.setBackground(Color.BLACK);
        advice_area.setForeground(Color.WHITE);
        advice_area.setFont(new Font("Arial", Font.PLAIN, 16));
        advice_area.setLineWrap(true);
        advice_area.setWrapStyleWord(true);
        advice_area.setEditable(false);
        editable_area.add(advice_area);

    }

    private double bmiCalculator() {
        String username = core.LoginInfo.getUsername();
        String file_path = "./database/Users.txt";
        String[] user_data = getUserData(file_path, username);
        if (user_data != null) {
            double weight = Double.parseDouble(user_data[4]);
            double height = Double.parseDouble(user_data[5]);
            double bmi = weight/ Math.pow(height / 100, 2);
            // System.out.println("BMI: " + bmi);
            return bmi;
        }
        return 0;
    }

    private String[] getUserData(String path, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Username: " + username)) {
                    String[] Data = new String[12];
                    for (int i = 0; i < 12; i++) {
                        line = reader.readLine();
                        Data[i] = line.split(": ")[1];
                    }
                    return Data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String healthCondition(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "obese";
        }
    }

    private String generateAdvice(double bmi, String feel) {
        StringBuilder advice = new StringBuilder();
        if (bmi < 18.5) {
            advice.append("Your BMI indicates that you are underweight. It's important to ensure you're eating enough calories and nutrients to support your body. Consider consulting a healthcare provider to develop a plan that includes a balanced diet and possibly addressing any underlying health issues.\n");
        } else if (bmi < 24.9) {
            advice.append("Your BMI is in the normal range. Continue maintaining a healthy lifestyle with a balanced diet and regular physical activity. Make sure you're getting enough sleep and managing stress effectively.\n");
        } else if (bmi < 29.9) {
            advice.append("Your BMI indicates that you are overweight. Consider adopting a healthier diet with more fruits, vegetables, and lean proteins while reducing intake of processed foods and sugary drinks. Regular exercise can also help you manage your weight and improve overall health.\n");
        } else {
            advice.append("Your BMI indicates that you are obese. It's important to work with a healthcare provider to create a weight-loss plan that is safe and effective. Focus on a balanced diet, regular physical activity, and possibly seeking support from a nutritionist or a fitness professional.\n");
        }

        if (feel.equals("low")) {
            advice.append("Since you mentioned feeling low, it's also important to take care of your mental health. Consider speaking with a mental health professional and find activities that boost your mood, such as exercise, hobbies, or socializing with friends and family.");
        } else if (feel.equals("medium")) {
            advice.append("Your current feeling is medium. Maintaining a balance between physical activity, a nutritious diet, and mental well-being can help improve your overall health.");
        } else {
            advice.append("It's great that you're feeling good. Continue to prioritize your health with regular check-ups and a healthy lifestyle.");
        }

        return advice.toString();
    }

}