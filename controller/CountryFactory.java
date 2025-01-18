package controller;

import model.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryFactory {
    private List<Country> countries;
    public CountryFactory() {
        countries = new ArrayList<>();
        FileInputStream fis;
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream("src/resources/data/countries_data");
            int x = 0;
            while ((x = fis.read()) != -1)
                sb.append((char)x);
            fis.close();
        } catch (IOException e) {
            System.err.println("Country Names File Not Found.");
        }
        String[] lines = sb.toString().split("\n");
        for (String line : lines)
            countries.add(lineAdapter(line));
        toFile();
    }

    private void toFile() {
        ObjectOutputStream out;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("src/resources/data/countries");
            out = new ObjectOutputStream(fos);
            for (Country country : countries)
                out.writeObject(country);
            out.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Country lineAdapter(String line) {
        String[] elements = line.split("[ \\t]");
        String population = elements[elements.length - 3].replaceAll(",", "");
        String landArea = elements[elements.length - 2].replaceAll(",", "");
        String populationDensity = elements[elements.length - 1].replaceAll(",", "");
        if (elements.length == 5)
            return new Country(elements[1], Integer.parseInt(elements[0]), Integer.parseInt(population),
                    Double.parseDouble(landArea), Double.parseDouble(populationDensity));
        else {
            StringBuilder name = new StringBuilder();
            for (int i = 1; i < elements.length - 3; i++)
                name.append(elements[i]).append(" ");
            name.deleteCharAt(name.length() - 1);
            return new Country(name.toString(), Integer.parseInt(elements[0]), Integer.parseInt(population),
                    Double.parseDouble(landArea), Double.parseDouble(populationDensity));
        }
    }
}
