package view;

import controller.Game;
import model.Virus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyDialog extends JDialog {
    JButton low = createStyledButton("EASY");
    JButton medium = createStyledButton("NORMAL");
    JButton high = createStyledButton("HARD");
    JLabel label = new JLabel("SELECT DIFFICULTY");

    public DifficultyDialog() {
        setTitle("Difficulty Selection");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);

        JPanel backgroundPanel = new JPanel() {
            private Image backgroundImage;

            {
                try {
                    backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("resources/images/menu.jpg")).getImage();
                } catch (Exception e) {
                    System.err.println("Error: Background Image Not Found.");
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    g.setColor(new Color(33, 33, 33));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        backgroundPanel.setLayout(null);

        label.setFont(new Font("Roboto", Font.BOLD, 28));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(150, 50, 300, 40);
        backgroundPanel.add(label);

        low.setBounds(220, 120, 160, 40);
        medium.setBounds(220, 180, 160, 40);
        high.setBounds(220, 240, 160, 40);

        low.addActionListener(new AL(Virus.Difficulty.LOW));
        medium.addActionListener(new AL(Virus.Difficulty.MEDIUM));
        high.addActionListener(new AL(Virus.Difficulty.HIGH));

        backgroundPanel.add(low);
        backgroundPanel.add(medium);
        backgroundPanel.add(high);

        setContentPane(backgroundPanel);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(new Color(200, 200, 200));
        button.setFont(new Font("Roboto", Font.BOLD, 16));
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

    class AL implements ActionListener {
        private final Virus.Difficulty difficulty;

        public AL(Virus.Difficulty difficulty) {
            this.difficulty = difficulty;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Game.start(difficulty);
            dispose();
        }
    }
}
