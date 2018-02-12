package fr.polytech.ihm.controllers;

import fr.polytech.ihm.controllers.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class DeclarationIncidentController extends Controllers {
    @FXML
    private Button annuler;

    @FXML
    private Button ajouter;

    @FXML
    private TitledPane titledPane;

    @FXML
    void handleAnnulerButton() {
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titledPane,"Fenetre Acceuil");

    }

    @FXML
    void handleAjouterButton() {
        String fxmlFile = "/fxml/ConfirmationDeclarationIncident.fxml";
        showScene(fxmlFile, titledPane,"Confirmation Declaration Incident");
    }
}
