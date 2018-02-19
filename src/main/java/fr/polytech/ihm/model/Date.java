package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Date {
    private StringProperty dateProperty;
    private String date;


    public Date(String date){
        this.dateProperty = new SimpleStringProperty(date);
        this.date=date;
    }

    public StringProperty dateProperty() { return dateProperty; }
    public String getDate(){return date;}
}
