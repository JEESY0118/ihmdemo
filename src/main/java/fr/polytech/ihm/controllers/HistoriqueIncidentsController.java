package fr.polytech.ihm.controllers;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.TypeIncident;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

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

        showApercuOnClick(tableViewAutre);
        showApercuOnClick(tableViewSanitaire);
        showApercuOnClick(tableViewMateriel);
        showApercuOnClick(tableViewOrganisation);
        showApercuOnClick(tableViewTout);
    }


    @FXML
    public void handleRetourButton(){
        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        showScene(fxmlFile, titledPane,"Fenetre Acceuil");
    }

    public void showApercuOnClick(TableView<Incident> table){
        table.setRowFactory(tv -> {
            TableRow<Incident> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Incident clickedRow = row.getItem();
                    FXMLLoader loader = new FXMLLoader();
                    String fxmlFile = "/fxml/ApercuDeclaration.fxml";
                    try {
                        Stage stage=(Stage) titledPane.getScene().getWindow();
                        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                        Scene scene = new Scene(rootNode);

                        ((ApercuDeclarationController) loader.getController()).initIncident(clickedRow);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        }
        );
    }
}

