package ba.unsa.rpr.tutorijal7;

/*Klasa ​UN​​ sadrži samo ArrayList<Drzava>.*/

import java.io.Serializable;
import java.util.ArrayList;

public class UN implements Serializable {
    private ArrayList<Drzava> drzave;

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }
}
