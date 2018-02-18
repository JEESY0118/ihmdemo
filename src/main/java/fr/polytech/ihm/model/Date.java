package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Date {
    private StringProperty date;

    public Date(String date){
        this.date = new SimpleStringProperty(date);
    }

    public StringProperty dateProperty() { return date; }
    public String getDate(){return date.toString();}
}
