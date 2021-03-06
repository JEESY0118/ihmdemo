package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.time.LocalDate;


public class ModificationDeclarationController extends Controllers {

    private Incident incidentAModifier;

    @FXML
    private Label labelNom1,labelPrenom,labelIncident,labelDeclaration,labelDatePicker;


    @FXML
    private Button cancel;

    @FXML
    private Button update;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField textFieldNom, textFieldPrenom, textFieldDeclaration, textFieldLocalisation, textFieldRole;

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
        textFieldRole.setText(incidentAModifier.getRole());
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
        showScene(fxmlFile,gridPane,"Acceuil");
    }

    //
    @FXML
    public void handleUpdateButton(){
        if(textFieldNom.getText().isEmpty() || textFieldPrenom.getText().isEmpty() || choiceBoxTypeIncident.getValue()==null || textFieldDeclaration.getText().isEmpty() || choiceBoxDegreImportance.getValue()==null || datePicker.getValue()==null){
            System.out.println(" Remplissez le formulaire correctement");
            errorFormAnimation(textFieldNom,textFieldPrenom,choiceBoxTypeIncident,textFieldDeclaration,choiceBoxDegreImportance,datePicker);
            changeColorErrorForm();
            return;
        }
        remplaceIncident();
        String fxmlFile = "/fxml/ConfirmationDeclarationIncident.fxml";
        showScene(fxmlFile,gridPane,"Confirmation déclaration incident");

        //
    }

    public void remplaceIncident(){
        String nom = textFieldNom.getText();
        String prenom = textFieldPrenom.getText();
        User user = new User(nom, prenom);
        String role = textFieldRole.getText();
        String declarationBreve = textFieldDeclaration.getText();

        String localisation = textFieldLocalisation.getText();

        Lieu lieu = new Lieu(localisation);

        String informationsComplementaires = textAreaInformationsComplementaires.getText();

        Date date = new Date(MainApp.getDateTimeFormatter().format(datePicker.getValue()));

        TypeIncident typeIncident = TypeIncident.valueOf(choiceBoxTypeIncident.getValue().toString());

        DegreImportance degreImportance = DegreImportance.valueOf(choiceBoxDegreImportance.getValue().toString());

        MainApp.getIncidents().remove(incidentAModifier);
        Incident incident = new Incident(user, role, typeIncident, declarationBreve, date, lieu, degreImportance, informationsComplementaires);
        MainApp.getIncidents().add(incident);
    }


    public void changeColorErrorForm(){
        if(textFieldNom.getText().isEmpty()){
            labelNom1.setTextFill(Color.RED);
        }
        if(textFieldPrenom.getText().isEmpty()){
            labelPrenom.setTextFill(Color.RED);
        }
        if(choiceBoxTypeIncident.getValue()==null){
            labelIncident.setTextFill(Color.RED);
        }
        if(textFieldDeclaration.getText().isEmpty()){
            labelDeclaration.setTextFill(Color.RED);
        }
        if(datePicker.getValue()==null){
            labelDatePicker.setTextFill(Color.RED);
        }
        if(!textFieldNom.getText().isEmpty()){
            labelNom1.setTextFill(Color.BLACK);
        }
        if(!textFieldPrenom.getText().isEmpty()){
            labelPrenom.setTextFill(Color.BLACK);
        }
        if(!(choiceBoxTypeIncident.getValue()==null)){
            labelIncident.setTextFill(Color.BLACK);
        }
        if(!textFieldDeclaration.getText().isEmpty()){
            labelDeclaration.setTextFill(Color.BLACK);
        }
        if(!(datePicker.getValue()==null)){
            labelDatePicker.setTextFill(Color.BLACK);
        }

    }




}
