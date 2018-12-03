package ba.unsa.rpr.tutorijal7;


/* Klasa ​Drzava​​ sadrži atribute: naziv (string), broj stanovnika (int), površina (double), jedinica za
površinu (string) i glavni grad (referenca na Grad).  */


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Drzava {

    private SimpleStringProperty naziv;
    private SimpleIntegerProperty broj_stanovnika;
    private SimpleDoubleProperty povrsina;
    private SimpleStringProperty jedinica_za_povrsinu;
    Grad glavni_grad;


    public int getBroj_stanovnika() {
        return broj_stanovnika.get();
    }

    public SimpleIntegerProperty broj_stanovnikaProperty() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika.set(broj_stanovnika);
    }

    public double getPovrsina() {
        return povrsina.get();
    }

    public SimpleDoubleProperty povrsinaProperty() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina.set(povrsina);
    }

    public String getJedinica_za_povrsinu() {
        return jedinica_za_povrsinu.get();
    }

    public SimpleStringProperty jedinica_za_povrsinuProperty() {
        return jedinica_za_povrsinu;
    }

    public void setJedinica_za_povrsinu(String jedinica_za_povrsinu) {
        this.jedinica_za_povrsinu.set(jedinica_za_povrsinu);
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


}
