package view;

import model.Player;
import model.Ranking;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class RankingList extends JList<Player> {

    public RankingList() {
        setModel(new RankingModel());
        setCellRenderer(new RankingCell());

        setBackground(new Color(33, 33, 33));
        setForeground(new Color(200, 200, 200));
        setFont(new Font("Roboto", Font.PLAIN, 14));
        setSelectionBackground(new Color(80, 80, 80));
        setSelectionForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
    }
}

class RankingCell extends JPanel implements ListCellRenderer<Player> {

    private final JLabel rankLabel;
    private final JLabel nameLabel;
    private final JLabel difficultyLabel;
    private final JLabel timeLabel;
    private final JLabel pointsLabel;

    public RankingCell() {
        rankLabel = new JLabel();
        nameLabel = new JLabel();
        difficultyLabel = new JLabel();
        timeLabel = new JLabel();
        pointsLabel = new JLabel();

        setLayout(new GridLayout(1, 5, 10, 0));
        setOpaque(true);

        add(rankLabel);
        add(nameLabel);
        add(difficultyLabel);
        add(timeLabel);
        add(pointsLabel);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Player> list, Player value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        int minutes = value.getTIME() / 60;
        int seconds = value.getTIME() % 60;
        String formattedTime = String.format("%02d:%02d", minutes, seconds);

        rankLabel.setText(String.format("%d.", index + 1));
        nameLabel.setText(value.getNAME());
        difficultyLabel.setText("Difficulty: " + value.getDIFFICULTY());
        timeLabel.setText("Time: " + formattedTime);
        pointsLabel.setText("Points: " + value.getPOINTS());

        Font font = new Font("Roboto", Font.PLAIN, 14);
        rankLabel.setFont(font);
        nameLabel.setFont(font);
        difficultyLabel.setFont(font);
        timeLabel.setFont(font);
        pointsLabel.setFont(font);

        rankLabel.setForeground(isSelected ? Color.WHITE : new Color(200, 200, 200));
        nameLabel.setForeground(isSelected ? Color.WHITE : new Color(200, 200, 200));
        difficultyLabel.setForeground(isSelected ? Color.WHITE : new Color(200, 200, 200));
        timeLabel.setForeground(isSelected ? Color.WHITE : new Color(200, 200, 200));
        pointsLabel.setForeground(isSelected ? Color.WHITE : new Color(200, 200, 200));

        setBackground(isSelected ? new Color(80, 80, 80) : new Color(33, 33, 33));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding

        return this;
    }
}

class RankingModel implements ListModel<Player> {
    List<Player> players;

    public RankingModel() {
        players = Ranking.readRanking();
        Collections.sort(players);
        Collections.reverse(players);
    }

    @Override
    public int getSize() {
        return players.size();
    }

    @Override
    public Player getElementAt(int index) {
        return players.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
}