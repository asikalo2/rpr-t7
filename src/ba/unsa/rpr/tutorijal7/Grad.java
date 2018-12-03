package ba.unsa.rpr.tutorijal7;

/* Klasa ​Grad​​ sadrži atribute: naziv (string), broj stanovnika (int) i temperature
(običan niz od 1000 elemenata tipa double). */

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
