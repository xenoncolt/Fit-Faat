//adminDash_button
package admin;
import java.lang.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;  
import javax.swing.*; 
import java.util.*;

public class Admindashboard{  
      private JFrame f;
     private JLabel title,click2,arrow,task,name ,admingif, pass;
     private JTextArea admin_name;
	 private JPasswordField pass_field;
	 private JButton back , update_doctor,update_patient,update_admin,Dash_button;

   public Admindashboard()
	{
		
		
		f = new JFrame ("Dashboard");
		f.setSize(800,600);
		f.setVisible(true);
		f.setLayout(null);
   
Font font1 = new Font("Montserrat", Font.ITALIC, 25);   
Font f1 = new Font("Montserrat", Font.BOLD, 20);		 
	 Color mycolor = new Color(0,105,102);
     f.getContentPane().setBackground(mycolor);

		//Title
		title= new JLabel("Admin Dashboard");
		title.setBounds(190,80,250,50);
		title.setForeground(Color.WHITE);


		ImageIcon  admindashgif = new ImageIcon("./img/admindashgif.gif");
		admingif = new JLabel(admindashgif);
		admingif.setBounds(455,50,125,120);
        f.add(admingif);
		
		//title.setForeGround(Color.black);
		title.setFont(font1);
		
		
		name = new JLabel("Admin email");
        pass = new JLabel("Password");		
		
		pass.setBounds(450,190,100,70);
		//pass.setForeGround(Color.white);
		name.setBounds(450,150,100,70);
		//name.setForeGround(Color.white);
		
		
		//button
         update_patient = new JButton("Update Patient");
         update_patient.setBounds(197,200,200,200);
	     update_patient.setBackground(Color.white);
         update_patient.setForeground(mycolor);
		 
		 
		 update_doctor = new JButton("Upadate Doctor");
		 update_doctor.setBounds(500,200,200,125);
	     update_doctor.setBackground(Color.white);
         update_doctor.setForeground(mycolor);
		 update_doctor.setFont(f1);
	
		 
		
		//update_admin
		update_admin = new JButton ("Update Admin");
		 update_admin.setBounds(500,365,200,125);
	     update_admin.setBackground(Color.white);
         update_admin.setForeground(mycolor);
		update_admin.setFont(f1);
		
        
		ImageIcon arrowpic = new ImageIcon("./img/arrow.gif");
		arrow = new JLabel(arrowpic);
		arrow.setBounds(260,300,140,90);
		f.add(arrow);
		
         back = new JButton("Back");
         back.setBounds(1,2,100,30);
	back.setBackground(Color.black);
        back.setForeground(Color.white);
		
		ImageIcon taskpic = new ImageIcon("./img/task.gif");
 task = new JLabel(taskpic);
 task.setBounds(110,280,115,130); 
f.add(task);
        //button 


		//field
	     	admin_name = new JTextArea();
			pass_field = new JPasswordField();
			pass_field.setBounds(550,220,150,30);
	        admin_name.setBounds(550,170,150,30);
			
			
			//f.add(Dash_button);
			f.add(title);
	f.add(update_doctor);
	
	//f.add(update_patient);
		f.add(update_admin);
		f.add(back);
		f.setLocationRelativeTo(null);
	
		 back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
              new Admin();
            }
        });
		
		
				// Dash_button.addActionListener(new ActionListener() {
        //    public void actionPerformed(ActionEvent e) {
        ////        f.dispose();
          //    new Dashboard();
        //    }
       // });
		
		
				 update_doctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();

			//	setVisible(true);
                userdata frame = new userdata();
            frame.setVisible(true);
             //new userdata();
            }
        });
		
		
	
	
	
	
	update_admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Adminupdate();
				f.dispose();
            }
        });
	
	
	
	}
	public static void main(String args[])
	{


		new Admindashboard();
	}
	}
 
