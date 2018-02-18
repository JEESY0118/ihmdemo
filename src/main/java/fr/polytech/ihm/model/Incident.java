package fr.polytech.ihm.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;


public class Incident {

    private User user;
    private TypeIncident typeIncident;
    private StringProperty description;
    private Date date;
    private Lieu lieu;
    private DegreImportance degreImportance;
    private StringProperty informationsComplementaires;

    public Incident(User user, TypeIncident typeIncident, String description,Date date, Lieu lieu, DegreImportance degreImportance, String informationsComplementaires){
        this.user = user;
        this.typeIncident= typeIncident;
        this.description= new SimpleStringProperty(description);
        this.date= date;
        this.lieu = lieu;
        this.degreImportance= degreImportance;
        this.informationsComplementaires= new SimpleStringProperty(informationsComplementaires);
    }

    public User getUser(){return this.user;}

    public TypeIncident getTypeIncident(){return typeIncident;}

    public String getDescription(){return description.get();}
    public StringProperty descriptionProperty(){return description;}

    public Date getDate(){return date;}

    public DegreImportance getDegreImportance(){return this.degreImportance;}

    public String getInformationsComplementaires(){return informationsComplementaires.get();}
    public StringProperty informationsComplementairesProperty(){return informationsComplementaires;}



}
