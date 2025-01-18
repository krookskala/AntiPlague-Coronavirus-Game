package view.panels;

import model.transport.Transport;
import model.Virus;
import model.World;
import model.upgrades.Upgrade;

import javax.swing.*;
import java.awt.*;

public class UpgradePanel extends JPanel {
    UpgradeTile[] upgradeTiles;
    World world;
    Virus virus;

    public UpgradePanel(World world) {
        this.world = world;

        setBackground(new Color(33, 33, 33));
        setPreferredSize(new Dimension(1000, 300));
        setLayout(new GridLayout(2, 5, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel header = new JLabel("Available Upgrades");
        header.setFont(new Font("Roboto", Font.BOLD, 18));
        header.setForeground(new Color(200, 200, 200));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);
        upgradeLoad();

        for (UpgradeTile tile : upgradeTiles) {
            add(tile);
        }
    }

    private void upgradeLoad() {
        upgradeTiles = new UpgradeTile[10];

        upgradeTiles[0] = new UpgradeTile(
                new Upgrade("Advanced Logistics") {
                    @Override
                    public void upgrade() {
                        Transport.decreaseVirality(0.3);
                    }
                },
                "Optimize transportation networks to reduce congestion and improve safety protocols, lowering infection risks by 30%."
        );
        upgradeTiles[1] = new UpgradeTile(
                new Upgrade("Sanitation Protocols") {
                    @Override
                    public void upgrade() {
                        Transport.decreaseVirality(0.4);
                    }
                },
                "Implement mandatory disinfection measures for all public and private transport, reducing virus spread by 40%."
        );
        upgradeTiles[2] = new UpgradeTile(
                new Upgrade("Automated Cleaning Systems") {
                    @Override
                    public void upgrade() {
                        Transport.decreaseVirality(0.5);
                    }
                },
                "Deploy automated cleaning and UV sterilization systems in transport hubs, further decreasing infection risks by 50%."
        );
        upgradeTiles[3] = new UpgradeTile(
                new Upgrade("Public Awareness Campaigns") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.25);
                    }
                },
                "Launch widespread campaigns to educate the public on social distancing and hygiene, lowering virus intensity by 25%."
        );
        upgradeTiles[4] = new UpgradeTile(
                new Upgrade("Localized Lockdowns") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.3);
                    }
                },
                "Enforce localized lockdowns in high-risk areas to prevent widespread outbreaks, reducing virus intensity by 30%."
        );
        upgradeTiles[5] = new UpgradeTile(
                new Upgrade("National Hygiene Standards") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.35);
                    }
                },
                "Establish and enforce stringent hygiene standards across all sectors, decreasing virus intensity by 35%."
        );
        upgradeTiles[6] = new UpgradeTile(
                new Upgrade("Comprehensive Testing") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.4);
                    }
                },
                "Expand testing capacity and improve rapid testing availability, enabling quicker isolation of infected individuals and reducing virus intensity by 40%."
        );
        upgradeTiles[7] = new UpgradeTile(
                new Upgrade("Enhanced Border Control") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.3);
                    }
                },
                "Strengthen border surveillance and implement health screenings to curtail cross-border infections, reducing virus intensity by 30%."
        );
        upgradeTiles[8] = new UpgradeTile(
                new Upgrade("Strict Quarantine Enforcement") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.5);
                    }
                },
                "Enforce rigorous quarantine measures for infected individuals and contacts, significantly lowering virus intensity by 50%."
        );
        upgradeTiles[9] = new UpgradeTile(
                new Upgrade("Cure Development") {
                    @Override
                    public void upgrade() {
                        if (World.getPoints() >= 10) {
                            World.removePoints(10);
                            Virus.increaseCureProgress(5);
                            JOptionPane.showMessageDialog(
                                    null,
                                    String.format("Cure progress: %.1f%%", Virus.getCureProgress()),
                                    "Cure Progress",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Not enough points to research the cure!",
                                    "Insufficient Points",
                                    JOptionPane.WARNING_MESSAGE
                            );
                        }
                    }
                },
                "Invest resources to research and develop a cure. Each upgrade increases cure progress by 5%."
        );
    }
}
