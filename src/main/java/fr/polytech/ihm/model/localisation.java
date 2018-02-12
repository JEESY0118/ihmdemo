package fr.polytech.ihm.model;

import javafx.beans.property.StringProperty;

public class Localisation {
    private StringProperty localisation;

    public String getLocalisation(){return localisation.get();}
    public StringProperty localisationProperty(){return localisation;}
}
