package database.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Article {
    private final SimpleStringProperty artikelbezeichnung;
    private final SimpleIntegerProperty lagernummer;
    private final SimpleDoubleProperty gewicht;
    private final SimpleDoubleProperty preis;
    private final SimpleIntegerProperty anzahl;
    private final SimpleStringProperty kategorie;

    public Article(String bez, int pla, double gew, double pre, int anz, String kat){
        this.artikelbezeichnung = new SimpleStringProperty(bez);
        this.lagernummer = new SimpleIntegerProperty(pla);
        this.gewicht = new SimpleDoubleProperty(gew);
        this.preis = new SimpleDoubleProperty(pre);
        this.anzahl = new SimpleIntegerProperty(anz);
        this.kategorie = new SimpleStringProperty(kat);
    }

    public String getArtikelbezeichnung() {
        return artikelbezeichnung.get();
    }
    public void setArtikelbezeichnung(String bez) {
        artikelbezeichnung.set(bez);
    }

    public int  getLagernummer() {
        return lagernummer.get();
    }
    public void setLagernummer(int anz) {
        lagernummer.set(anz);
    }

    public double  getGewicht() {
        return gewicht.get();
    }
    public void setGewicht(double gew) {
        gewicht.set(gew);
    }

    public double  getPreis() {
        return preis.get();
    }
    public void setPreis(double pre) {
        preis.set(pre);
    }

    public int  getAnzahl() {
        return anzahl.get();
    }
    public void setAnzahl(int anz) {
        anzahl.set(anz);
    }

    public String getKategorie() {
        return kategorie.get();
    }
    public void setKategorie(String kat) {
        kategorie.set(kat);
    }


}