package view.panels;

import model.Country;
import view.CountriesList;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CountriesPanel extends JPanel {
    private final CountriesList countriesList;
    private final CountryInfoPopup countryInfoPopup;

    public CountriesPanel(List<Country> countries) {
        countriesList = new CountriesList(countries);
        countryInfoPopup = new CountryInfoPopup(null, countries.get(0));
        countriesList.addListSelectionListener(e -> {
            Country selectedCountry = ((CountriesList) e.getSource()).getSelectedValue();
            if (selectedCountry != null) {
                countryInfoPopup.setCountry(selectedCountry);
                countryInfoPopup.setVisible(true);
            }
        });

        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30));

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Roboto", Font.PLAIN, 14));
        searchField.setForeground(new Color(200, 200, 200));
        searchField.setBackground(new Color(60, 60, 60));
        searchField.setCaretColor(Color.WHITE);
        searchField.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        searchField.setToolTipText("Search For A Country...");
        searchField.getDocument().addDocumentListener(new SearchListener(searchField, countriesList, countries));

        JScrollPane scrollPane = new JScrollPane(countriesList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));

        add(searchField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}