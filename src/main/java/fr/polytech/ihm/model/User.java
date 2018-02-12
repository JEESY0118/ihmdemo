package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private StringProperty nom;
    private StringProperty prenom;

    public User(String nom,String prenom){
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }

    public String getNom(){return nom.get();}
    public StringProperty nomProperty(){return nom;}

    public String getPrenom(){return prenom.get();}
    public StringProperty prenomProperty(){return prenom;}
}
