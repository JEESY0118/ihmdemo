package fr.polytech.ihm;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

        String fxmlFile = "/fxml/HistoriqueIncidents.fxml";
        showScene(fxmlFile);


    }

    @FXML
    public void handleDeclareButton(){

        String fxmlFile = "/fxml/DeclarationIncident.fxml";
        showScene(fxmlFile);

    }

    public void showScene(String fxmlFile){
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) anchorPane.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
