package database;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import database.model.Article;
import database.model.ImExport;

import java.io.IOException;
public class Main extends Application {

    public static ObservableList<Article> data = FXCollections.observableArrayList();
    public static int[] array_anz;
    public static String[] array_bez;
    public static String[] array_kat;
    public static double[] array_gew;
    public static double[] array_pre;
    public static int[] array_pla;
    private Stage primaryStage;
    private BorderPane rootLayout;
    //Fetching der Import/ExportFunktion
    ImExport IO = new ImExport();
    @Override
    public void start(Stage primaryStage) {
        //Erstellt eine Stage für die GUI
        this.primaryStage = primaryStage;
        //Name der Application wird erstellt
        this.primaryStage.setTitle("Penfactory Lagerverwaltung");
        //Lädt die benötigten Teile der Gui
        initRootLayout();
        showStorageManagementView();
    }
    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to theScene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Shows the employee operations view inside the root layout.
    public void showStorageManagementView() {
        try {
            //First, load EmployeeOperationsView from EmployeeOperations.fxml
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Main.class.getResource("view/StorageManagement.fxml"));
            AnchorPane StorageManagement = (AnchorPane) loader.load();
            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(StorageManagement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Maximale Größe der Datanbank
        int size = 200000;
        //Erstellen der benötigten Arrays
        array_anz =new int[size];
        array_bez = new String[size];
        array_kat = new String[size];
        array_gew = new double[size];
        array_pre = new double[size];
        array_pla = new int[size];
        //Fetching der Import/ExportFunktion
        ImExport IO = new ImExport();
        IO.ImportFunktion(array_anz,array_bez,array_kat,array_gew,array_pre,array_pla, "C:\\Database\\Testfile.txt");
        launch(args);

    }

}
