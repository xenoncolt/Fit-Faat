package doctor;

import java.io.*;
import java.awt.event.*;


import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;


public class Dashboard {
    JFrame frame;
    JPanel editable_area;
    public Dashboard() {
        frame = new JFrame("DOCTOR DASHBOARD");
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


        // JButton search_doc = new JButton();
        // search_doc.setText("Search Doctor");
        // search_doc.setBounds(25, 110, 150, 50);
        // search_doc.setBackground(new Color(135, 206, 235));
        // search_doc.setForeground(Color.WHITE);
        // side_panel.add(search_doc);

        // search_doc.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent happen) {
        //         searchDoctor();
        //     }
        
        // });

        // JButton book_appointment = new JButton();
        // book_appointment.setText("Book Appointment");
        // book_appointment.setBounds(25, 180, 150, 50);
        // book_appointment.setBackground(new Color(135, 206, 235));
        // book_appointment.setForeground(Color.WHITE);
        // side_panel.add(book_appointment);

        JButton view_appointment = new JButton();
        view_appointment.setText("Appointments");
        view_appointment.setBounds(25, 270, 150, 50);
        view_appointment.setBackground(new Color(135, 206, 235));
        view_appointment.setForeground(Color.WHITE);
        side_panel.add(view_appointment);

        view_appointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                viewAppointment();
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

    public void viewAppointment() {
        editable_area.removeAll();
        editable_area.repaint();
        editable_area.revalidate();

        JLabel appointment = new JLabel("Appointment");
        appointment.setBounds(50, 50, 200, 20);
        appointment.setForeground(Color.WHITE);
        appointment.setFont(new Font("Arial", Font.BOLD, 20));
        editable_area.add(appointment);

        String username = core.LoginInfo.getUsername();
        String file_path = "./database/Appointments.txt";
        String[] appointment_data = getAppointmentData(file_path, username);

        if (appointment_data != null) {
            JLabel doctor_name = new JLabel(appointment_data[0]);
            doctor_name.setBounds(50, 100, 200, 20);
            doctor_name.setForeground(Color.WHITE);
            editable_area.add(doctor_name);

            JLabel doctor_email = new JLabel(appointment_data[1]);
            doctor_email.setBounds(50, 150, 400, 20);
            doctor_email.setForeground(Color.WHITE);
            editable_area.add(doctor_email);

            JLabel doctor_phn = new JLabel(appointment_data[2]);
            doctor_phn.setBounds(50, 200, 200, 20);
            doctor_phn.setForeground(Color.WHITE);
            editable_area.add(doctor_phn);

            JLabel date = new JLabel(appointment_data[8]);
            date.setBounds(50, 300, 200, 20);
            date.setForeground(Color.WHITE);
            editable_area.add(date);

            JLabel time = new JLabel(appointment_data[9]);
            time.setBounds(50, 350, 200, 20);
            time.setForeground(Color.WHITE);
            editable_area.add(time);

            JLabel is_approved = new JLabel(appointment_data[10]);
            is_approved.setBounds(50, 400, 200, 20);
            is_approved.setForeground(Color.WHITE);
            editable_area.add(is_approved);

            JButton approve_appointment = new JButton("Approve Appointment");
            approve_appointment.setBounds(50, 450, 200, 30);
            approve_appointment.setBackground(new Color(135, 206, 235));
            approve_appointment.setForeground(Color.WHITE);
            editable_area.add(approve_appointment);

            approve_appointment.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent happen) {
                    approveAppointment(file_path, username);
                }
            });

        } else {
            JLabel no_result = new JLabel("No appointment found.");
            no_result.setBounds(50, 100, 200, 20);
            no_result.setForeground(Color.WHITE);
            editable_area.add(no_result);
        }
    }

    public void approveAppointment(String file_path, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            StringBuilder content = new StringBuilder();
            String line;
            boolean updated = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Doctor Username: " + username)) {
                    updated = true;
                    content.append(line).append(System.lineSeparator());
                    while ((line = reader.readLine()) != null && !line.contains("====================================")) {
                        if (line.contains("IsApproved: false")) {
                            line = line.replace("false", "true");
                        }
                        content.append(line).append(System.lineSeparator());
                    }
                }
                content.append(line).append(System.lineSeparator());
            }
            if (updated) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
                    writer.write(content.toString());
                }
                viewAppointment();
            } else {
                JOptionPane.showMessageDialog(frame, "Appointment not found or already approved.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] getAppointmentData(String path, String doctorUsername) {
        List<String> appointmentData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            List<String> lines = new ArrayList<>();
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
                if (lines.size() > 4) {
                    lines.remove(0); //last 4 lines in memory
                }

                if (line.contains("Doctor Username: " + doctorUsername)) {
                    found = true;
                    // previous 4 lines
                    appointmentData.addAll(lines.subList(0, 4));
                    // current line
                    appointmentData.add(line);

                    // Add lines until appointment block end
                    while ((line = reader.readLine()) != null && !line.contains("====================================")) {
                        appointmentData.add(line);
                    }
                    // separator line
                    if (line != null) {
                        appointmentData.add(line);
                    }
                    break; // Found 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointmentData.isEmpty() ? null : appointmentData.toArray(new String[0]);
    }

    public void profile() {
        // System.err.println("method called");
        editable_area.removeAll();
        editable_area.repaint();
        editable_area.revalidate();

        String username = core.LoginInfo.getUsername();
        String file_path = "./database/Doctors.txt";
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

        JTextArea password_text = new JTextArea(user_data[5]);
        password_text.setBounds(190, 350, 200, 20);
        password_text.setBackground(Color.BLACK);
        password_text.setForeground(Color.WHITE);
        password_text.setFont(new Font("Arial", Font.PLAIN, 16));
        password_text.setEditable(is_editable);
        editable_area.add(password_text);

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
                updateUser(file_path, "Password: " + user_data[5],"Password: " + new_password); 
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


    

    private String[] getUserData(String path, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Username: " + username)) {
                    String[] Data = new String[8];
                    for (int i = 0; i < 8; i++) {
                        line = reader.readLine();
                        if (line != null && line.contains(": ")) {
                            Data[i] = line.split(": ")[1];
                        }
                    }
                    return Data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}