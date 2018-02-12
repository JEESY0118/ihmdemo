package fr.polytech.ihm;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;


public class FenetreAcceuilController {

    @FXML
    private Button declare;

    @FXML
    private Button historique;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void handleHistoriqueButton() {
      /*  Stage stage = (Stage) historique.getScene().getWindow();

        String fxmlFile = "/fxml/HistoriqueIncidents.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) anchorPane;

        Scene scene = new Scene(rootNode, 400, 400);

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    */

    }

    @FXML
    public void handleDeclareButton(){
        System.out.println("declare");
    }
}
