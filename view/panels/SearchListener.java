package view.panels;

import model.Country;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;

class SearchListener implements DocumentListener {
    private JTextField searchField;
    private JList<Country> countriesList;
    private List<Country> originalCountries;

    public SearchListener(JTextField searchField, JList<Country> countriesList, List<Country> originalCountries) {
        this.searchField = searchField;
        this.countriesList = countriesList;
        this.originalCountries = originalCountries;
    }

    private void updateFilter() {
        String query = searchField.getText().toLowerCase();
        DefaultListModel<Country> filteredModel = new DefaultListModel<>();

        if (query.isEmpty()) {
            for (Country country : originalCountries) {
                filteredModel.addElement(country);
            }
        } else {
            for (Country country : originalCountries) {
                if (country.getNAME().toLowerCase().contains(query)) {
                    filteredModel.addElement(country);
                }
            }
        }
        countriesList.setModel(filteredModel);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateFilter();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateFilter();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateFilter();
    }
}