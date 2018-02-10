package fr.polytech.ihm;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Incident {

    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty typeIncident;
    private StringProperty description;
    private StringProperty date;
    private StringProperty localisation;
    private IntegerProperty degreImportance;
    private StringProperty informationsComplementaires;

    public Incident(String nom, String prenom, String typeIncident, String description, String date, String localisation,Integer degreImportance, String informationsComplementaires){
        this.nom= new SimpleStringProperty(nom);
        this.prenom= new SimpleStringProperty(prenom);
        this.typeIncident= new SimpleStringProperty(typeIncident);
        this.description= new SimpleStringProperty(description);
        this.date= new SimpleStringProperty(date);
        this.localisation=new SimpleStringProperty(localisation);
        this.degreImportance= new SimpleIntegerProperty(degreImportance);
        this.informationsComplementaires= new SimpleStringProperty(informationsComplementaires);
    }

    public String getNom(){return nom.get();}
    public StringProperty nomProperty(){return nom;}

    public String getPrenom(){return prenom.get();}
    public StringProperty prenomProperty(){return prenom;}

    public String getTypeIncident(){return typeIncident.get();}
    public StringProperty typeIncidentProperty(){return typeIncident;}

    public String getDescription(){return description.get();}
    public StringProperty descriptionProperty(){return description;}

    public String getDate(){return date.get();}
    public StringProperty dateProperty(){return date;}

    public String getLocalisation(){return localisation.get();}
    public StringProperty localisationProperty(){return localisation;}

    public String getDegreImportance(){return nom.toString();}
    public IntegerProperty degreImportanceProperty(){return degreImportance;}

    public String getInformationsComplementaires(){return informationsComplementaires.get();}
    public StringProperty informationsComplementairesProperty(){return informationsComplementaires;}



}
