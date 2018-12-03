package ba.unsa.rpr.tutorijal7;


/*Klasa ​Tutorijal​​ treba sadržavati main funkciju koja za sada ne radi ništa. */

public class Tutorijal {
    public static void main(String[] args) {
        Double[] t = {1.0, 2.1, 3.2, 4.5, -2.1};
        Grad n = new Grad("Sarajevo", 400000, t);
        System.out.println(n.getNaziv());
        System.out.println(n.getTemperature());
    }
}
