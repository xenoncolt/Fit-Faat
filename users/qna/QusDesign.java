package users.qna;

import javax.swing.*;

import java.awt.*;

public class QusDesign implements IQusDesign {
    JFrame frame;
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;

    JButton submit;

    ButtonGroup option_group = new ButtonGroup();

    Font bold_font = new Font("Arial", Font.BOLD, 30);
    Font normal_font = new Font("Arial", Font.PLAIN, 20);

    public void baseFrame(String title) {
        frame = new JFrame(title);
        frame.setSize(400, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void addLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
        label.setBounds(x, y, width, height);
        label.setFont(bold_font);
        label.setVerticalAlignment(JLabel.CENTER);
        frame.add(label);
    }

    public void addOption1(String text) {
        option1 = new JRadioButton(text);
        option1.setBounds(50, 200, 200, 50);
        option1.setFont(normal_font);
        option_group.add(option1);
        frame.add(option1);
    }

    public void addOption2(String text) {
        option2 = new JRadioButton(text);
        option2.setBounds(50, 300, 200, 50);
        option2.setFont(normal_font);
        option_group.add(option2);
        frame.add(option2);
    }

    public void addOption3(String text) {
        option3 = new JRadioButton(text);
        option3.setBounds(50, 400, 200, 50);
        option3.setFont(normal_font);
        option_group.add(option3);
        frame.add(option3);
    }

    public void addOption4(String text) {
        option4 = new JRadioButton(text);
        option4.setBounds(50, 500, 200, 50);
        option4.setFont(normal_font);
        option_group.add(option4);
        frame.add(option4);
    }

    public void addButton() {
        submit = new JButton("OK");
        submit.setBounds(150, 570, 60, 60);
        frame.add(submit);
    }
}
