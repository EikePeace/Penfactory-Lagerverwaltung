package database.controller;

import javafx.collections.FXCollections;
import database.Main;
import database.model.ImExport;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import database.model.Article;

public class StorageManagementController {

    static  String PruefString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static int  PlatzNr = 0;
    static int MaxPlatzNr = 0;
    static boolean NameVergeben = false;
    static int NameVergebenPlatzNr = 0;
    static boolean Aenderung = false;

    //Zugriff auf die Textfelder
    @FXML
    private static TextField ArtikelbezeichnungTxt;
    @FXML
    private static TextField LagernummerTxt;
    @FXML
    private static TextField GewichtTxt;
    @FXML
    private static TextField AnzahlTxt;
    @FXML
    private static TextField KategorieTxt;
    @FXML
    private static TextField PreisTxt;


    //Zugriff auf die Tabelle
    @FXML
    private static TableView StorageTable;
    @FXML
    private static TableColumn<Article, String> ArtikelbezeichnungTable;
    @FXML
    private static TableColumn<Article, Integer> LagernummerTable;
    @FXML
    private static TableColumn<Article, Double> GewichtTable;
    @FXML
    private static TableColumn<Article, String> KategorieTable;
    @FXML
    private static TableColumn<Article, Integer> AnzahlTable;
    @FXML
    private static TableColumn<Article, Double> PreisTable;



    //Alle Artikel anzeigen
    public void showAll() {

        //Daten werden geleert
        Main.data = FXCollections.observableArrayList();
        //Neue Daten werden aufgrund der gewünschten Operation geladen
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_gew[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
            } else {
                i++;
            }
        }
        //Daten werden angezeigt
        populate();
    }

    public static void search() {
        String bezSearch = ArtikelbezeichnungTxt.getText();
        int plaSearch = Integer.parseInt(LagernummerTxt.getText());
        double gewSearch = 0.0;
        if (GewichtTxt.getText() !="") {
            gewSearch = Double.parseDouble(GewichtTxt.getText());
        }
        String katSearch = KategorieTxt.getText();
        double preSearch = 0.0;
        if (PreisTxt.getText() !="") {
            preSearch = Double.parseDouble(PreisTxt.getText());
        }

        if (bezSearch != ("")){
            if (Integer.toString(plaSearch) != "") {
                if (GewichtTxt.getText() != "") {
                    if (katSearch != "") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && bezSearch.equals(Main.array_bez[i])
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch
                                        && katSearch.equals(Main.array_kat[i])
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
                else {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pla[i] == plaSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
            }
            else {
                if (GewichtTxt.getText() != "") {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_gew[i] == gewSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
                else {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_bez[i] == bezSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            if (Integer.toString(plaSearch) !="") {
                if (GewichtTxt.getText() != "") {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_gew[i] == gewSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
                else {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pla[i] == plaSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
            }
            else {
                if (GewichtTxt.getText() != "") {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_gew[i] == gewSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_gew[i] == gewSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
                else {
                    if (katSearch!="") {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_kat[i] == katSearch
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_kat[i] == katSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                    else {
                        if (PreisTxt.getText() != "") {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0
                                        && Main.array_pre[i] == preSearch) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                        else {
                            Main.data = FXCollections.observableArrayList();
                            for (int i = 0; i < Main.array_anz.length; i++) {
                                if (Main.array_gew[i] != 0) {
                                    Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
                                }
                            }
                        }
                    }
                }
            }
        }
        populate();
    }



    public static void add() {
        // Artikel wird hinzugefügt, falls alle Eingabefelder gültige Eingaben enthalten sobald auch nur eine Eingabe ungültig ist, wird eine Fehlermeldung ausgegeben
        if (PlatznummerPruefung(LagernummerTxt.getText()) && StueckzahlPruefung(AnzahlTxt.getText()) &&
                PreisPruefung(PreisTxt.getText()) && GewichtPruefung(GewichtTxt.getText()) && NamePruefung(ArtikelbezeichnungTxt.getText())) {
            // überprüfe, ob der Lagerplatz leer ist
            PlatzNr = Integer.parseInt(LagernummerTxt.getText());
            if (Main.array_pla[PlatzNr - 1] == 0) {
                // überprüfe, ob sich bereits ein Artikel mit dem selben Namen im Lager befindet
                for (int i = 0; i < MaxPlatzNr; i++) {
                    if (Aenderung) {
                        break;
                    } else {
                        if (Main.array_bez[i] == ArtikelbezeichnungTxt.getText()) {
                            NameVergeben = true;
                            NameVergebenPlatzNr = i + 1;
                        } else {
                            NameVergeben = false;
                        }
                    }
                }
                if (NameVergeben == false) {
                    if (PlatzNr > MaxPlatzNr) {
                        MaxPlatzNr = PlatzNr;
                    }
                    Main.array_pla[PlatzNr - 1] = PlatzNr;
                    Main.array_anz[PlatzNr - 1] = Integer.parseInt(AnzahlTxt.getText());
                    Main.array_pre[PlatzNr - 1] = Double.parseDouble(PreisTxt.getText());
                    Main.array_gew[PlatzNr - 1] = Double.parseDouble(GewichtTxt.getText());
                    Main.array_bez[PlatzNr - 1] = ArtikelbezeichnungTxt.getText();
                    Main.array_kat[PlatzNr - 1] = KategorieTxt.getText();
                    System.out.println("Der Artikel wurde erfolgreich am Lagerplatz Nummer " + String.valueOf(PlatzNr) + " hinzugefügt!");
                    Aenderung = false;
                } else {
                    System.out.println("Ein Artikel mit diesem Namen befindet sich bereits am Lagerplatz Nummer " +
                            String.valueOf(NameVergebenPlatzNr) + "!");
                }

            } else {
                System.out.println("Lagerplatz ist bereits durch den Artikel " + String.valueOf(Main.array_pla[PlatzNr - 1]) + " belegt!");
            }

        } else {
            System.out.println("Unvollständige oder fehlerhafte Eingabe! Bitte geben Sie eine gültige Eingabe in jedem Feld ein!");
            System.out.println("Beachten Sie, dass ä, ö, ü und ß als ae, oe, ue und ss geschrieben werden müssen!");
        }
        Main.data = FXCollections.observableArrayList();
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_gew[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
            } else {
                i++;
            }
        }
        populate();
    }

    public void update() {

        Aenderung = true;
        PlatzNr = Integer.parseInt(LagernummerTxt.getText());
        Main.array_pla[PlatzNr - 1] = 0;
        Main.array_anz[PlatzNr - 1] = 0;
        Main.array_pre[PlatzNr - 1] = 0;
        Main.array_gew[PlatzNr - 1] = 0;
        Main.array_bez[PlatzNr - 1] = "";
        Main.array_kat[PlatzNr - 1] = "";
        System.out.println("Artikel wurde erfolgreich gelöscht!");
        add();
        System.out.println("Artikel erfolgreich geändert");
    }

    public void delete(){
            PlatzNr = Integer.parseInt(LagernummerTxt.getText());
            Main.array_pla[PlatzNr - 1] = 0;
            Main.array_anz[PlatzNr - 1] = 0;
            Main.array_pre[PlatzNr - 1] = 0;
            Main.array_gew[PlatzNr - 1] = 0;
            Main.array_bez[PlatzNr - 1] = "";
            Main.array_kat[PlatzNr - 1] = "";
            System.out.println("Artikel wurde erfolgreich gelöscht!");

        Main.data = FXCollections.observableArrayList();
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_gew[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_pre[i], Main.array_anz[i], Main.array_kat[i]));
            } else {
                i++;
            }
        }
        populate();
    }

    private static void populate() {
        ArtikelbezeichnungTable.setCellValueFactory(new PropertyValueFactory<Article, String>("artikelbezeichnung"));
        LagernummerTable.setCellValueFactory(new PropertyValueFactory<Article, Integer>("lagernummer"));
        GewichtTable.setCellValueFactory(new PropertyValueFactory<Article, Double>("gewicht"));
        AnzahlTable.setCellValueFactory(new PropertyValueFactory<Article, Integer>("anzahl"));
        KategorieTable.setCellValueFactory(new PropertyValueFactory<Article, String>("kategorie"));
        PreisTable.setCellValueFactory(new PropertyValueFactory<Article, Double>("preis"));
        StorageTable.setItems(Main.data);
        export();
    }

    public static void export() {
        ImExport IO = new ImExport();
            IO.ExportFunktion(Main.array_anz, Main.array_bez, Main.array_kat, Main.array_gew, Main.array_pre, Main.array_pla, "C:\\Database\\Testfile.txt");
    }

    // konvertiere die Platznummer-Eingabe in Integerwert > 0 falls möglich, sonst ungültige Eingabe
    public static boolean PlatznummerPruefung(String PlatznummerEingabe) {
        try {
            int Platznummer = Integer.parseInt(PlatznummerEingabe);
            if (Platznummer > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            // falls Konvertierung nicht möglich, gib "false" = ungültige Eingabe zurück
            return false;
        }
    }

    // konvertiere die Stückzahl-Eingabe in Integerwert > 0 falls möglich, sonst ungültige Eingabe
    public static boolean StueckzahlPruefung(String StueckzahlEingabe) {
        try {
            int Stueckzahl = Integer.parseInt(StueckzahlEingabe);
            if (Stueckzahl > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // konvertiere die Preis-Eingabe in Double-Wert > 0 falls möglich, sonst ungültige Eingabe
    public static boolean PreisPruefung(String PreisEingabe) {
        try {
            Double Preis = Double.parseDouble(PreisEingabe);
            if (Preis > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // konvertiere die Gewicht-Eingabe in Double-Wert > 0 falls möglich, sonst ungültige Eingabe
    public static boolean GewichtPruefung(String GewichtEingabe) {
        try {
            Double Gewicht = Double.parseDouble(GewichtEingabe);
            if (Gewicht > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // überprüfe, ob die Name-Eingabe nur Buchstaben enthält
    public static boolean NamePruefung(String NameEingabe) {
        int i = 0;
        while (i < NameEingabe.length()) {
            int j = 0;
            while (j < PruefString.length()) {
                // Vergleiche Name-Eingabe mit Prüfstring falls Übereinstimmung, so ist i-tes Element ein Buchstabe und die Schleife wird vorzeitig abgebrochen
                if (NameEingabe.charAt(i) == PruefString.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j > PruefString.length() - 1) {
                // j wird nur größer als die Länge von Pruefstring, wenn jedes Element erfolglos durchlaufen, also kein Buchstabe gefunden wurde
                // falls keine Übereinstimmung, dann vorzeitiger Abbruch der äußeren Schleife
                return false;
            }
            if (i == NameEingabe.length() - 1) {
                // falls i genauso groß wie die Länge der Name-Eingabe ist, wurde die Schleife nicht vorzeitig abgebrochen
                // jedes Element ist also ein Buchstabe und die Eingabe somit gültig
                return true;
            }
            i++;
        }
        return false;
    }

}