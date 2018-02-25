package fr.polytech.ihm.controllers;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public abstract class Controllers {

    public void showScene(String fxmlFile, Parent element, String titleStage){
        FXMLLoader loader = new FXMLLoader();
        try {
             Stage stage=(Stage) element.getScene().getWindow();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
            Scene scene = new Scene(rootNode);
            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
            stage.setTitle(titleStage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translationAnimation(TranslateTransition translateAnimation){
        translateAnimation.setCycleCount(4);
        translateAnimation.setAutoReverse(true);
        translateAnimation.setByY(10);
        translateAnimation.rateProperty().setValue(2);
        translateAnimation.setInterpolator(Interpolator.LINEAR);
        translateAnimation.play();
    }

    public void errorFormAnimation(TextField textFieldNom, TextField textFieldPrenom, ChoiceBox choiceBoxTypeIncident, TextField textFieldDeclaration, ChoiceBox choiceBoxDegreImportance , DatePicker datePicker){
            if(textFieldNom.getText().isEmpty()){
                final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(0.5), textFieldNom);
                translationAnimation(translateAnimation);

            }
            if(textFieldPrenom.getText().isEmpty()){
                final TranslateTransition translateAnimation1 = new TranslateTransition(Duration.seconds(0.5), textFieldPrenom);
                translationAnimation(translateAnimation1);
            }
            if(choiceBoxTypeIncident.getValue()==null){
                final TranslateTransition translateAnimation2 = new TranslateTransition(Duration.seconds(0.5), choiceBoxTypeIncident);
                translationAnimation(translateAnimation2);
            }
            if(textFieldDeclaration.getText().isEmpty()){
                final TranslateTransition translateAnimation3 = new TranslateTransition(Duration.seconds(0.5), textFieldDeclaration);
                translationAnimation(translateAnimation3);
            }
            if(choiceBoxDegreImportance.getValue()==null){
                final TranslateTransition translateAnimation4 = new TranslateTransition(Duration.seconds(0.5), choiceBoxDegreImportance);
                translationAnimation(translateAnimation4);
            }

            if(datePicker.getValue()==null){
                final TranslateTransition translateAnimation5 = new TranslateTransition(Duration.seconds(0.5), datePicker);
                translationAnimation(translateAnimation5);
            }

    }


    }
