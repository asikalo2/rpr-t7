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

public class Grad {

    private SimpleStringProperty naziv;
    private SimpleIntegerProperty brojStanovnika;
    private SimpleListProperty<Double> temperature = new SimpleListProperty<Double>();

    public Grad(String a, Integer n, Double[] g) {
        naziv = new SimpleStringProperty(a);
        brojStanovnika = new SimpleIntegerProperty(n);
        temperature = new SimpleListProperty<Double>();
        ObservableList<Double> temp = FXCollections.observableArrayList(g);
        temperature.set(temp);
    }

    public Grad() {
        naziv = new SimpleStringProperty("");
        brojStanovnika = new SimpleIntegerProperty(0);
        temperature = new SimpleListProperty<Double>();
    }

    public static ArrayList<Grad> ucitajGradove(){
        ArrayList<Grad> gradovi = new ArrayList<>();
        Scanner ulaz;
        String novinaziv = "";
        Scanner inputStream = null;
        int vel = 0;

        // Konstruisanje ulaznog toka za datoteku brojevi.txt
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti.");
            System.out.println("Greška: " + e);
            return null; // kraj programa
        }

        try {
            // Učitavamo brojeve
            while (ulaz.hasNext()) {
              /*  String line = inputStream.nextLine();
                if (line.startsWith(Grad.getNaziv())) {
                    novinaziv = inputStream.next();
                } else {
                    System.out.println("error");
                }
                inputStream.nextLine();*/




              //  gradovi[vel] = new Grad();
              //  gradovi[vel].setNaziv(novinaziv);
            //    gradovi[vel].setTemperature();
              //  gradovi.add(ulaz.nextLine());
            }

        } catch(Exception e) {
            System.out.println("Problem pri čitanju/pisanju podataka.");
            System.out.println("Greška: " + e);

        } finally {
            // Bez obzira došlo do izuzetka ili ne, datoteke treba zatvoriti
            ulaz.close();
        }
        return gradovi;
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

    public SimpleListProperty<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(SimpleListProperty<Double> temperature) {
        this.temperature = temperature;
    }

}
