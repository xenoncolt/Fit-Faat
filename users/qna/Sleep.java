package users.qna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.*;
import java.nio.file.*;

import javax.swing.*;

public class Sleep extends QusDesign {

    public Sleep() {
        baseFrame("QUESTION 1");
        addLabel("How long do you usually sleep at night?", 50, 10, 300, 150);
        addOption1("Less than 6 hours");
        addOption2("6-8 hours");
        addOption3("8-10 hours");
        addOption4("More than 10 hours");
        addButton();
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent happen) {
                String selected_option = null;
                if (option1.isSelected()) {
                    selected_option = "6-";
                } else if (option2.isSelected()) {
                    selected_option = "6-8";
                } else if (option3.isSelected()) {
                    selected_option = "8-10";
                } else if (option4.isSelected()) {
                    selected_option = "10+";
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
                                    out.println("Sleep: " + selected_option);
                                }
                                out.println(lines.get(i));
                            }
                            new WakeUp();
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
