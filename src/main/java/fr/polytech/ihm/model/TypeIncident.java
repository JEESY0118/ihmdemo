package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum TypeIncident {
    TOUT("Tout"),
    SANITAIRE("Sanitaire"),
    MATERIEL("Materiel"),
    ORGANISATION("Organisation"),
    AUTRE("Autre");

    private StringProperty label;

    TypeIncident(String label){this.label= new SimpleStringProperty(label);}

    public StringProperty getLabel(){return label;}
}
