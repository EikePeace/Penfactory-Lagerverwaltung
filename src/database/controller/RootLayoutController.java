package database.controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
public class RootLayoutController {
    //Help Menu button behavior
    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Programminformation");
        alert.setHeaderText("Über das Lagerverwaltungssystem:");
        alert.setContentText("Um einen Artikel hinzuzufügen füllen sie bitte alle Felder aus und klicken auf \"Artikel hinzufügen\"" +
                        "Um zu suchen reicht es eines oder alle der Suchfelder auszufüllen und auf den entsprechenden Button zu drücken");
        alert.show();
    }
}