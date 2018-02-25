package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class ConfirmationDeclarationIncidentController extends Controllers {
    @FXML
    private Button retourAuMenu;

    @FXML
    private BorderPane borderPane;


    @FXML
    private void handleRetourButton(){
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, borderPane, "Acceuil");
    }

}
