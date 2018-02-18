package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.TypeIncident;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;

import java.util.stream.Collectors;

public class HistoriqueIncidentsController extends Controllers {
    @FXML
    private TitledPane titledPane;

    @FXML
    private Button retour;

    @FXML
    private TableView<Incident> tableViewTout, tableViewSanitaire, tableViewMateriel, tableViewOrganisation, tableViewAutre;

    @FXML
    private TableColumn<Incident,String> typeColumnTout,descriptionColumnTout,dateColumnTout;

    @FXML
    private TableColumn<Incident,String> typeColumnSanitaire,descriptionColumnSanitaire,dateColumnSanitaire;

    @FXML
    private TableColumn<Incident,String> typeColumnMateriel,descriptionColumnMateriel,dateColumnMateriel;

    @FXML
    private TableColumn<Incident,String> typeColumnOrganisation,descriptionColumnOrganisation,dateColumnOrganisation;

    @FXML
    private TableColumn<Incident,String> typeColumnAutre,descriptionColumnAutre,dateColumnAutre;
    

    @FXML
    public void initialize(){
        typeColumnTout.setCellValueFactory(cellData ->cellData.getValue().getTypeIncident().getLabel());
        descriptionColumnTout.setCellValueFactory(cellData ->cellData.getValue().descriptionProperty());
        dateColumnTout.setCellValueFactory(cellData -> cellData.getValue().getDate().dateProperty());

        typeColumnSanitaire.setCellValueFactory(cellData ->cellData.getValue().getTypeIncident().getLabel());
        descriptionColumnSanitaire.setCellValueFactory(cellData ->cellData.getValue().descriptionProperty());
        dateColumnSanitaire.setCellValueFactory(cellData -> cellData.getValue().getDate().dateProperty());

        typeColumnMateriel.setCellValueFactory(cellData ->cellData.getValue().getTypeIncident().getLabel());
        descriptionColumnMateriel.setCellValueFactory(cellData ->cellData.getValue().descriptionProperty());
        dateColumnMateriel.setCellValueFactory(cellData -> cellData.getValue().getDate().dateProperty());

        typeColumnOrganisation.setCellValueFactory(cellData ->cellData.getValue().getTypeIncident().getLabel());
        descriptionColumnOrganisation.setCellValueFactory(cellData ->cellData.getValue().descriptionProperty());
        dateColumnOrganisation.setCellValueFactory(cellData -> cellData.getValue().getDate().dateProperty());

        typeColumnAutre.setCellValueFactory(cellData ->cellData.getValue().getTypeIncident().getLabel());
        descriptionColumnAutre.setCellValueFactory(cellData ->cellData.getValue().descriptionProperty());
        dateColumnAutre.setCellValueFactory(cellData -> cellData.getValue().getDate().dateProperty());

        tableViewTout.setItems(MainApp.getIncidents());
        tableViewSanitaire.setItems(MainApp.getSpecificIncidents(TypeIncident.SANITAIRE));
        tableViewMateriel.setItems(MainApp.getSpecificIncidents(TypeIncident.MATERIEL));
        tableViewOrganisation.setItems(MainApp.getSpecificIncidents(TypeIncident.ORGANISATION));
        tableViewAutre.setItems(MainApp.getSpecificIncidents(TypeIncident.AUTRE));

    }


    @FXML
    public void handleRetourButton(){
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titledPane,"Fenetre Acceuil");
    }
}
