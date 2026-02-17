package org.spanishapp;

public class Flashcard {
    private final String polish;
    private final String spanish;

    public Flashcard(String polish, String spanish) {
        this.polish = polish;
        this.spanish = spanish;
    }

    // Getters
    public String getPolish() { return polish; }
    public String getSpanish() { return spanish; }
}
