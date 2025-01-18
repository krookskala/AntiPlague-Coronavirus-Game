package view.panels;

import model.Virus;
import model.World;
import view.utilities.MyTimer;

import javax.swing.*;
import java.awt.*;

public class PanelView extends JPanel {
    public MyTimer timer;
    private JProgressBar cureProgressBar;

    public PanelView(Virus virus, World world) {
        timer = new MyTimer(virus, world);

        setLayout(new BorderLayout());
        setBackground(new Color(50, 50, 50));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel headerBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        headerBar.setBackground(new Color(33, 33, 33));
        headerBar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));

        JLabel header = new JLabel("Game Progress");
        header.setFont(new Font("Roboto", Font.BOLD, 18));
        header.setForeground(new Color(200, 200, 200));
        add(header, BorderLayout.NORTH);
        add(timer, BorderLayout.CENTER);

        cureProgressBar = new JProgressBar(0, 100);
        cureProgressBar.setStringPainted(true);
        cureProgressBar.setBackground(new Color(50, 50, 50));
        cureProgressBar.setForeground(new Color(34, 193, 195));
        headerBar.add(cureProgressBar);
        add(headerBar, BorderLayout.SOUTH);
        updateCureProgress(world);
    }

    public void updateCureProgress(World world) {
        cureProgressBar.setValue((int) (world.getCureProgress() * 100));
    }
}
