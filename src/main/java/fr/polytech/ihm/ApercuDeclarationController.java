package fr.polytech.ihm;

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
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titlesPane,"Acceuil");
    }

    @FXML
    public void handleModifierButton() {
        String fxmlFile = "/fxml/ModificationDéclaration.fxml";
        showScene(fxmlFile, titlesPane,"Modification");

    }


}
