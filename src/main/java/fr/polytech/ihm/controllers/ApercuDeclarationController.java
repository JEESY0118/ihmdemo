package fr.polytech.ihm.controllers;

import fr.polytech.ihm.model.Incident;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

public class ApercuDeclarationController extends Controllers{
    private static Incident apercuIncident;

    @FXML
    private Button retour;

    @FXML
    private TitledPane titlesPane;

    @FXML
    private Button modifier;

    @FXML
    private Label labelNom, labelPrenom, labelTypeIncident, labelDeclaration, labelDate, labelLocalisation, labelDegreImportance, labelInformationsComplementaires;

    @FXML
    public void initialize(){
        labelNom.setText(apercuIncident.getUser().getNom());
        labelPrenom.setText(apercuIncident.getUser().getPrenom());
        labelTypeIncident.setText(apercuIncident.getTypeIncident().toString());
        labelDeclaration.setText(apercuIncident.getDescription().toString());
        labelDate.setText(apercuIncident.getDescription().toString());
        labelLocalisation.setText(apercuIncident.getDate().getDate());
        labelDegreImportance.setText(apercuIncident.getDegreImportance().toString());
        labelInformationsComplementaires.setText(apercuIncident.getInformationsComplementaires());
    }

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
     public void setApercuIncident(Incident apercuIncident){this.apercuIncident=apercuIncident;}


}
