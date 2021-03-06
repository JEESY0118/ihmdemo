package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.controllers.Controllers;
import fr.polytech.ihm.model.*;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.time.LocalDate;

public class DeclarationIncidentController extends Controllers {
    @FXML
    private Button annuler;

    @FXML
    private Button ajouter;

    @FXML
    private Label labelNom, labelPrenom, labelTypeIncident, labelDeclaration, labelDegreImportance, labelDatePicker;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField textFieldNom,textFieldPrenom,textFieldDeclarationBreve,textFieldLocalisation,textFieldRole;

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
        showScene(fxmlFile, gridPane,"Fenetre d'Acceuil");
    }

    @FXML
    void handleAjouterButton() {
        if(textFieldNom.getText().isEmpty() || textFieldPrenom.getText().isEmpty() || choiceBoxTypeIncident.getValue()==null || textFieldDeclarationBreve.getText().isEmpty() || choiceBoxDegreImportance.getValue()==null || datePicker.getValue()==null){
            System.out.println(" Remplissez le formulaire correctement");
            errorFormAnimation(textFieldNom,textFieldPrenom,choiceBoxTypeIncident,textFieldDeclarationBreve,choiceBoxDegreImportance,datePicker);
            changeColorErrorForm();
            return;
        }
        String fxmlFile = "/fxml/ConfirmationDeclarationIncident.fxml";
        showScene(fxmlFile, gridPane,"Confirmation Declaration Incident");
        addIncident();
    }

    //
    public void addIncident(){
        String nom = textFieldNom.getText();
        String prenom = textFieldPrenom.getText();
        User user = new User(nom, prenom);

        String role = textFieldRole.getText();

        String declarationBreve = textFieldDeclarationBreve.getText();

        String localisation = textFieldLocalisation.getText();

        Lieu lieu = new Lieu(localisation);

        String informationsComplementaires = textAreaInformationsComplementaires.getText();

        Date date = new Date(MainApp.getDateTimeFormatter().format(datePicker.getValue()));

        TypeIncident typeIncident = TypeIncident.valueOf(choiceBoxTypeIncident.getValue().toString());

        DegreImportance degreImportance = DegreImportance.valueOf(choiceBoxDegreImportance.getValue().toString());

        Incident incident = new Incident(user, role, typeIncident, declarationBreve, date, lieu, degreImportance, informationsComplementaires);

        MainApp.getIncidents().add(incident);
    }

    public void changeColorErrorForm(){
        if(textFieldNom.getText().isEmpty()){
            labelNom.setTextFill(Color.RED);
        }
        if(textFieldPrenom.getText().isEmpty()){
            labelPrenom.setTextFill(Color.RED);
        }
        if(choiceBoxTypeIncident.getValue()==null){
            labelTypeIncident.setTextFill(Color.RED);
        }
        if(textFieldDeclarationBreve.getText().isEmpty()){
            labelDeclaration.setTextFill(Color.RED);
        }
        if(choiceBoxDegreImportance.getValue()==null){
            labelDegreImportance.setTextFill(Color.RED);
        }
        if(datePicker.getValue()==null){
            labelDatePicker.setTextFill(Color.RED);
        }
        if(!textFieldNom.getText().isEmpty()){
            labelNom.setTextFill(Color.BLACK);
        }
        if(!textFieldPrenom.getText().isEmpty()){
            labelPrenom.setTextFill(Color.BLACK);
        }
        if(!(choiceBoxTypeIncident.getValue()==null)){
            labelTypeIncident.setTextFill(Color.BLACK);
        }
        if(!textFieldDeclarationBreve.getText().isEmpty()){
            labelDeclaration.setTextFill(Color.BLACK);
        }
        if(!(choiceBoxDegreImportance.getValue()==null)){
            labelDegreImportance.setTextFill(Color.BLACK);
        }
        if(!(datePicker.getValue()==null)){
            labelDatePicker.setTextFill(Color.BLACK);
        }

    }
}
