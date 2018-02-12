package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class HistoriqueIncidentsController extends Controllers {
    @FXML
    private TitledPane titledPane;

    @FXML
    private Button retour;

    @FXML
    public void handleRetourButton(){
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titledPane,"Fenetre Acceuil");
    }
}
