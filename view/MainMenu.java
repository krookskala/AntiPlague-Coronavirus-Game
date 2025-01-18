package view;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("AntiPlague - Game");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel backgroundPanel = new JPanel() {
            private Image backgroundImage;
            {
                try {
                    backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("resources/images/menu.jpg")).getImage();
                } catch (Exception e) {
                    System.err.println("Error: Background Image Not Found!");
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        backgroundPanel.setLayout(null);
        JLabel header = new JLabel("Main Menu");
        header.setFont(new Font("Roboto", Font.BOLD, 28));
        header.setForeground(Color.WHITE);
        header.setBounds(220, 30, 200, 50);
        backgroundPanel.add(header);
        JButton newGame = createStyledButton("New Game");
        newGame.setBounds(220, 100, 160, 40);
        newGame.addActionListener(e -> {
            new DifficultyDialog();
            dispose();
        });

        JButton highScores = createStyledButton("Hall Of Fame");
        highScores.setBounds(220, 160, 160, 40);
        highScores.addActionListener(e -> new RankingWindow());
        JButton exit = createStyledButton("Exit");
        exit.setBounds(220, 220, 160, 40);
        exit.addActionListener(e -> System.exit(0));

        backgroundPanel.add(newGame);
        backgroundPanel.add(highScores);
        backgroundPanel.add(exit);

        setContentPane(backgroundPanel);
        setVisible(true);
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
}

class RankingWindow extends JDialog {
    RankingList list;

    public RankingWindow() {
        setTitle("High Scores");
        setSize(new Dimension(600, 400));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel backgroundPanel = new JPanel() {
            private Image backgroundImage;
            {
                try {
                    backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("resources/images/menu.jpg")).getImage();
                } catch (Exception e) {
                    System.err.println("Error: Background Image Not Found!");
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
        backgroundPanel.setLayout(new BorderLayout());
        JLabel header = new JLabel("Hall Of Fame");
        header.setFont(new Font("Roboto", Font.BOLD, 36));
        header.setForeground(Color.WHITE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        header.setOpaque(false);

        list = new RankingList();
        JScrollPane scrollPane = new JScrollPane(list) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(50, 50, 50, 200));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        scrollPane.getViewport().setBackground(new Color(50, 50, 50, 200));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        backgroundPanel.add(header, BorderLayout.NORTH);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(backgroundPanel);
        setVisible(true);
    }
}