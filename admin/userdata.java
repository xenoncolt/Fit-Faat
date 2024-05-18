package admin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;

public class userdata extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, title;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton back, add, delete, refresh, nBtn;
    private Cursor cursor;

    private String[] column = {"Field",  "Doctor Name", "Username", "Email", "Number"};
    private String[] rows = new String[6];

    userdata() {



        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("User Data");
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#666358"));

        // Icon
        icon = new ImageIcon("./img/background.png");
        this.setIconImage(icon.getImage());
            
        //image
        ImageIcon search = new ImageIcon("./img/datasearch.gif");
        title = new JLabel(search);
        title.setBounds(450,-4,110,110);
         c.add(title);

        // Fonts
        f1 = new Font("Montserrat", Font.PLAIN, 60);
        f2 = new Font("Serif", Font.BOLD, 15);
        f3 = new Font("Montserrat", Font.BOLD, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Data");
        label1.setBounds(300, 10, 200, 80);
        label1.setFont(f1);
        c.add(label1);

        // JButtons
        refresh = new JButton("Refresh");
        refresh.setBounds(200, 605, 100, 30);
        refresh.setFont(f2);
        refresh.setCursor(cursor);
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(Color.decode("#2E75B6"));
        c.add(refresh);

        delete = new JButton("Delete");
        delete.setBounds(600, 605, 100, 30);
        delete.setFont(f2);
        delete.setCursor(cursor);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.decode("#2E75B6"));
        c.add(delete);

        add = new JButton("Add");
        add.setBounds(400, 605, 100, 30);
        add.setFont(f2);
        add.setCursor(cursor);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.decode("#2E75B6"));
        c.add(add);
		
        back = new JButton("Back");
        back.setBounds(10, 10, 100, 50);
        back.setFont(f2);
        back.setCursor(cursor);
        back.setForeground(Color.WHITE);
       back.setBackground(Color.decode("#423f3a"));
        c.add(back);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#05c1dc"));
        table.setBackground(Color.decode("#05c1dc"));
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        

        scroll = new JScrollPane(table);
        scroll.setBounds(15, 96, 950, 500);
        scroll.setBackground(Color.decode("#5f0253"));
        c.add(scroll);

        String file = "./database/Doctors.txt";
        String temp = "./database/temp.txt";

        // To input data in the table
       
       
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
               if (x.equals("Spec")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(15); // F
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(5); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(10); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(7); // Number
                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(7); // field
                   
                    model.addRow(rows);
              }
            }

        } catch (Exception ex) {
            return;
        }

        // Refresh Button
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                userdata frame = new userdata();
                frame.setVisible(true);

            }
        });

        // Delete Button
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    int q = 0;

                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(file)).get(i);
                            String x = line.substring(0, 4);
                            if (x.equals("Spec")) {
                                String userName = Files.readAllLines(Paths.get(file)).get(i);
                                if (userName.substring(16).equals(removeUser)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        return;
                    }

                    try {

                        FileWriter fw = new FileWriter(temp, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {
                            String line = Files.readAllLines(Paths.get(file)).get(j);
                            String x = line.substring(0, 4);

                            if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5))) {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("" + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(userName);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    oldFile.delete();
                    File dump = new File(file);
                    newFile.renameTo(dump);

                    setVisible(false);
                    userdata frame = new userdata();
                    frame.setVisible(true);
                }

            }
        });

        // Add Button
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });

       

        // Cancel Button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
              new Admindashboard();
                
            }
        });
    }

    public static void main(String[] args) {

        userdata frame = new userdata();
        frame.setVisible(true);
    }
}
