package view;

import model.Ranking;
import model.Virus;

import javax.swing.*;
import java.awt.*;

public class RankingInputWindow extends JFrame {

    JTextField txt = new JTextField(30);
    JLabel label = new JLabel("Enter Your Name: ");
    JButton submit = createStyledButton("Submit");

    public RankingInputWindow(int points, int time, Virus.Difficulty difficulty) {
        setTitle("Enter Your Name");
        setVisible(true);
        setSize(450, 180);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(33, 33, 33));

        label.setFont(new Font("Roboto", Font.BOLD, 16));
        label.setForeground(new Color(200, 200, 200));

        txt.setFont(new Font("Roboto", Font.PLAIN, 14));
        txt.setBackground(new Color(60, 60, 60));
        txt.setForeground(new Color(200, 200, 200));
        txt.setCaretColor(Color.WHITE);
        txt.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));

        submit.addActionListener(e -> {
            if (!txt.getText().equals("")) {
                Ranking.addPlayer(txt.getText(), points, time, difficulty);
                dispose();
                new MainMenu();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "You Must Enter A Name.",
                        "Missing Name",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        add(label);
        add(txt);
        add(submit);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(new Color(200, 200, 200));
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(80, 80, 80));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 60, 60));
            }
        });
        return button;
    }
}