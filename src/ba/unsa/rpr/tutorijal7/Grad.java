package ba.unsa.rpr.tutorijal7;

/* Klasa ​Grad​​ sadrži atribute: naziv (string), broj stanovnika (int) i temperature
(običan niz od 1000 elemenata tipa double). */

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Grad implements Serializable {

    private SimpleStringProperty naziv;
    private SimpleIntegerProperty brojStanovnika;
    private ArrayList<Double> temperature = new ArrayList<Double>();

    public Grad(String a, Integer n, ArrayList<Double> g) {
        naziv = new SimpleStringProperty(a);
        brojStanovnika = new SimpleIntegerProperty(n);
        temperature = g;
    }

    public Grad() {
        naziv = new SimpleStringProperty("");
        brojStanovnika = new SimpleIntegerProperty(0);
        temperature = new ArrayList<Double>();
    }

    public static ArrayList<Grad> ucitajGradove() {
        ArrayList<Grad> gradovi = new ArrayList<Grad>();
        Scanner ulaz;
        String novinaziv = "";
        int vel = 0;

        // Konstruisanje ulaznog toka za datoteku brojevi.txt
        try {
            ulaz = new Scanner(new FileReader(Grad.class.getResource("mjerenja.txt").getFile()));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti.");
            System.out.println("Greška: " + e);
            return null; // kraj programa
        }
        try {
            // Učitavamo brojeve
            while (ulaz.hasNextLine()) {
                ArrayList<Double> temp = new ArrayList<Double>();
                String red = ulaz.nextLine();
                String[] elementi = red.split(",");
                String naziv = elementi[0];
                int duzina = elementi.length <= 1000 ? elementi.length : 1000;
                for (int i = 1; i < duzina; i++) {
                    temp.add(Double.parseDouble(elementi[i]));
                }

                Grad g = new Grad();
                g.setNaziv(naziv);
                g.setTemperature(temp);
                gradovi.add(g);
            }

        } catch (
                Exception e) {
            System.out.println("Problem pri čitanju/pisanju podataka.");
            System.out.println("Greška: " + e);

        } finally {
            // Bez obzira došlo do izuzetka ili ne, datoteke treba zatvoriti
            ulaz.close();
        }
        return gradovi;
    }

    public String toString() {
        String result = "";
        result += this.getNaziv() + ",";
        result += Arrays.toString(this.getTemperature().toArray()).replaceAll("\\[|\\]|\\s","");
        return result;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public int getBrojStanovnika() {
        return brojStanovnika.get();
    }

    public SimpleIntegerProperty brojStanovnikaProperty() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika.set(brojStanovnika);
    }

    public ArrayList<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(ArrayList<Double> temperature) {
        this.temperature = temperature;
    }

}
