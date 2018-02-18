package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lieu {
    private StringProperty lieu;

    public Lieu(String lieu){
        this.lieu = new SimpleStringProperty(lieu);
    }
    
    public String getLieu(){return lieu.get();}
    public StringProperty lieuProperty(){return lieu;}
}