package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;


public class FenetreAcceuilController extends Controllers {

    @FXML
    private Button declare;

    @FXML
    private Button historique;

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    public void handleHistoriqueButton() {
        String fxmlFile = "/fxml/HistoriqueIncidents.fxml";
        showScene(fxmlFile,anchorPane,"Historique Incidents");
    }

    @FXML
    public void handleDeclareButton(){
        String fxmlFile = "/fxml/DeclarationIncident.fxml";
        showScene(fxmlFile,anchorPane,"Declaration Incident");
    }
}
