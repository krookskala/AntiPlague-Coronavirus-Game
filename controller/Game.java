package controller;

import model.Virus;
import model.World;
import view.panels.CountriesPanel;
import view.MainMenu;
import view.RankingInputWindow;
import view.panels.PanelView;
import view.panels.UpgradePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game extends JFrame implements Runnable {
    Virus virus;
    World world;
    JLabel background = new JLabel(new ImageIcon("src/resources/images/world_map.png"));
    JMenuBar menuBar = new JMenuBar();
    JMenu settings = new JMenu("Settings");
    JMenuItem quit = new JMenuItem("Quit");
    PanelView panelView;
    private int duration = 240;

    public Game(Virus.Difficulty difficulty) {
        world = new World();
        virus = new Virus(difficulty);
        panelView = new PanelView(virus, world);

        setTitle("AntiPlague - Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1250, 920);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(33, 33, 33));

        background.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        menuBar.setBackground(new Color(60, 60, 60));
        menuBar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        menuBar.setForeground(new Color(200, 200, 200));
        settings.setForeground(new Color(200, 200, 200));
        settings.setFont(new Font("Roboto", Font.BOLD, 14));
        quit.setForeground(new Color(200, 200, 200));
        quit.setBackground(new Color(60, 60, 60));
        quit.setFont(new Font("Roboto", Font.PLAIN, 14));
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
        quit.addActionListener(e -> {
            SwingUtilities.invokeLater(MainMenu::new);
            dispose();
        });
        settings.add(quit);
        menuBar.add(settings);
        setJMenuBar(menuBar);

        add(panelView, BorderLayout.NORTH);
        add(new UpgradePanel(world), BorderLayout.SOUTH);
        add(new CountriesPanel(world.getCountries()), BorderLayout.WEST);
        add(background, BorderLayout.CENTER);

        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(this);
        setVisible(true);
    }

    @Override
    public void run() {
        int counter = 0;
        boolean gameEnded = false;

        while (counter++ < duration && !gameEnded) {
            int minutes = (duration - counter) / 60;
            int seconds = (duration - counter) % 60;
            panelView.timer.clock.setText(minutes + ":" + (seconds < 10 ? "0" + seconds : seconds) + "   ");
            world.addPoints();
            panelView.timer.feedProgressbar();
            panelView.updateCureProgress(world);

            if (counter % 5 == 0) {
                world.increaseCureProgress(4.0);
                SwingUtilities.invokeLater(() -> panelView.updateCureProgress(world));
            }

            if (world.getCureProgress() >= 1.0) {
                gameEnded = true;
                JOptionPane.showMessageDialog(
                        this,
                        "The Cure Is Ready! Soon, Humanity Will Triumph Over The Virus!\nYou successfully contained the pandemic.",
                        "Game Over - Victory",
                        JOptionPane.INFORMATION_MESSAGE
                );
                break;
            }

            if (counter % 4 == 0) {
                virus.infect(world);
                if (world.getTotalInfected() / world.getTotalPopulation() >= 1.0) {
                    gameEnded = true;
                    break;
                }
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        int baseScore = (int) World.getTotalPoints();
        double infectionRate = ((double) world.getTotalInfected() / world.getTotalPopulation()) * 100;
        double timeFactor = Math.max(0, 1000 - duration + (counter - 1));
        double infectionRateFactor = Math.max(0, 1000 - (infectionRate * 10));
        double difficultyBonus = switch (virus.getDifficulty()) {
            case HIGH -> 700;
            case MEDIUM -> 500;
            case LOW -> 100;
        };
        double finalScore = baseScore + infectionRateFactor + timeFactor + difficultyBonus;
        String endMessage;
        if (world.getCureProgress() >= 1.0) {
            endMessage = String.format(
                    "Victory! The Cure Is Ready!\nFinal Score: %.2f\nInfection Rate: %.2f%%\nTime Taken: %d seconds\nDifficulty: %s",
                    finalScore, infectionRate, duration - (counter - 1), virus.getDifficulty()
            );
        } else if (world.getTotalInfected() / world.getTotalPopulation() >= 1.0) {
            endMessage = String.format(
                    "Game Over! The virus has infected the entire world.\nFinal Score: %.2f\nInfection Rate: %.2f%%\nTime Taken: %d seconds\nDifficulty: %s",
                    finalScore, infectionRate, duration - (counter - 1), virus.getDifficulty()
            );
        } else {
            endMessage = String.format(
                    "Game Over! Time's up.\nFinal Score: %.2f\nInfection Rate: %.2f%%\nTime Taken: %d seconds\nDifficulty: %s",
                    finalScore, infectionRate, duration - (counter - 1), virus.getDifficulty()
            );
        }

        JOptionPane.showMessageDialog(
                this,
                endMessage,
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE
        );

        new RankingInputWindow((int) finalScore, duration, virus.getDifficulty());
        dispose();
    }

    public static void start(Virus.Difficulty difficulty) {
        SwingUtilities.invokeLater(() -> new Game(difficulty));
    }
}