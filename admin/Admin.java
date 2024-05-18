package admin;
import java.lang.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;  
import javax.swing.*; 
import java.util.*;

public class Admin{  
    private JFrame f;
    private JLabel title,admingif,email,head_line2,feature,name , pass,logo;
     private JTextField admin_name,email_field;
	 private JPasswordField pass_field;
	 private JButton back , login;

    public Admin()
	{
		f = new JFrame ("ADMIN");
		f.setSize(800,600);
		f.setVisible(true);
		f.setLayout(null);
		
		Font font1 = new Font("Montserrat", Font.BOLD, 20);

		
	 Color mycolor = new Color(0,102,204);
     f.getContentPane().setBackground(mycolor);


		//Title
		title= new JLabel("ADMIN LOGIN");
		title.setBounds(500,100,200,50);
		//title.setForeGround(Color.black);
       title.setFont(font1);


		
		name = new JLabel("Username");
        pass = new JLabel("Password");		
		email = new JLabel("Email");

		email.setBounds(450,200,100,70);
		//pass.setForeGround(Color.white);
		name.setBounds(450,150,100,70);
		//name.setForeGround(Color.white);
		pass.setBounds(450, 250, 100, 70);
		
		//button

        ImageIcon gif = new  ImageIcon("");
           
         login = new JButton("Login");
         login.setBounds(520,345,80,30);
	   login.setBackground(Color.white);
        login.setForeground(Color.black);
		
		
		
		// admin logo
		ImageIcon adminlogo = new ImageIcon("./img/logoadmin.png");
		
	    logo =  new JLabel(adminlogo);  
		logo.setBounds(50,75,350,498);
		f.add(logo);
		
		
         back = new JButton("Back");
         back.setBounds(1,2,100,30);
	back.setBackground(Color.black);
        back.setForeground(Color.white);
		//gif



        
		ImageIcon adminpic = new ImageIcon("./img/admin.gif");
		admingif = new JLabel(adminpic);
		admingif.setBounds(500,440,100,135);
		f.add(admingif);
		


		//field


	     	admin_name = new JTextField();
			email_field = new JTextField();
            pass_field = new JPasswordField();

			email_field.setBounds(550,220,150,30);
	        admin_name.setBounds(550,170,150,30);
			pass_field.setBounds(550,270,150 ,    30  );


            f.add(email_field);
            f.add(email);
			f.add(title);
		    f.add(admin_name);
		    f.add(pass);
		    f.add(pass_field);
		    f.add(name);
		    f.add(login);
		    f.add(back);
		    f.setLocationRelativeTo(null);
		 
		 back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new core.LoginStuff.Login();
            }
        });
	
	
	login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminlogin();
            }
        });
	
	}
	
	private void adminlogin()
	{    String username = admin_name.getText();
		 String email =   email_field.getText();
        String password = new String(pass_field.getPassword());
		
        Adminuser user = null;



         
	    if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            JOptionPane.showMessageDialog(f, "Email is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

	 

        try {
			
            File file = new File("./database/Admins.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(f, "No user registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file)); //?
            String line;  //?
            boolean loggedIn = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(email)&&parts[2].equals(password)) {
                    loggedIn = true;
                   
				   user = new Adminuser(parts[0], parts[1],parts[2]);
                    break;
                }
            }
            reader.close();

            if (loggedIn) {
                JOptionPane.showMessageDialog(f, "Login Successful!");
                f.dispose();
             new Admindashboard();
            } else {
                JOptionPane.showMessageDialog(f, "Invalid email or password!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
		
		
		
 
}