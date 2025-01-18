package controller;

import view.MainMenu;

import javax.swing.*;

public class Start {
    public static void main(String[] args) {
        new CountryFactory();
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
