package view;

import model.Country;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.List;

public class CountriesList extends JList<Country> {

    public CountriesList(List<Country> countries) {
        super();
        setCellRenderer(new Cell());
        setModel(new Model(countries));

        setBackground(new Color(33, 33, 33));
        setForeground(new Color(200, 200, 200));
        setFont(new Font("Roboto", Font.PLAIN, 14));
        setSelectionBackground(new Color(80, 80, 80));
        setSelectionForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
    }
}

class Cell extends JLabel implements ListCellRenderer<Country> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Country> list, Country value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getNAME());
        setOpaque(true);
        setFont(new Font("Roboto", Font.PLAIN, 14));
        setForeground(isSelected ? Color.WHITE : new Color(200, 200, 200));
        setBackground(isSelected ? new Color(80, 80, 80) : new Color(33, 33, 33));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return this;
    }
}

class Model implements ListModel<Country> {
    List<Country> countries;

    public Model(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public int getSize() {
        return countries.size();
    }

    @Override
    public Country getElementAt(int index) {
        return countries.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}