package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class ApercuDeclarationController extends Controllers{
    @FXML
    private Button retour;

    @FXML
    private TitledPane titlesPane;

    @FXML
    private Button modifier;

    @FXML
    public void handleRetourButton() {
        String fxmlFile = "/fxml/HistoriqueIncidents.fxml";
        showScene(fxmlFile, titlesPane,"Historique");
    }

    @FXML
    public void handleModifierButton() {
        String fxmlFile = "/fxml/ModificationDeclaration.fxml";
        showScene(fxmlFile, titlesPane,"Modification");

    }


}
