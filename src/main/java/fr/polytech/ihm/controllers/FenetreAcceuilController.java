package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;


public class FenetreAcceuilController extends Controllers {

    @FXML
    private Button declare;

    @FXML
    private Button historique;

    @FXML
    private BorderPane borderPane;
    
    @FXML
    public void handleHistoriqueButton() {
        String fxmlFile = "/fxml/HistoriqueIncidents.fxml";
        showScene(fxmlFile,borderPane,"Historique");
    }

    @FXML
    public void handleDeclareButton(){
        String fxmlFile = "/fxml/DeclarationIncident.fxml";
        showScene(fxmlFile,borderPane,"Declaration Incident");
    }
}
