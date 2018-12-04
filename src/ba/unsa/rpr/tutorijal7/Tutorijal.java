package ba.unsa.rpr.tutorijal7;


/*Klasa ​Tutorijal​​ treba sadržavati main funkciju koja za sada ne radi ništa. */

import javafx.beans.property.SimpleListProperty;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Tutorijal {
    public static void main(String[] args) {
        ArrayList<Double> t = new ArrayList<Double>();
        t.add(-1.0); t.add(-2.1);
        Grad n1 = new Grad("Sarajevo", 400000, t);
        //System.out.println(n.getNaziv());
        //System.out.println(n.getTemperature());

        ArrayList<Grad> gradovi = Grad.ucitajGradove();
        for (Grad grad : gradovi) {
            System.out.println(grad);
        }

        UN un = ucitajXml(gradovi);
        for (Drzava d : un.getDrzave()) {
            System.out.println(d.getNaziv() + " " +  d.getBroj_stanovnika() + " " +
                    d.getGlavni_grad());
        }

        zapisiXML(un);
    }

    public static UN ucitajXml(ArrayList<Grad> gradovi) {
        UN un = new UN();
        ArrayList<Drzava> drzave = new ArrayList<Drzava>();
        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File(Tutorijal.class.getResource("drzave.xml").getFile()));
            NodeList nList = xmldoc.getElementsByTagName("drzava");


            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node instanceof Element) {
                    Element e = (Element) node;
                    String naziv = e.getElementsByTagName("naziv").item(0).getTextContent();
                    int brojStanovnika = Integer.parseInt(e.getAttribute("stanovnika"));
                    int povrsina = Integer.parseInt(e.getElementsByTagName("povrsina").item(0).getTextContent());

                    String jedinica = e.getElementsByTagName("povrsina").item(0).
                            getAttributes().item(0).getTextContent();

                    Element glavnigrad = (Element) e.getElementsByTagName("glavnigrad").item(0);
                    String glavnigradNaziv = glavnigrad.getElementsByTagName("naziv").item(0).getTextContent();
                    int glavnigradStanovnika = Integer.parseInt(glavnigrad.getAttribute("stanovnika"));
                    ArrayList<Double> t = new ArrayList<Double>();
                    Grad gGrad = new Grad(glavnigradNaziv, glavnigradStanovnika, t);
                    for (int j = 0; j < gradovi.size(); j++) {
                        //System.out.println(gradovi.get(j));
                        if (gGrad.getNaziv().equals(gradovi.get(j).getNaziv())) {
                            gGrad.setTemperature(gradovi.get(j).getTemperature());
                        }
                    }
                    Drzava drzava = new Drzava(naziv, brojStanovnika, povrsina, jedinica, gGrad);
                    drzave.add(drzava);
                }

            }
            un.setDrzave(drzave);
            return un;

        } catch (Exception e) {
            System.out.println("nema datoteke");
        }

        return un;
    }

    public static void zapisiXML(UN un) {
        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("un.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("nije mogao kreirati xml datoteku");
        }
        encoder.writeObject(un);
        encoder.close();

    }
}
