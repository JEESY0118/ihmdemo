package fr.polytech.ihm;

import fr.polytech.ihm.model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    private static ObservableList<Incident> incidents = FXCollections.observableArrayList();

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        incidents.clear();
        initializeIncidents();

        log.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/FenetreAcceuil.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    public static ObservableList<Incident> getIncidents(){return incidents;}

    public static ObservableList<Incident> getSpecificIncidents(TypeIncident typeIncident){
        ObservableList<Incident> specificIncident = FXCollections.observableArrayList();
        switch(typeIncident){
            case SANITAIRE:
                for(Incident incident : getIncidents()){
                    if(incident.getTypeIncident() == TypeIncident.SANITAIRE)
                        specificIncident.add(incident);
                }
                break;
            case MATERIEL:
                for(Incident incident : getIncidents()){
                    if(incident.getTypeIncident() == TypeIncident.MATERIEL)
                        specificIncident.add(incident);
                }
                break;
            case ORGANISATION:
                for(Incident incident : getIncidents()){
                    if(incident.getTypeIncident() == TypeIncident.ORGANISATION)
                        specificIncident.add(incident);
                }
                break;
            case AUTRE:
                for(Incident incident : getIncidents()){
                    if(incident.getTypeIncident() == TypeIncident.AUTRE)
                        specificIncident.add(incident);
                }
                break;
        }
        return specificIncident;
    }

    public static DateTimeFormatter getDateTimeFormatter(){return formatter;}

    private void initializeIncidents(){
        if(incidents.isEmpty()){
            User user = new User("Lazrak","Sami");
            Lieu lieu = new Lieu("O+135");
            Date date = new Date(formatter.format(LocalDate.parse("16/01/2018", formatter)));
            Incident incident = new Incident(user, TypeIncident.ORGANISATION, "Tableau non effacé", date, lieu, DegreImportance.NONCRITIQUE, "");

            User user1 = new User("Wei","Wang");
            Lieu lieu1 = new Lieu("Toilettes");
            Date date1 = new Date(formatter.format(LocalDate.parse("01/02/2018", formatter)));
            Incident incident1 = new Incident(user, TypeIncident.ORGANISATION, "Pas de papier toilette",date1, lieu, DegreImportance.CRITIQUE, "");

            User user2 = new User("Theo","Bonnet");
            Lieu lieu2 = new Lieu("Parking");
            Date date2 = new Date(formatter.format(LocalDate.parse("16/02/2018", formatter)));
            Incident incident2 = new Incident(user, TypeIncident.AUTRE, "Pas assez de place", date2, lieu, DegreImportance.MOYEN, "");

            User user3 = new User("Bastien","Gillet");
            Lieu lieu3 = new Lieu("O+229");
            Date date3 = new Date(formatter.format(LocalDate.parse("13/01/2018", formatter)));
            Incident incident3 = new Incident(user, TypeIncident.MATERIEL, "Pas assez de prises", date3, lieu, DegreImportance.NONCRITIQUE, "");

            User user4 = new User("Djebbar","Gabriel");
            Lieu lieu4 = new Lieu("Toilettes");
            Date date4 = new Date(formatter.format(LocalDate.parse("28/01/2018", formatter)));
            Incident incident4 = new Incident(user, TypeIncident.SANITAIRE, "Trop sale", date4, lieu, DegreImportance.CRITIQUE, "");

            incidents.add(incident);
            incidents.add(incident1);
            incidents.add(incident2);
            incidents.add(incident3);
            incidents.add(incident4);
        }
    }
}
