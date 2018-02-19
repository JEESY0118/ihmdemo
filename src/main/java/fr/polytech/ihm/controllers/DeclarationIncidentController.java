package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.controllers.Controllers;
import fr.polytech.ihm.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class DeclarationIncidentController extends Controllers {
    @FXML
    private Button annuler;

    @FXML
    private Button ajouter;

    @FXML
    private TitledPane titledPane;

    @FXML
    private TextField textFieldNom,textFieldPrenom,textFieldDeclarationBreve,textFieldLocalisation;

    @FXML
    private TextArea textAreaInformationsComplementaires;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox choiceBoxTypeIncident, choiceBoxDegreImportance;

    @FXML
    public void initialize(){
        choiceBoxDegreImportance.setItems(FXCollections.observableArrayList("CRITIQUE", "MOYEN", "NONCRITIQUE"));
        choiceBoxTypeIncident.setItems(FXCollections.observableArrayList( "SANITAIRE", "MATERIEL","ORGANISATION","AUTRE"));
    }

    @FXML
    void handleAnnulerButton() {
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titledPane,"Fenetre Acceuil");
    }

    @FXML
    void handleAjouterButton() {
        if(textFieldNom.getText().isEmpty() || textFieldPrenom.getText().isEmpty() || choiceBoxTypeIncident.getValue()==null || textFieldDeclarationBreve.getText().isEmpty()){
            System.out.println(" Remplissez le formulaire correctement");
            return;
        }
        String fxmlFile = "/fxml/ConfirmationDeclarationIncident.fxml";
        showScene(fxmlFile, titledPane,"Confirmation Declaration Incident");
        addIncident();
    }

    public void addIncident(){
        String nom = textFieldNom.getText();
        String prenom = textFieldPrenom.getText();
        User user = new User(nom, prenom);

        String declarationBreve = textFieldDeclarationBreve.getText();

        String localisation = textFieldLocalisation.getText();

        Lieu lieu = new Lieu(localisation);

        String informationsComplementaires = textAreaInformationsComplementaires.getText();

        Date date = new Date(MainApp.getDateTimeFormatter().format(datePicker.getValue()));

        TypeIncident typeIncident = TypeIncident.valueOf(choiceBoxTypeIncident.getValue().toString());

        DegreImportance degreImportance = DegreImportance.valueOf(choiceBoxDegreImportance.getValue().toString());

        Incident incident = new Incident(user, typeIncident, declarationBreve, date, lieu, degreImportance, informationsComplementaires);

        MainApp.getIncidents().add(incident);
    }
}
