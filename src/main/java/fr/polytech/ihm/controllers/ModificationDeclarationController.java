package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;


public class ModificationDeclarationController extends Controllers {

    @FXML
    private Button cancel;

    @FXML
    private Button update;

    @FXML
    private TitledPane titledPane;

    @FXML
    public void handleCancelButton(){

        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile,titledPane,"Acceuil");
    }

    @FXML
    public void handleUpdateButton(){
        String fxmlFile = "/fxml/ConfirmationDeclarationIncident.fxml";
        showScene(fxmlFile,titledPane,"Confirmation déclaration incident");
    }

}
