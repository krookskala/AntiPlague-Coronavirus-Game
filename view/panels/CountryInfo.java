package view.panels;

import model.Country;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

class CountryInfo extends JPanel {
    MyText name, infected, population, percentageInfected, landArea, populationDensity, activeTransport;

    public CountryInfo(Country country) {
        setBackground(new Color(33, 33, 33));
        setPreferredSize(new Dimension(350, 300));
        setLayout(new GridLayout(7, 1, 10, 10));
        setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(100, 100, 100), Color.BLACK));

        name = new MyText(country.getNAME(), true);
        infected = new MyText("Infected: " + country.getPeopleInfected());
        population = new MyText("Population: " + country.getPOPULATION());
        percentageInfected = new MyText("% infected: 0%");
        landArea = new MyText("Land Area: " + country.getLANDAREA());
        populationDensity = new MyText("Population density: " + country.getPOPULATION_DENSITY());
        activeTransport = new MyText("Active transport: " + country.getActiveTransport());

        add(name);
        add(infected);
        add(population);
        add(percentageInfected);
        add(landArea);
        add(populationDensity);
        add(activeTransport);
    }

    public void setCountry(Country country) {
        int inf = (int) (((double) country.getPeopleInfected() / (double) country.getPOPULATION()) * 100);
        name.setText(country.getNAME());
        infected.setText("Infected: " + (int) country.getPeopleInfected());
        population.setText("Population: " + country.getPOPULATION());
        percentageInfected.setText("% infected: " + inf + "%");
        landArea.setText("Land Area: " + country.getLANDAREA());
        populationDensity.setText("Population density: " + country.getPOPULATION_DENSITY());
        activeTransport.setText("Active transport: " + country.getActiveTransport());
    }

    static class MyText extends JTextArea {
        public MyText(String text) {
            this(text, false);
        }

        public MyText(String text, boolean isHeader) {
            super(text);
            setEditable(false);
            setLineWrap(true);
            setWrapStyleWord(true);

            setFont(new Font("Roboto", isHeader ? Font.BOLD : Font.PLAIN, isHeader ? 16 : 14));
            setForeground(new Color(200, 200, 200));
            setBackground(new Color(60, 60, 60));
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            if (isHeader) {
                setAlignmentX(CENTER_ALIGNMENT);
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(100, 100, 100), 1),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
            }
        }
    }
}