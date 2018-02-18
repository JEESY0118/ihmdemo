package fr.polytech.ihm.model;

public enum DegreImportance {
    CRITIQUE("Critique"),
    MOYEN("Moyen"),
    NONCRITIQUE("Non-critique");

    private String label;
    DegreImportance(String label){this.label = label;}
}
