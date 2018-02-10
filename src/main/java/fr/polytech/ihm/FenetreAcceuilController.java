package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;


public class FenetreAcceuilController {

    @FXML
    private Button declare;

    @FXML
    private Button historique;

    @FXML
    public void handleDeclareButton(MouseEvent event){
        String fxmlFile = "/fxml/DeclarerIncident.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage=(Stage) declare.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            //((DepartmentController)loader.getController()).initDepartement(clickedRow);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleHistoriqueButton(MouseEvent event){
    }
}
