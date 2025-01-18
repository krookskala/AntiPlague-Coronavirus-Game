package view.panels;
import model.Country;

import javax.swing.*;
import java.awt.*;

public class CountryInfoPopup extends JDialog {
    private final CountryInfo countryInfo;

    public CountryInfoPopup(JFrame parent, Country country) {
        super(parent, "Country Information - " + country.getNAME(), true);

        countryInfo = new CountryInfo(country);

        setLayout(new BorderLayout());
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(parent);

        add(countryInfo, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }

    public void setCountry(Country country) {
        countryInfo.setCountry(country);
        setTitle("Country Information - " + country.getNAME());
    }
}