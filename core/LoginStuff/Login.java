package core.LoginStuff;

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.nio.file.*;

public class Login implements ActionListener {

  private String username;

  private JFrame frame;
  private JButton login, Registration, admin;
  private JCheckBox showpass;
  private JLabel L1, email_label, pass_label, pic, wel;
  private JTextField email_field;
  private JPasswordField pass_field;
  private JPanel panel;

  public Login() {

    Color mycolor = new Color(47, 79, 79);

    frame = new JFrame("Login");
    panel = new JPanel();
    email_field = new JTextField();

    login = new JButton("LOGIN");
    login.setBounds(465, 315, 100, 30);
    login.setBackground(Color.white);
    login.setForeground(mycolor);

    ImageIcon wel1 = new ImageIcon("./img/login_wel.gif");
    wel = new JLabel(wel1);
    wel.setBounds(0, 1, 340, 180);

    Registration = new JButton("SIGNUP");
    Registration.setBounds(595, 315, 100, 30);
    Registration.setBackground(Color.white);
    Registration.setForeground(mycolor);

    frame.add(Registration);

    ImageIcon showpass_image = new ImageIcon("./img/showpass.png");
    showpass = new JCheckBox(showpass_image);
    showpass.setBounds(670, 233, 36, 22);

    email_label = new JLabel("USERNAME/EMAIL:");
    pass_label = new JLabel("  PASSWORD:");
    pass_field = new JPasswordField();
    pass_label.setBounds(400, 200, 104, 94);
    pass_field.setBounds(510, 230, 155, 29);
    email_label.setBounds(400, 155, 200, 40);
    email_field.setBounds(510, 155, 155, 32);
    email_label.setForeground(Color.white);
    pass_label.setForeground(Color.white);

    frame.getContentPane().setBackground(Color.black);

    admin = new JButton("ADMIN");
    admin.setBounds(540, 385, 100, 30);
    admin.setBackground(Color.white);
    admin.setForeground(mycolor);
    frame.add(admin);

    ImageIcon front = new ImageIcon("./img/boyjogging.gif");
    pic = new JLabel(front);
    pic.setBounds(1, 195, 340, 360);
    panel.setBounds(345, 0, 400, 600);

    panel.setBackground(mycolor);

    ImageIcon welcome = new ImageIcon("./img/tt.gif");
    L1 = new JLabel(welcome);
    L1.setBounds(263, 50, 588, 74);

    login.addActionListener(this);
    Registration.addActionListener(this);
    showpass.addActionListener(this);
    admin.addActionListener(this);

    frame.add(login);
    frame.add(showpass);
    frame.add(wel);
    frame.add(pass_field);
    frame.add(pass_label);
    frame.add(pic);
    frame.add(L1);
    panel.add(email_label);
    frame.add(email_field);
    frame.add(email_label);
    frame.add(panel);
    frame.setSize(740, 585);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);

  }

  private void login() {
    // System.out.println("it worked");
    String email_username = email_field.getText();
    String password = new String(pass_field.getPassword());

    if (password.isEmpty()) {
      JOptionPane.showMessageDialog(frame, "Please enter password.", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (email_username.isEmpty()) {
      JOptionPane.showMessageDialog(frame, "Please enter your username or email.", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    try {
      // Check in Users.txt
      if (checkCredentials("./database/Users.txt", email_username, password)) {
        // finding username
        if (!email_username.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
          username = email_field.getText();
          core.LoginInfo.setUsername(email_field.getText());
        } else {
          try {
            username = getUsernameFromEmail("./database/Users.txt", email_username);
            if (username == null) {
              username = getUsernameFromEmail("./database/Doctors.txt", email_username);
              core.LoginInfo.setUsername(username);

            }
            if (username == null) {
              username = getUsernameFromEmail("./database/Admins.txt", email_username);
              core.LoginInfo.setUsername(username);

            }

          } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Something went wrong while reading from Database.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
        JOptionPane.showMessageDialog(frame, "Login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
        new users.Dashboard();
        frame.dispose();
        return;
      }

      // Check in Doctors.txt
      if (checkCredentials("./database/Doctors.txt", email_username, password)) {
        // finding username
        if (!email_username.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
          username = email_field.getText();
          core.LoginInfo.setUsername(email_field.getText());
        } else {
          try {
            username = getUsernameFromEmail("./database/Users.txt", email_username);
            if (username == null) {
              username = getUsernameFromEmail("./database/Doctors.txt", email_username);
              core.LoginInfo.setUsername(username);

            }
            if (username == null) {
              username = getUsernameFromEmail("./database/Admins.txt", email_username);
              core.LoginInfo.setUsername(username);

            }

          } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Something went wrong while reading from Database.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
        JOptionPane.showMessageDialog(frame, "Login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
        // new doctor.Dashboard();
        System.out.println("new doctor.Dashboard();"); // need to change later
        frame.dispose();
        return;
      }

      // Check in Admins.txt
      if (checkCredentials("./database/Admins.txt", email_username, password)) {
        // finding username
        if (!email_username.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
          username = email_field.getText();
          core.LoginInfo.setUsername(email_field.getText());
        } else {
          try {
            username = getUsernameFromEmail("./database/Users.txt", email_username);
            if (username == null) {
              username = getUsernameFromEmail("./database/Doctors.txt", email_username);
              core.LoginInfo.setUsername(username);

            }
            if (username == null) {
              username = getUsernameFromEmail("./database/Admins.txt", email_username);
              core.LoginInfo.setUsername(username);

            }

          } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Something went wrong while reading from Database.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
        JOptionPane.showMessageDialog(frame, "Login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
        // new admin.Dashboard();
        System.out.println("new admin.Dashboard();"); // need to change later
        frame.dispose();
        return;
      }

      JOptionPane.showMessageDialog(frame, "Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);

    } catch (IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(frame, "Something went wrong while reading from Database.", "Error",
          JOptionPane.ERROR_MESSAGE);
    }

    // finding username
    // it will not work here because not reached here when successful.

    // if
    // (!email_username.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
    // {
    // username = email_field.getText();
    // core.LoginInfo.setUsername(email_field.getText());
    // } else {
    // try {
    // username = getUsernameFromEmail("./database/Users.txt", email_username);
    // if (username == null) {
    // username = getUsernameFromEmail("./database/Doctors.txt", email_username);
    // core.LoginInfo.setUsername(username);

    // }
    // if (username == null) {
    // username = getUsernameFromEmail("./database/Admins.txt", email_username);
    // core.LoginInfo.setUsername(username);

    // }

    // } catch (IOException e) {
    // e.printStackTrace();
    // JOptionPane.showMessageDialog(frame, "Something went wrong while reading from
    // Database.", "Error", JOptionPane.ERROR_MESSAGE);
    // }
    // }

    // setting username

  }

  // This method use for checking username or email and password match kore ki na.
  private boolean checkCredentials(String file_path, String email_username, String password) throws IOException { // throws
                                                                                                                  // IOException
                                                                                                                  // for
                                                                                                                  // jodi
                                                                                                                  // kono
                                                                                                                  // error
                                                                                                                  // paoya
                                                                                                                  // jai
                                                                                                                  // show
                                                                                                                  // korbe
    // System.out.println("it worked");
    try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
      String line;
      boolean found_user = false;
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.startsWith("Username: ")) {
          String value = line.substring("Username: ".length());
          if (value.equals(email_username)) {
            found_user = true;
          }
        } else if (line.startsWith("Email: ")) {
          String value = line.substring("Email: ".length());
          if (value.equals(email_username)) {
            found_user = true;
          }
        } else if (found_user && line.startsWith("Password: ")) {
          String value = line.substring("Password: ".length());
          if (value.equals(password)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // email diya username ber korar jnow
  private String getUsernameFromEmail(String filePath, String email) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(filePath));
    for (int i = 0; i < lines.size(); i++) {
      if (lines.get(i).contains("Email: " + email)) {
        // Username email er ager line a ase
        return lines.get(i - 1).substring("Username: ".length());
      }
    }
    return null;
  }

  public void actionPerformed(ActionEvent e) {

    if (showpass.isSelected()) {
      pass_field.setEchoChar((char) 0);
    } else {
      pass_field.setEchoChar('•');
    }

    if ((e.getSource()).equals(Registration)) {
      frame.setVisible(false);
      new core.LoginStuff.connect(); // move to registration folder
    }

    if ((e.getSource()).equals(login)) {
      login();
    }

    if ((e.getSource()).equals(admin)) {
      frame.setVisible(false);
      new core.LoginStuff.Admin(); // move to admin folder
    }

  }

}
