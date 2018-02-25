package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.Incident;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ApercuDeclarationController extends Controllers{
    private Incident apercuIncident;

    @FXML
    private Button retour,modifier,supprimer;

    @FXML
    private TitledPane titledPane;

    @FXML
    private Label labelNom, labelPrenom, labelTypeIncident, labelDeclaration, labelDate, labelLocalisation, labelDegreImportance, labelInformationsComplementaires;

    @FXML
    public void handleRetourButton() {
        String fxmlFile = "/fxml/HistoriqueIncidents.fxml";
        showScene(fxmlFile, titledPane,"Historique");
    }

    @FXML
    public void handleSupprimerButton(){
        MainApp.getIncidents().remove(apercuIncident);
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titledPane,"Acceuil");
    }

    @FXML
    public void handleModifierButton() {
        String fxmlFile = "/fxml/ModificationDeclaration.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) titledPane.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            Scene scene = new Scene(rootNode);
            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());


            ((ModificationDeclarationController) loader.getController()).modifierIncident(apercuIncident);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initIncident(Incident incident) {
        apercuIncident = incident;
        labelNom.setText(apercuIncident.getUser().getNom());
        labelPrenom.setText(apercuIncident.getUser().getPrenom());
        labelTypeIncident.setText(apercuIncident.getTypeIncident().toString());
        labelDeclaration.setText(apercuIncident.getDescription().toString());
        labelDate.setText(apercuIncident.getDate().getDate());
        labelLocalisation.setText(apercuIncident.getLieu().getLieu());
        labelDegreImportance.setText(apercuIncident.getDegreImportance().toString());
        labelInformationsComplementaires.setText(apercuIncident.getInformationsComplementaires());
    }

}
