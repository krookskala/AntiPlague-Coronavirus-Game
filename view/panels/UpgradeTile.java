package view.panels;

import model.upgrades.Upgrade;
import model.World;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpgradeTile extends JPanel {
    final Upgrade upgrade;
    static final ImageIcon ICON = new ImageIcon("src/resources/images/upgrade_icon_2.png");
    JLabel pic = new JLabel();
    JLabel name = new JLabel();

    public UpgradeTile(Upgrade upgrade, String description) {
        this.upgrade = upgrade;

        setBorder(new BevelBorder(BevelBorder.RAISED, new Color(100, 100, 100), Color.BLACK));
        setBackground(new Color(33, 33, 33));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(140, 140));

        pic.setIcon(ICON);
        pic.setHorizontalAlignment(SwingConstants.CENTER);
        pic.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        name.setText(upgrade.getNAME());
        name.setFont(new Font("Roboto", Font.BOLD, 14));
        name.setForeground(new Color(200, 200, 200));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        setToolTipText(description);

        addMouseListener(new ML());
        add(pic, BorderLayout.CENTER);
        add(name, BorderLayout.SOUTH);
    }

    class ML implements MouseListener {
        boolean disabled = false;

        @Override
        public void mouseClicked(MouseEvent e) {
            if (!disabled) {
                int option = JOptionPane.showConfirmDialog(
                        null,
                        "Do You Want To Buy This Upgrade?\nCost: " + Upgrade.getCost(),
                        "Confirm Purchase",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    if (!(World.getPoints() < Upgrade.getCost())) {
                        upgrade.upgrade();
                        World.removePoints(Upgrade.getCost());
                        Upgrade.increaseCost();
                        disabled = true;
                        setBackground(new Color(60, 60, 60));
                        JOptionPane.showMessageDialog(null, "Upgrade Purchased!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Enough Points!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (!disabled) setBackground(new Color(80, 80, 80));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (!disabled) setBackground(new Color(33, 33, 33));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!disabled) setBackground(new Color(50, 50, 50));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!disabled) setBackground(new Color(33, 33, 33));
        }
    }
}