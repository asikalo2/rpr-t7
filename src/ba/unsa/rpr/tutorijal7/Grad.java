package ba.unsa.rpr.tutorijal7;

/* Klasa ​Grad​​ sadrži atribute: naziv (string), broj stanovnika (int) i temperature
(običan niz od 1000 elemenata tipa double). */

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Grad {

    private SimpleStringProperty naziv;
    private SimpleIntegerProperty broj_stanovnika;
    private SimpleDoubleProperty[] temperature = new SimpleDoubleProperty[1000];


    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika.get();
    }

    public SimpleIntegerProperty broj_stanovnikaProperty() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika.set(broj_stanovnika);
    }

    public SimpleDoubleProperty[] getTemperature() {
        return temperature;
    }

    public void setTemperature(SimpleDoubleProperty[] temperature) {
        this.temperature = temperature;
    }

}
