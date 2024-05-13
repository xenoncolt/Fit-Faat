package users.qna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.*;
import java.nio.file.*;

import javax.swing.*;

import users.Dashboard;

public class Feeling extends QusDesign {
    
    public Feeling() {
        baseFrame("QUESTION 3");
        addLabel("How do you feel your energy during the day?", 50, 10, 300, 150);
        addOption1("High");
        addOption2("Medium");
        addOption3("Low");
        addOption4("None - I don't know");
        addButton();
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                String selected_option = null;
                if (option1.isSelected()) {
                    selected_option = "hight";
                } else if (option2.isSelected()) {
                    selected_option = "medium";
                } else if (option3.isSelected()) {
                    selected_option = "low";
                } else if (option4.isSelected()) {
                    selected_option = "none";
                } 

                if (selected_option == null) {
                    JOptionPane.showMessageDialog(frame, "Please select an option.", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (selected_option != null) {
                    try {
                        List<String> lines = Files.readAllLines(Paths.get("./database/Users.txt"));

                        int lastBorderIndex = 0;
                        for (int i = 0; i < lines.size(); i++) {
                            if (lines.get(i).contains("==")) {
                                lastBorderIndex = i;
                            }
                        }

                        try (PrintWriter out = new PrintWriter(
                                new BufferedWriter(new FileWriter("./database/Users.txt")))) {
                            for (int i = 0; i < lines.size(); i++) {
                                if (i == lastBorderIndex) {
                                    out.println("Feel: " + selected_option);
                                }
                                out.println(lines.get(i));
                            }
                            new Dashboard();
                            frame.dispose();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Something went wrong will saving into Database.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }
}
