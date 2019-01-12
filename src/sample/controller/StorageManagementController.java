package sample.controller;

import javafx.collections.FXCollections;
import sample.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Article;

public class StorageManagementController {
    //Zugriff auf die Textfelder
    @FXML
    private TextField ArtikelbezeichnungTxt;
    @FXML
    private TextField LagernummerTxt;
    @FXML
    private TextField GewichtTxt;
    @FXML
    private TextField AnzahlTxt;
    @FXML
    private TextField KategorieTxt;


    //Zugriff auf die Tabelle
    @FXML
    private TableView StorageTable;
    @FXML
    private TableColumn<Article, String> ArtikelbezeichnungTable;
    @FXML
    private TableColumn<Article, Integer> LagernummerTable;
    @FXML
    private TableColumn<Article, Double> GewichtTable;
    @FXML
    private TableColumn<Article, String> KategorieTable;
    @FXML
    private TableColumn<Article, Double> Platzhalter;
    @FXML
    private TableColumn<Article, Integer> AnzahlTable;


    //Alle Artikel anzeigen
    public void showAll() {

        //Daten werden geleert
        Main.data = FXCollections.observableArrayList();
        //Neue Daten werden aufgrund der gewünschten Operation geladen
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_pla[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_anz[i], Main.array_kat[i]));
            }
            else{
                break;
            }
        }
        //Daten werden angezeigt
        populate();
    }

    public void Search(){
        Main.data = FXCollections.observableArrayList();
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_pla[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_anz[i], Main.array_kat[i]));
            }
            else{
                break;
            }
        }
        populate();

    }

    public void Add(){
        Main.data = FXCollections.observableArrayList();
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_pla[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_anz[i], Main.array_kat[i]));
            }
            else{
                break;
            }
        }
        populate();
    }

    public void Update(){
        Main.data = FXCollections.observableArrayList();
        for (int i = 0; i < Main.array_anz.length; i++) {
            if (Main.array_pla[i] != 0) {
                Main.data.add(new Article(Main.array_bez[i], Main.array_pla[i], Main.array_gew[i], Main.array_anz[i], Main.array_kat[i]));
            }
            else{
                break;
            }
        }
        populate();
    }


    private void populate(){
        ArtikelbezeichnungTable.setCellValueFactory(new PropertyValueFactory<Article, String>("artikelbezeichnung"));
        LagernummerTable.setCellValueFactory(new PropertyValueFactory<Article, Integer>("lagernummer"));
        GewichtTable.setCellValueFactory(new PropertyValueFactory<Article, Double>("gewicht"));
        AnzahlTable.setCellValueFactory(new PropertyValueFactory<Article, Integer>("anzahl"));
        KategorieTable.setCellValueFactory(new PropertyValueFactory<Article, String>("kategorie"));
        StorageTable.setItems(Main.data);
    }
}