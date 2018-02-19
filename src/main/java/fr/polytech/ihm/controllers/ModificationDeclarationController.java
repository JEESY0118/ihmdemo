package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;


public class ModificationDeclarationController extends Controllers {

    private Incident incidentAModifier;

    @FXML
    private Button cancel;

    @FXML
    private Button update;

    @FXML
    private TitledPane titledPane;

    @FXML
    private TextField textFieldNom, textFieldPrenom, textFieldDeclaration, textFieldLocalisation;

    @FXML
    private ChoiceBox choiceBoxDegreImportance, choiceBoxTypeIncident;

    @FXML
    private TextArea textAreaInformationsComplementaires;

    @FXML
    private DatePicker datePicker;


    @FXML
    public void initialize(){
        choiceBoxDegreImportance.setItems(FXCollections.observableArrayList("CRITIQUE", "MOYEN", "NONCRITIQUE"));
        choiceBoxTypeIncident.setItems(FXCollections.observableArrayList( "SANITAIRE", "MATERIEL","ORGANISATION","AUTRE"));
    }

    public void modifierIncident(Incident incidentAModifier) {
        this.incidentAModifier = incidentAModifier;
        textFieldNom.setText(incidentAModifier.getUser().getNom());
        textFieldPrenom.setText(incidentAModifier.getUser().getPrenom());
        textFieldDeclaration.setText(incidentAModifier.getDescription());
        textFieldLocalisation.setText(incidentAModifier.getLieu().getLieu());
        choiceBoxTypeIncident.setValue(incidentAModifier.getTypeIncident().toString());
        choiceBoxDegreImportance.setValue(incidentAModifier.getDegreImportance().toString());
        datePicker.setValue(LocalDate.parse(incidentAModifier.getDate().getDate(),MainApp.getDateTimeFormatter()));
        textAreaInformationsComplementaires.setText(incidentAModifier.getInformationsComplementaires());
    }

    @FXML
    public void handleCancelButton(){
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile,titledPane,"Acceuil");
    }

    @FXML
    public void handleUpdateButton(){
        remplaceIncident();
        String fxmlFile = "/fxml/ConfirmationDeclarationIncident.fxml";
        showScene(fxmlFile,titledPane,"Confirmation déclaration incident");
    }

    public void remplaceIncident(){
        String nom = textFieldNom.getText();
        String prenom = textFieldPrenom.getText();
        User user = new User(nom, prenom);

        String declarationBreve = textFieldDeclaration.getText();

        String localisation = textFieldLocalisation.getText();

        Lieu lieu = new Lieu(localisation);

        String informationsComplementaires = textAreaInformationsComplementaires.getText();

        Date date = new Date(MainApp.getDateTimeFormatter().format(datePicker.getValue()));

        TypeIncident typeIncident = TypeIncident.valueOf(choiceBoxTypeIncident.getValue().toString());

        DegreImportance degreImportance = DegreImportance.valueOf(choiceBoxDegreImportance.getValue().toString());

        MainApp.getIncidents().remove(incidentAModifier);
        Incident incident = new Incident(user, typeIncident, declarationBreve, date, lieu, degreImportance, informationsComplementaires);
        MainApp.getIncidents().add(incident);
    }


}
