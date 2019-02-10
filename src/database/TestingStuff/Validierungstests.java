package database.TestingStuff;


import database.Main;
import database.model.Article;
import database.controller.StorageManagementController;
import database.model.ImExport;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.runtime.StoredScript;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static database.controller.StorageManagementController.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Validierungstests {

    //public static void main(String[] args) {
    //    Validierungstests x = new Validierungstests();

    //}

    // fields ..........................................

    Article articleTest;



    // methods to prepare stuff for tests ........................................

    //prepare test 1) korrekte Speicherung eines artikels
    void prepareKorrekteSpeicherungTest() {

        // set up Beispiel artikel this.articleTest
        String bezExample = "testBezeichung";
        int plaExample = 5;
        double gewExample = 3.2;
        double preExample = 1.234;
        int anzExample = 5;
        String katExample = "kategorieExample";

        this.articleTest = new Article(bezExample,plaExample,gewExample,preExample,anzExample,katExample);
    }


    // actual tests methods ......................................................

    // Teil 1)
    @Test
    void korrekteSpeicherungTest() {

        // speichere artikel
        prepareKorrekteSpeicherungTest();
        saveArticle(articleTest);

        // retrieve saved article

        Article retrievedArticle = retrivePreviouslySavedArticle(articleTest.getLagernummer());

        // now compare articleTest and retrievedArticle

        assertEquals(articleTest.getAnzahl(),retrievedArticle.getAnzahl());
        assertEquals(articleTest.getArtikelbezeichnung(),retrievedArticle.getArtikelbezeichnung());
        assertEquals(articleTest.getKategorie(),retrievedArticle.getKategorie());
        assertEquals(articleTest.getGewicht(),retrievedArticle.getGewicht(),0.0001);
        assertEquals(articleTest.getLagernummer(),retrievedArticle.getLagernummer());
        assertEquals(articleTest.getPreis(),retrievedArticle.getPreis(), 0.0001);


    }


    //Teil 2)
    @Test
    void testIfKategorieDublicateCreatesError() throws Exception {
        Article article = new Article("Bezeichnung1",1,1,1,1,"Kathegorie");
        Article articleSameBez = new Article("Bezeichnung", 2,2,2,2,"Kath2");

        Assertions.assertThrows(Exception.class, () -> {
            // add code here to add two article with same Bezeichnung to see if it throws Exeption
            TextField ArtikelbezeichnungTxt = new TextField(article.getArtikelbezeichnung());
            TextField LagernummerTxt = new TextField(Integer.toString(article.getLagernummer()));
            TextField GewichtTxt = new TextField(Double.toString(article.getGewicht()));
            TextField AnzahlTxt = new TextField(Integer.toString(article.getAnzahl()));
            TextField KategorieTxt = new TextField(article.getKategorie());
            TextField PreisTxt = new TextField(Double.toString(article.getPreis()));
            StorageManagementController.add();

            ArtikelbezeichnungTxt = new TextField(articleSameBez.getArtikelbezeichnung());
            LagernummerTxt = new TextField(Integer.toString(articleSameBez.getLagernummer()));
            GewichtTxt = new TextField(Double.toString(articleSameBez.getGewicht()));
            AnzahlTxt = new TextField(Integer.toString(articleSameBez.getAnzahl()));
            KategorieTxt = new TextField(articleSameBez.getKategorie());
            PreisTxt = new TextField(Double.toString(articleSameBez.getPreis()));
            StorageManagementController.add();
        });

    }
    @Test
    void testIfPlatznummerDublicateCreatesError() throws Exception {
        Article article = new Article("Bezeichnung1",1,1,1,1,"Kathegorie");
        Article articleSamePla = new Article("andereBezeichnung", 2,3,3,3,"Kathegorie");

        Assertions.assertThrows(Exception.class, () -> {
            // add code here to add two article with same Platznummer to see if it thorws Exeption
            TextField ArtikelBezeichnungtxt = new TextField(article.getArtikelbezeichnung());
            TextField LagernummerTxt = new TextField(Integer.toString(article.getLagernummer()));
            TextField GewichtTxt = new TextField(Double.toString(article.getGewicht()));
            TextField AnzahlTxt = new TextField(Integer.toString(article.getAnzahl()));
            TextField KategorieTxt = new TextField(article.getKategorie());
            TextField PreisTxt = new TextField(Double.toString(article.getPreis()));
            StorageManagementController.add();

            ArtikelBezeichnungtxt = new TextField(articleSamePla.getArtikelbezeichnung());
            LagernummerTxt = new TextField(Integer.toString(articleSamePla.getLagernummer()));
            GewichtTxt = new TextField(Double.toString(articleSamePla.getGewicht()));
            AnzahlTxt = new TextField(Integer.toString(articleSamePla.getAnzahl()));
            KategorieTxt = new TextField(articleSamePla.getKategorie());
            PreisTxt = new TextField(Double.toString(articleSamePla.getPreis()));
            StorageManagementController.add();
        });

    }

    //Teil 3)
    @Test
    void verifySuchfunktion() {

        addArticleToDataBase();

        String[] searchPhrases = {"Tippex 10x", "Locher 25 Blatt rot", "Kopierpapier 10x 500", "Tuppex 10x"};

        TextField ArtikelbezeichnungTxt = new TextField();
        for (String searchPhrase : searchPhrases) {
            StorageManagementController.search();
            if (Main.data.get(0).getArtikelbezeichnung().equals(searchPhrases[0])) {
                assertEquals(Main.data.get(0).getAnzahl(), 48);
                assertEquals(Main.data.get(0).getArtikelbezeichnung(), searchPhrases[0]);
                assertEquals(Main.data.get(0).getKategorie(), "Korrekturflüssigkeit");
                assertEquals(Main.data.get(0).getGewicht(), 0.55,0.0001);
                assertEquals(Main.data.get(0).getLagernummer(), 1168);
                assertEquals(Main.data.get(0).getPreis(), 15.50, 0.0001);
            }
            if (Main.data.get(0).getArtikelbezeichnung().equals(searchPhrases[1])) {
                assertEquals(Main.data.get(0).getAnzahl(), 37);
                assertEquals(Main.data.get(0).getArtikelbezeichnung(), searchPhrases[1]);
                assertEquals(Main.data.get(0).getKategorie(), "Büromaterial");
                assertEquals(Main.data.get(0).getGewicht(), 0.24,0.0001);
                assertEquals(Main.data.get(0).getLagernummer(), 2471);
                assertEquals(Main.data.get(0).getPreis(), 6.25, 0.0001);
            }
            if (Main.data.get(0).getArtikelbezeichnung().equals(searchPhrases[2])) {
                assertEquals(Main.data.get(0).getAnzahl(), 513);
                assertEquals(Main.data.get(0).getArtikelbezeichnung(), searchPhrases[2]);
                assertEquals(Main.data.get(0).getKategorie(), "Papier");
                assertEquals(Main.data.get(0).getGewicht(), 25.00,0.0001);
                assertEquals(Main.data.get(0).getLagernummer(), 2001);
                assertEquals(Main.data.get(0).getPreis(), 35.95, 0.0001);
            }
            if (Main.data.get(0).getArtikelbezeichnung().equals(searchPhrases[3])) {
                assertEquals(Main.data.get(0).getAnzahl(), 48);
                assertEquals(Main.data.get(0).getArtikelbezeichnung(), searchPhrases[3]);
                assertEquals(Main.data.get(0).getKategorie(), "Korrekturflüssigkeit");
                assertEquals(Main.data.get(0).getGewicht(), 0.55,0.0001);
                assertEquals(Main.data.get(0).getLagernummer(), 1168);
                assertEquals(Main.data.get(0).getPreis(), 15.50, 0.0001);
            }
        }


    }



    // utility methods ..............................................................

    void saveArticle(Article article) {
        // to do: article eingeben in DataBase und diese exportieren
        int PlatzNr = article.getLagernummer();
        Main.array_pla[PlatzNr - 1] = PlatzNr;
        Main.array_anz[PlatzNr - 1] = article.getAnzahl();
        Main.array_pre[PlatzNr - 1] = article.getPreis();
        Main.array_gew[PlatzNr - 1] = article.getGewicht();
        Main.array_bez[PlatzNr - 1] = article.getArtikelbezeichnung();
        Main.array_kat[PlatzNr - 1] = article.getKategorie();
        ImExport IO = new ImExport();
        IO.ExportFunktion(Main.array_anz, Main.array_bez, Main.array_kat, Main.array_gew, Main.array_pre, Main.array_pla, "C:\\Database\\Testfile.txt");
    }


    Article retrivePreviouslySavedArticle(int PlatzNr) {
        //to do: retrieve and return the article that was previously saved, (to compare it with original article in next step
        ImExport IO = new ImExport();
        IO.ImportFunktion(Main.array_anz, Main.array_bez, Main.array_kat, Main.array_gew, Main.array_pre, Main.array_pla, "C:\\Database\\Testfile.txt");
        int i = PlatzNr;
        Article savedArticle = new Article(Main.array_bez[PlatzNr], Main.array_pla[i],Main.array_gew[i],Main.array_pre[i],Main.array_anz[i],Main.array_kat[i]);

        return savedArticle;
    }

    Article[] getArrayOfArticle() {
        Article[] arr = new Article[10];

        String[] names = {"Stift blau", "Stift schwarz", "Tippex 3x", "Locher 25 Blatt rot", "Post-it Block weiß", "Hefter 100x bunt",
                "Textmarker 3x neongrün", "Kopierpapier 10x 500", "Trennstreifen 5x 100 bunt"};
        int[] LPs = {12,13,1167, 1168,2471, 83,513, 722,2001,1993};
        double[] Gws = {0.01,0.01,0.16,0.55,0.24,0.30,4.50,20.00,25.00,0.024};
        double[] Ps ={0.60,0.60,4.95,15.50,6.25,2.15,25.00,3.50,35.95,25.00};
        int[] Anzs = { 360,130,97,48,37,460,179,255,513,83};
        String[] Kaths = {"Schreibgeräte", "Schreibgeräte", "Korrekturflüssigkeit",
                "Korrekturflüssigkeit", "Büromaterial", "Notizzettel", "Hefter", "Schreibgeräte", "Papier", "Register"};

        for (int i = 0; i < 10; i++) {
            arr[i] = new Article(names[i],LPs[i], Gws[i], Ps[i], Anzs[i], Kaths[i]);
        }
        return arr;
    }

    private void addArticleToDataBase() {
        Article[] arrayOfArticles = getArrayOfArticle();

        for (Article a : arrayOfArticles) {
            saveArticle(a);
        }

    }

}