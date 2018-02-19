package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;


public class ConfirmationDeclarationIncidentController extends Controllers {
    @FXML
    private Button retourAuMenu;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TitledPane titledPane;

    @FXML
    private void handleRetourButton(){
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile,titledPane,"Acceuil");
    }

}
