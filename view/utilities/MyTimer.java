package view.utilities;

import model.Virus;
import model.World;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class MyTimer extends JPanel {

    public JLabel clock = new JLabel();
    private final Virus virus;
    private World world;
    private final JProgressBar progressBar = new JProgressBar();
    public JLabel points = new JLabel("Points: 0");

    public MyTimer(Virus virus, World world) {
        this.virus = virus;
        this.world = world;

        setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(100, 100, 100), Color.BLACK));
        setPreferredSize(new Dimension(350, 60));
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        setBackground(new Color(33, 33, 33));

        clock.setFont(new Font("Roboto", Font.BOLD, 16));
        clock.setForeground(new Color(200, 200, 200));
        clock.setPreferredSize(new Dimension(90, 30));
        clock.setHorizontalAlignment(SwingConstants.CENTER);

        progressBar.setToolTipText("Infection progress");
        progressBar.setForeground(new Color(178, 34, 34));
        progressBar.setBackground(new Color(60, 60, 60));
        progressBar.setMaximum((int) (world.getTotalPopulation() / 10));
        progressBar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        progressBar.setPreferredSize(new Dimension(180, 25));

        points.setFont(new Font("Roboto", Font.BOLD, 14));
        points.setForeground(new Color(200, 200, 200));

        add(clock);
        add(progressBar);
        add(points);
    }

    public void feedProgressbar() {
        progressBar.setValue((int) (world.getTotalInfected() / 10));
        int percentage = (int) (((double) progressBar.getValue() / ((double) world.getTotalPopulation() / 10)) * 100);
        progressBar.setToolTipText("Infection progress: " + percentage + "%");
        points.setText("Points: " + (int) world.getPoints());
    }
}
