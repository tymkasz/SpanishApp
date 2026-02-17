package org.spanishapp;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String chapterName;
    private List<Flashcard> flashcards;

    public Chapter(String chapterName) {
        this.chapterName = chapterName;
        this.flashcards = new ArrayList<>();
    }

    // Method for adding flashcards
    public void addFlashcard(Flashcard flashcard) {
        this.flashcards.add(flashcard);
    }

    // Getters
    public String getChapterName() { return chapterName; }
    public List<Flashcard> getFlashcards() { return flashcards; }
}
